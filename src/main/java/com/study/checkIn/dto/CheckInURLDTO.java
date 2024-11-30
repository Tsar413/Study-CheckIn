package com.study.checkIn.dto;

import java.util.Map;

public class CheckInURLDTO {
    private String host;

    private String port;

    private String path;

    private Map<String, String> query;

    private String protocol;

    public CheckInURLDTO() {
    }

    public CheckInURLDTO(String host, String port, String path, Map<String, String> query, String protocol) {
        this.host = host;
        this.port = port;
        this.path = path;
        this.query = query;
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getQuery() {
        return query;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public String toString() {
        return "CheckInURLDTO{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", path='" + path + '\'' +
                ", query=" + query +
                ", protocol='" + protocol + '\'' +
                '}';
    }
}
