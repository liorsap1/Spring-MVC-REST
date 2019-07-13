package com.checkpoint.checkpoint.service;

import com.checkpoint.checkpoint.type.RequestParamWifi;
import com.checkpoint.checkpoint.type.WifiNetwork;

import java.util.List;

public interface WifiNetworkService {
    WifiNetwork findWifiNetworkById(Long id);

    List<WifiNetwork> findAllWifiNetwork();

    WifiNetwork saveWifiNetwork(RequestParamWifi wifiNetwork);

    WifiNetwork updateWifiNetwork(RequestParamWifi wifiNetwork);
}
