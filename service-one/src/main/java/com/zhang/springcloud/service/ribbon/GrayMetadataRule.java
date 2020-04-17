package com.zhang.springcloud.service.ribbon;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import com.zhang.springcloud.service.util.GrayHolder;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class GrayMetadataRule extends ZoneAvoidanceRule {

    private Random random = new Random();

    @Override
    public Server choose(Object key) {
        String isgray= GrayHolder.isGray();
//        GrayHolder.reSet();
        List<Server> serverList = this.getPredicate().getEligibleServers(this.getLoadBalancer().getAllServers(), key);
        List<Server>   backList=  serverList.stream().filter(server -> {
                Map<String, String> metadata = ((DiscoveryEnabledServer) server).getInstanceInfo().getMetadata();
                String metaVersion = metadata.get("gray");
                return isgray.equals(metaVersion);
            }).collect(Collectors.toList());
        return  backList.get(Math.abs(random.nextInt(backList.size())));
//        return super.choose(key);
    }
}
