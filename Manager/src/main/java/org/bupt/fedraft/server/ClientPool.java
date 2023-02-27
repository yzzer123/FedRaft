package org.bupt.fedraft.server;

import org.bupt.fedraft.beans.NodeInfo;
import org.bupt.fedraft.state.ManagerState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientPool<T extends Client> {

    private static final Logger logger = LoggerFactory.getLogger(ClientPool.class);

    private final Map<Long, T> store;

    private final ManagerState managerState;

    private final ClientCreator<T> creator;

    public ClientPool(ManagerState managerState, ClientCreator<T> creator) {
        store = new ConcurrentHashMap<>();
        this.managerState = managerState;
        this.creator = creator;
    }

    public T getClient(Long id) {
        T client = store.get(id);

        if (client == null) {  // 如果不存在该客户端就创建
            if (logger.isDebugEnabled()) {
                logger.debug("create client with {}", new NodeInfo(id));
            }
            client = creator.newInstance(managerState, id);
            store.put(id, client);
        }
        return client;
    }

    public void close() {
        store.values().forEach(Client::close);
    }

    public interface ClientCreator<T> {

        /**
         * 定义client的初始化方式
         *
         * @param managerState 状态
         * @param id           client的ID
         * @return 返回新的实例
         */
        T newInstance(ManagerState managerState, Long id);
    }

}
