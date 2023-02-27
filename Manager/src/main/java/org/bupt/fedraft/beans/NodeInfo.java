package org.bupt.fedraft.beans;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public final class NodeInfo {

    private String ip;
    private int port;

    final private static long E16 = 1 << 16;
    final private static long E8 = 1 << 8;

    public NodeInfo(String ip, int port) {
        setIp(ip).setPort(port);
    }

    public NodeInfo(String zkNodeName) {
        String[] fields = zkNodeName.split(":");
        setIp(fields[0]).setPort(Integer.parseInt(fields[1]));
    }

    public NodeInfo(long id) {
        String[] fields = new String[4];
        int port = (int) (id % E16);
        id >>= 16;
        for (int i = 0; i < 4; i++) {
            fields[3 - i] = String.valueOf(id % E8);
            id >>= 8;
        }
        setIp(StringUtils.join(fields, ".")).setPort(port);
    }

    public static String idToIp(long id) { //添加静态方法,避免新建对象
        String[] fields = new String[4];
        id >>= 16;
        for (int i = 0; i < 4; i++) {
            fields[3 - i] = String.valueOf(id % E8);
            id >>= 8;
        }
        return StringUtils.join(fields, ".");
    }

    public static int idToPort(long id) {
        return (int) (id % E16);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeInfo nodeInfo = (NodeInfo) o;
        return getIp().equals(nodeInfo.getIp()) && getPort() == nodeInfo.getPort();
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
        id = (id << 16) + (long) getPort();
        return id;
    }


    public String getIp() {
        return ip;
    }

    private NodeInfo setIp(String ip) {
        this.ip = !ip.equals("localhost") ? ip : "127.0.0.1";
        return this;
    }

    public int getPort() {
        return port;
    }

    private NodeInfo setPort(int port) {
        this.port = port;
        return this;
    }

    @Override
    public String toString() {
        return ip + ':' + port;
    }
}
