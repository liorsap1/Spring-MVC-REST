package com.checkpoint.checkpoint.service;

class WifiNetworkNotFoundException extends RuntimeException {

    WifiNetworkNotFoundException(Long id) {
        super("Could not find Wifi Network " + id);
    }
}
