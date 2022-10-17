package org.bupt.cad.fedraft.config;


import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;
import java.util.Iterator;

public class Configuration {

    public final static String MANAGER_SERVER_HOST = "manager.server.host";
    public final static String MANAGER_SERVER_PORT = "manager.server.port";
    public final static String TRAINER_SERVER_PORT = "trainer.server.port";

//    public final static String LOG_MODEL_CHUCK_SIZE = "log.model.chuck-size";

    public final static String MANAGER_TIMER_THREADPOOL_NUM = "manager.timer.threadpool-num";
    public final static String MANAGER_TIMER_TICK_TIME = "manager.timer.tick-time";

    public final static String ZOOKEEPER_HOSTS = "zookeeper.hosts";
    public final static String ZOOKEEPER_TIMEOUT = "zookeeper.timeout";
    public final static String ZOOKEEPER_NAMESPACE = "zookeeper.namespace";
    public final static String ZOOKEEPER_RETRY_TIMES = "zookeeper.retry-times";

    public final static String NODE_THREADPOOL_NUMBERS = "node.threadpool.numbers";
    public final static String NODE_HEARTBEAT_MAX_TIME = "node.heartbeat.max.time";
    public final static String NODE_HEARTBEAT_TIME_INTERVAL = "node.heartbeat.time-interval";

    private static final Logger logger = LogManager.getLogger(Configuration.class.getName());

    private static org.apache.commons.configuration2.Configuration conf = null;

    static {
        try {
            // java working space need to be set in /path/to/FedRaft and config should be put in root dictionary in FedRaft
            // 如果路径下存在配置文件，就访问路径下的，否则访问打包好的资源文件
            File confFile = new File("./conf.properties");
            if (confFile.exists()) {
                conf = new Configurations().properties(confFile);
            } else {
                URL resource = Configuration.class.getClassLoader().getResource("conf.properties");
                conf = new Configurations().properties(resource);
            }
        } catch (ConfigurationException e) {
            logger.error("默认配置文件加载失败" + e.getMessage(), e);
//            System.exit(1);
        }

    }

    public static void setConfigFile(String path) {

        try {  // 读取配置文件 并将其覆盖到原配置中
            PropertiesConfiguration newConf = new Configurations().properties(path);
            Iterator<String> newConfKeys = newConf.getKeys();
            String key;
            while (newConfKeys.hasNext()) {
                key = newConfKeys.next();
                Configuration.set(key, newConf.get(Object.class, key));
            }
        } catch (ConfigurationException e) {
            logger.error("config path error " + e.getMessage(), e);
            System.exit(1);
        }
    }

    public static void set(String key, Object value) {
        conf.setProperty(key, value);
    }

    public static String getString(String key) {
        if (conf == null) {
            return null;
        }
        return conf.getString(key);
    }

    public static int getInt(String key) {
        if (conf == null) {
            return 0;
        }
        return conf.getInt(key);
    }

    public static long getLong(String key) {
        if (conf == null) {
            return 0;
        }
        return conf.getLong(key);
    }

}
