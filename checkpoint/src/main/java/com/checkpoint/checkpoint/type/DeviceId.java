package com.checkpoint.checkpoint.type;

import java.io.Serializable;

public class DeviceId implements Serializable {
    public String id;

    public DeviceId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
