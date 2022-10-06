package org.bupt.cad.fedraft.config;

import org.junit.Test;

public class ConfigurationTest {

    @Test
    public void testGetConf() {
        String trainer_port = Configuration.getString(Configuration.TRAINER_SERVER_PORT);

        System.out.println(trainer_port);
    }

}