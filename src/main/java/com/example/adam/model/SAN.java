package com.example.adam.model;
import javax.persistence.Entity;

@Entity
public class SAN extends Resource {

    private String friendlyName;

    private String diskSpeed;

    private String fqdn;


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

    public String getFqdn() {
        return fqdn;
    }

    public void setFqdn(String fqdn) {
        this.fqdn = fqdn;
    }

}
