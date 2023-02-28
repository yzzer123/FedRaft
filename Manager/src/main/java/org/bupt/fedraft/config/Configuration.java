package org.bupt.fedraft.config;


import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.Iterator;

public class Configuration {

    public final static String MANAGER_SERVER_HOST = "manager.server.host";
    public final static String MANAGER_SERVER_MAX_THREAD_NUM = "manager.server.max-thread-num";
    public final static String MANAGER_SERVER_MIN_THREAD_NUM = "manager.server.min-thread-num";
    public final static String MANAGER_SERVER_PORT = "manager.server.port";
    public final static String TRAINER_SERVER_PORT_MIN = "trainer.server.port.min";
    public final static String TRAINER_SERVER_PORT_MAX = "trainer.server.port.max";
    public final static String TRAINER_SERVER_FAIL_TIMES = "trainer.server.fail-times";
    public final static String TRAINER_MODEL_HOME = "trainer.model.home";
    public final static String TRAINER_SERVE_LOG_BATCH_SIZE = "trainer.server.log-batch-size";
    public final static String ELECTION_CANDIDATE_TIMEOUT = "election.candidate.timeout";
    public final static String ELECTION_CANDIDATE_QUALIFY_INDEX = "election.candidate.qualify-index";

//    public final static String LOG_MODEL_CHUCK_SIZE = "log.model.chuck-size";

    public final static String MANAGER_TIMER_THREADPOOL_NUM = "manager.timer.threadpool-num";
    public final static String ELECTION_TMP_LEADER_START_TIME = "election.tmp-leader.start-time";
    public final static String MANAGER_TIMER_TICK_TIME = "manager.timer.tick-time";

    public final static String ZOOKEEPER_HOSTS = "zookeeper.hosts";
    public final static String ZOOKEEPER_TIMEOUT = "zookeeper.timeout";
    public final static String ZOOKEEPER_NAMESPACE = "zookeeper.namespace";
    public final static String ZOOKEEPER_RETRY_TIMES = "zookeeper.retry-times";

    public final static String MANAGER_THREADPOOL_NUMBERS = "manager.threadpool.numbers";
    public final static String MANAGER_HEARTBEAT_MAX_TIME = "manager.heartbeat.max.time";
    public final static String MANAGER_HEARTBEAT_TIME_INTERVAL = "manager.heartbeat.time-interval";
    public final static String MANAGER_SYNC_TIME_INTERVAL = "manager.sync.time-interval";
    public final static String MANAGER_SYNC_TIMEOUT = "manager.sync.timeout";
    public final static String MANAGER_HEARTBEAT_TIMEOUT = "manager.heartbeat.timeout";
    public final static String ELECTION_FAIL_MAX_TIMES = "election.fail.max-times";
    public final static String ELECTION_FAIL_MAX_TERMS = "election.fail.max-terms";

    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);
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
