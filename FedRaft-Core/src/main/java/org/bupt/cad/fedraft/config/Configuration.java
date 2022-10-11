package org.bupt.cad.fedraft.config;


import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Configuration {

    public final static String MANAGER_SERVER_HOST = "manager.server.host";
    public final static String MANAGER_SERVER_PORT = "manager.server.port";
    public final static String TRAINER_SERVER_PORT = "trainer.server.port";

    public final static String LOG_MODEL_CHUCK_SIZE = "log.model.chuck-size";

    public final static String ZOOKEEPER_HOSTS = "zookeeper.hosts";
    public final static String ZOOKEEPER_TIMEOUT = "zookeeper.timeout";
    public final static String ZOOKEEPER_NAMESPACE = "zookeeper.namespace";
    public final static String ZOOKEEPER_RETRY_TIMES = "zookeeper.retry-times";

    public final static String NODE_THREADPOOL_NUMBERS = "node.threadpool.numbers";
    public final static String NODE_HEARTBEAT_MAX_TIME = "node.heartbeat.max.time";

    private static final Logger logger = LogManager.getLogger(Configuration.class.getName());

    private static org.apache.commons.configuration2.Configuration conf = null;

    static {
        try {
            // java working space need to be set in /path/to/FedRaft and config should be put in root dictionary in FedRaft
            conf = new Configurations().properties("./conf.properties");
        } catch (ConfigurationException e) {
            logger.error(e.getMessage(), e);
            System.exit(1);
        }

    }

    public static void setConfigFile(String path) {
        PropertiesConfiguration config = null;
        try {  // 重新读取配置
            config = new Configurations().properties(path);
        } catch (ConfigurationException e) {
            logger.error("config path error " + e.getMessage(), e);
            System.exit(1);
        }
        // 设置配置项
        if (config != null) {
            conf = config;
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
