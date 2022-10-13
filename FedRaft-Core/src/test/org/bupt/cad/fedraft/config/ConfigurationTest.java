package org.bupt.cad.fedraft.config;

import org.junit.Test;

public class ConfigurationTest {

    @Test
    public void testGetConf() {
        int anInt = Configuration.getInt(Configuration.NODE_THREADPOOL_NUMBERS);

        System.out.println(anInt);
    }

}