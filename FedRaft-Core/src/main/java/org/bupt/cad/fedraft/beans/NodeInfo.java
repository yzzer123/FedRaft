package org.bupt.cad.fedraft.beans;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public final class NodeInfo {
    //作为键值key, 内部属性必须是不可变的!
    private final String ip;
    private final int port;
    //private final String ip;

    public static String idToIp(long id){ //添加静态方法,避免新建对象
        String[] fields = new String[4];
        id >>= 16;
        for (int i = 0; i < 4; i++) {
            fields[3 - i] = String.valueOf(id % (1 << 8));
            id >>= 8;
        }
        return StringUtils.join(fields, ".");
    }

    public NodeInfo(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public NodeInfo(long id) {
        String[] fields = new String[4];
        int port = (int) (id % (1 << 16));
        id >>= 16;
        for (int i = 0; i < 4; i++) {
            fields[3 - i] = String.valueOf(id % (1 << 8));
            id >>= 8;
        }
        this.ip = (StringUtils.join(fields, "."));
        this.port = port;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeInfo nodeInfo = (NodeInfo) o;
        return getNodeId() == nodeInfo.getNodeId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }

    public long getNodeId() {
        // xxx.xxx.xxx.xxx
        String[] fields = getIp().split("\\.");
        long id = 0L;
        for (String field : fields) {
            id = (id << 8) + Long.parseLong(field);
        }
        id = (id << 16) + getPort();
        return id;
    }


    public String getIp() {
        return ip;
    }


    public int getPort() {
        return port;
    }



    @Override
    public String toString() {
        return "NodeInfo{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}
