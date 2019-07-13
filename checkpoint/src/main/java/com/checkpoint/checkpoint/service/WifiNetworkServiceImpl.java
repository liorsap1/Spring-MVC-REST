package com.checkpoint.checkpoint.service;

import com.checkpoint.checkpoint.type.DeviceId;
import com.checkpoint.checkpoint.type.RequestParamWifi;
import com.checkpoint.checkpoint.type.WifiNetwork;
import com.checkpoint.checkpoint.repositories.WifiNetworkRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;

@Service
public class WifiNetworkServiceImpl implements WifiNetworkService {

    private final WifiNetworkRepository wifiNetworkRepository;

    private final String [] WifiAuth = {"wpa", "public"};

    public WifiNetworkServiceImpl(WifiNetworkRepository wifiNetworkRepository) {
        this.wifiNetworkRepository = wifiNetworkRepository;
    }

    @Override
    public WifiNetwork findWifiNetworkById(@PathVariable Long id) {
        try {
            return wifiNetworkRepository.findById(id).get();
        } catch (Exception e) {
            throw new WifiNetworkNotFoundException(id);
        }
    }

    @Override
    public List<WifiNetwork> findAllWifiNetwork() {
        return wifiNetworkRepository.findAll();
    }

    @Override
    public WifiNetwork saveWifiNetwork(RequestParamWifi wifiNetworkRequest) {
        WifiNetwork toSave = prepareNetworkToPost(wifiNetworkRequest);
        return wifiNetworkRepository.save(toSave);
    }

    @Override
    public WifiNetwork updateWifiNetwork(RequestParamWifi wifiNetworkRequest) {
        Optional<WifiNetwork> find = wifiNetworkRepository.findById(wifiNetworkRequest.getNetwork_id());
        WifiNetwork toSave = prepareNetworkToPut(wifiNetworkRequest, find);
        return wifiNetworkRepository.save(toSave);
    }

    private WifiNetwork prepareNetworkToPost(RequestParamWifi wifiNetworkRequest) {
        WifiNetwork result = new WifiNetwork();
        Optional<WifiNetwork> find = wifiNetworkRepository.findById(wifiNetworkRequest.getNetwork_id());
        if (find.isPresent()) {
            return this.prepareNetworkToPut(wifiNetworkRequest, find);
        } else {
            String auth = wifiNetworkRequest.getAuth();
            if (auth != null && inEnum(auth)) {
                result.setAuth(auth);
            }
            if (wifiNetworkRequest.getNetwork_id() != null) {
                result.setId(wifiNetworkRequest.getNetwork_id());
            }
            if (wifiNetworkRequest.getThroughput() != null && wifiNetworkRequest.getThroughput() >= 0f) {
                result.setAvg_throughput(wifiNetworkRequest.getThroughput());
            } else {
                result.setAvg_throughput(0f);
            }
            if (wifiNetworkRequest.getDevice_id() != null) {
                LinkedList<DeviceId> list = new LinkedList<>();
                DeviceId d = new DeviceId(wifiNetworkRequest.getDevice_id());
                DeviceId [] t = {d};
                result.setDevices(t);
            }
        }
        return result;
    }

    private WifiNetwork prepareNetworkToPut(RequestParamWifi wifiNetworkRequest, Optional<WifiNetwork> find) {
        WifiNetwork result;
        if (find.isPresent()) {
            result = find.get();
            String auth = wifiNetworkRequest.getAuth();
            if (auth != null && inEnum(auth)) {
                result.setAuth(auth);
            }
            String device_Id = wifiNetworkRequest.getDevice_id();
            int numberOfDevices = 0;
            if (device_Id != null) {
                DeviceId d = new DeviceId(device_Id);
                if (result.getDevices() == null) {
                    DeviceId [] t = {d};
                    result.setDevices(t);
                } else {
                    boolean exists = false;
                    DeviceId [] devices = result.getDevices();
                    numberOfDevices = devices.length;
                    for (int i = 0; i < devices.length; i++) {
                        if (devices[i].getId().equals(wifiNetworkRequest.getDevice_id())) {
                            exists = true; break;
                        }
                    }
                    if (!exists) {
                        ArrayList<DeviceId> myList = new ArrayList<>(Arrays.asList(result.getDevices()));
                        myList.add(d);
                        result.setDevices(myList.toArray(result.getDevices()));
                    }
                }
            }
            Float throughput = wifiNetworkRequest.getThroughput();
            if (throughput != null) {
                result.setAvg_throughput(((result.getAvg_throughput()*numberOfDevices) + throughput) / (numberOfDevices + 1));
            }
            return result;
        } else {
            result = new WifiNetwork();
            result.setAvg_throughput(0f);
            String auth = wifiNetworkRequest.getAuth();
            if (auth != null && inEnum(auth)) {
                result.setAuth(auth);
            }
            if (wifiNetworkRequest.getThroughput() != null && wifiNetworkRequest.getThroughput() >= 0f) {
                result.setAvg_throughput(wifiNetworkRequest.getThroughput());
            } else {
                result.setAvg_throughput(0f);
            }
            String device_id = wifiNetworkRequest.getDevice_id();
            if (device_id != null) {
                DeviceId d = new DeviceId(wifiNetworkRequest.getDevice_id());
                DeviceId [] t = {d};
                result.setDevices(t);
            }
        }
        return result;
    }

    private boolean inEnum(String value) {
        boolean result = false;
        for (String s: WifiAuth) {
            if (s.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
