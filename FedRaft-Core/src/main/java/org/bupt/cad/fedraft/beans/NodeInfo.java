package org.bupt.cad.fedraft.beans;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public final class NodeInfo {
    //作为键值key, 内部属性必须是不可变的! to do
    private String ip;
    private int port;
    //private final String ip;

    private int trainerPort;

    public static String idToIp(long id) { //添加静态方法,避免新建对象
        String[] fields = new String[4];
        id >>= 16;
        for (int i = 0; i < 4; i++) {
            fields[3 - i] = String.valueOf(id % (1 << 8));
            id >>= 8;
        }
        return StringUtils.join(fields, ".");
    }

    public NodeInfo(String ip, int port, int trainerPort) {
        setIp(ip).setPort(port).setTrainerPort(trainerPort);
    }

    public NodeInfo(long id) {
        String[] fields = new String[4];
        int trainerPort = (int) (id % (1 << 16));
        id >>= 16;
        int port = (int) (id % (1 << 16));
        id >>= 16;
        for (int i = 0; i < 4; i++) {
            fields[3 - i] = String.valueOf(id % (1 << 8));
            id >>= 8;
        }
        setIp(StringUtils.join(fields, ".")).setPort(port).setTrainerPort(trainerPort);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeInfo nodeInfo = (NodeInfo) o;
        return getIp().equals(nodeInfo.getIp()) && getPort() == nodeInfo.getPort() && getTrainerPort() == nodeInfo.getTrainerPort();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port, trainerPort);
    }

    public long getNodeId() {
        // xxx.xxx.xxx.xxx
        String[] fields = getIp().split("\\.");
        long id = 0L;
        for (String field : fields) {
            id = (id << 8) + Long.parseLong(field);
        }
        id = (id << 32) + ((long) getPort() << 16) + getTrainerPort();
        return id;
    }


    public String getIp() {
        return ip;
    }

    public NodeInfo setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public int getPort() {
        return port;
    }

    public NodeInfo setPort(int port) {
        this.port = port;
        return this;
    }


    @Override
    public String toString() {
        return ip + ':' + port +
                ':' + trainerPort;
    }

    public int getTrainerPort() {
        return trainerPort;
    }

    public NodeInfo setTrainerPort(int trainerPort) {
        this.trainerPort = trainerPort;
        return this;
    }
}
