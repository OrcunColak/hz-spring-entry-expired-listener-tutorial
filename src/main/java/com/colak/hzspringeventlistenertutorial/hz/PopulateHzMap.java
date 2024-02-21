package com.colak.hzspringeventlistenertutorial.hz;

import com.colak.hzspringeventlistenertutorial.config.HazelcastInstanceConfiguration;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PopulateHzMap {

    private final HazelcastInstance hazelcast;

    @PostConstruct
    void postConstruct() {
        IMap<String, String> map = hazelcast.getMap(HazelcastInstanceConfiguration.MAP_NAME);
        map.put("key1", "value1");
    }
}
