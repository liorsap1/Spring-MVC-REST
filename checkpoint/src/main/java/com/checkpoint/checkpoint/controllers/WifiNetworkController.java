package com.checkpoint.checkpoint.controllers;

import com.checkpoint.checkpoint.type.RequestParamWifi;
import com.checkpoint.checkpoint.type.WifiNetwork;
import com.checkpoint.checkpoint.service.WifiNetworkService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(WifiNetworkController.BASE_URL)
public class WifiNetworkController {

    public static final String BASE_URL = "/my-service/api/network";

    private final WifiNetworkService wifiNetworkService;

    public WifiNetworkController(WifiNetworkService wifiNetworkService) {
        this.wifiNetworkService = wifiNetworkService;
    }

    @GetMapping()
    public WifiNetwork getWifiNetworkById(@RequestParam Long id) {
            return wifiNetworkService.findWifiNetworkById(id);
    }

    @PostMapping("/report")
    @ResponseStatus(HttpStatus.CREATED)
    public WifiNetwork saveWifiNetwork(@RequestBody RequestParamWifi wifiNetwork) {
        return wifiNetworkService.saveWifiNetwork(wifiNetwork);
    }

    @PutMapping("/connect")
    @ResponseStatus(HttpStatus.OK)
    public WifiNetwork updateWifiNetwork(@RequestBody RequestParamWifi wifiNetwork) {
        return wifiNetworkService.updateWifiNetwork(wifiNetwork);
    }
}
