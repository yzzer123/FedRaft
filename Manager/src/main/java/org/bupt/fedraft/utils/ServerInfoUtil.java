package org.bupt.fedraft.utils;

import java.lang.management.ManagementFactory;

public class ServerInfoUtil {


    public static String getPid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        return name.substring(0, name.indexOf("@"));
    }

}
