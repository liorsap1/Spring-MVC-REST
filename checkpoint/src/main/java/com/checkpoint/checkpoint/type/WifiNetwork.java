package com.checkpoint.checkpoint.type;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Data
@Entity
public class WifiNetwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String auth;
    private Float avg_throughput;
    private DeviceId [] devices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setAuth(String auth) {
        if (auth != null) {
            this.auth = auth;
        }
    }

    public void setAvg_throughput(Float avg_throughput) {
        if (avg_throughput != null) {
            this.avg_throughput = avg_throughput;
        }
    }

    public void setDevices(DeviceId [] devices) {
        if (devices != null) {
            this.devices = devices;
        }
    }

    public String getAuth() {
        return auth;
    }

    public Float getAvg_throughput() {
        return avg_throughput;
    }

    public DeviceId[] getDevices() {
        return devices;
    }
}
