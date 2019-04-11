package com.bit.armdcrf.entity;

public class Fileserver {
    /**
     * id
     */
    private Short id;

    /**
     * 服务器ip地址
     */
    private String ip;

    /**
     * 服务器端口
     */
    private int port;

    /**
     * 服务器名字
     */
    private String name;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Short getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * 获取服务器ip地址
     *
     * @return ip - 服务器ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置服务器ip地址
     *
     * @param ip 服务器ip地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取服务器端口
     *
     * @return port - 服务器端口
     */
    public int getPort() {
        return port;
    }

    /**
     * 设置服务器端口
     *
     * @param port 服务器端口
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * 获取服务器名字
     *
     * @return name - 服务器名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置服务器名字
     *
     * @param name 服务器名字
     */
    public void setName(String name) {
        this.name = name;
    }
}