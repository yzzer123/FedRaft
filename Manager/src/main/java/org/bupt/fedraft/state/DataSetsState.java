package org.bupt.fedraft.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DataSetsState {

    private static final Logger logger = LoggerFactory.getLogger(DataSetsState.class);

    static final private ConcurrentMap<String, String> map;

    static {

        map = new ConcurrentHashMap<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("./conf/datasets"));
            bufferedReader.lines().forEach(line -> {
                String[] tuples = line.split("=");
                if (tuples.length != 2) {
                    return;
                }
                map.put(tuples[0], tuples[1]);
            });
        } catch (IOException e) {
            logger.error("dataset file reading error" + e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    logger.error("fail to close file reader" + e.getMessage());
                }
            }
        }

    }

    /**
     * @param datasetName name of dataset
     * @return null if dataset doesn't exist, else return the dataset path
     */
    public static String getPath(String datasetName) {
        return map.get(datasetName);
    }

    public static boolean contains(String datasetName) {
        return map.containsKey(datasetName);
    }

    public static void put(String datasetName, String path) {
        map.put(datasetName, path);
    }
}
