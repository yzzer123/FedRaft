package org.bupt.cad.fedraft.config;

import org.junit.Test;

public class ConfigurationTest {

    @Test
    public void testGetConf() {
        int anInt = Configuration.getInt(Configuration.MANAGER_HEARTBEAT_TIMEOUT);

        System.out.println(anInt);
    }


}