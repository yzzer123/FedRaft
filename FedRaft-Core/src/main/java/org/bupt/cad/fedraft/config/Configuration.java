package org.bupt.cad.fedraft.config;


import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Configuration {

    public final static String RAFT_SERVER_HOST = "raft.server.host";
    public final static String RAFT_SERVER_PORT = "raft.server.port";
    public final static String TRAINER_SERVER_PORT = "trainer.server.port";

    public final static String LOG_MODEL_CHUNKSIZE = "log.model.chucksize";

    public final static String NODE_THREADPOOL_NUMBERS = "node.threadpool.numbers";

    private static final Logger logger = LogManager.getLogger(Configuration.class.getName());

    private static org.apache.commons.configuration2.Configuration conf = null;

    static {
        try {
            conf = new Configurations().properties("../conf.properties");
        } catch (ConfigurationException e) {
            logger.error(e.getMessage(), e);
        }

    }

    public static String getString(String key){
        if (conf == null){
            return null;
        }
        return conf.getString(key);
    }

    public static int getInt(String key){
        if (conf == null){
            return 0;
        }
        return conf.getInt(key);
    }

    public static long getLong(String key){
        if (conf == null){
            return 0;
        }
        return conf.getLong(key);
    }

}
