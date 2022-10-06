package org.bupt.cad.fedraft.beans;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class NodeInfo {

    private String ip;
    private int port;
    private float delay;

    public NodeInfo(String ip, int port) {
        setIp(ip);
        setPort(port);
    }

    public NodeInfo(long id) {
        String[] fields = new String[4];
        int port = (int) (id % (1 << 16));
        id >>= 16;
        for (int i = 0; i < 4; i++) {
            fields[3 - i] = String.valueOf(id % (1 << 8));
            id >>= 8;
        }
        setIp(StringUtils.join(fields, "."));
        setPort(port);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeInfo nodeInfo = (NodeInfo) o;
        return getNodeId() == nodeInfo.getNodeId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port, delay);
    }

    public long getNodeId() {
        // xxx.xxx.xxx.xxx
        String[] fields = getIp().split("\\.");
        long id = 0L;
        for (String field : fields) {
            id = (id << 8) + Long.parseLong(field);
        }
        id = (id << 16) + getPort();
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

    public double getDelay() {
        return delay;
    }

    public NodeInfo setDelay(float delay) {
        this.delay = delay;
        return this;
    }

    @Override
    public String toString() {
        return "NodeInfo{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", delay=" + delay +
                '}';
    }
}
