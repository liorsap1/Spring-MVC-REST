package com.checkpoint.checkpoint.bootstrap;

import com.checkpoint.checkpoint.type.WifiNetwork;
import com.checkpoint.checkpoint.repositories.WifiNetworkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final WifiNetworkRepository wifiNetworkRepository;

    public BootStrapData(WifiNetworkRepository wifiNetworkRepository) {
        this.wifiNetworkRepository = wifiNetworkRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        WifiNetwork net1 = new WifiNetwork();
        net1.setAuth("wpa");
        net1.setAvg_throughput(0f);
        wifiNetworkRepository.save(net1);

        WifiNetwork net2 = new WifiNetwork();
        net2.setAuth("public");
        net2.setAvg_throughput(0f);
        wifiNetworkRepository.save(net2);

        WifiNetwork net3 = new WifiNetwork();
        net3.setAuth("wpa");
        net3.setAvg_throughput(0f);
        wifiNetworkRepository.save(net3);

        WifiNetwork net4 = new WifiNetwork();
        net4.setAuth("public");
        net4.setAvg_throughput(0f);
        wifiNetworkRepository.save(net4);

    }
}
