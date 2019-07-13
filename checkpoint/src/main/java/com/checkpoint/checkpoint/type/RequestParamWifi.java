package com.checkpoint.checkpoint.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestParamWifi {

    private String device_id;
    private String auth;
    private Long network_id;
    private Float throughput;

    @JsonCreator
    public RequestParamWifi(@JsonProperty("device_id") String device_id,
                            @JsonProperty("network_id") Object network_id,
                            @JsonProperty("throughput") String throughput,
                            @JsonProperty("auth") String auth) {

        if (network_id != null) {
            this.network_id = Long.parseLong((String) network_id);
        }
        if (throughput != null) {
            this.throughput = Float.parseFloat(throughput);
        }
        if (device_id != null) {
            this.device_id = device_id;
        }
        if (auth != null) {
            this.auth = auth;
        }
    }

    public String getAuth() {
        return auth;
    }

    public String getDevice_id() {
        return device_id;
    }

    public Long getNetwork_id() {
        return network_id;
    }

    public Float getThroughput() {
        return throughput;
    }
}
