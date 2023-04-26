package com.example.adam.dto;

public class ResourceRequest {
    private String friendlyName;
    private String diskSpeed;
    private String hostname;
    private String ipAddress;

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getDiskSpeed() {
        return diskSpeed;
    }

    public void setDiskSpeed(String diskSpeed) {
        this.diskSpeed = diskSpeed;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getFqdn() {
        return fqdn;
    }

    public void setFqdn(String fqdn) {
        this.fqdn = fqdn;
    }

    public boolean isActiveRecord() {
        return activeRecord;
    }

    public void setActiveRecord(boolean activeRecord) {
        this.activeRecord = activeRecord;
    }

    private String fqdn;
    private boolean activeRecord;

}
