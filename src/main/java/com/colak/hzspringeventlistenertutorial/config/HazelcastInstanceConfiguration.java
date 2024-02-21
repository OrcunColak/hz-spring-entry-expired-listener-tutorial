package com.colak.hzspringeventlistenertutorial.config;

import com.colak.hzspringeventlistenertutorial.hz.CacheListener;
import com.hazelcast.config.Config;
import com.hazelcast.config.EntryListenerConfig;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class HazelcastInstanceConfiguration {

    public static final String MAP_NAME = "myMap";

    @Bean
    public Config hazelcastConfig() {
        Config config = new Config();

        // Configure the map
        MapConfig mapConfig = config.getMapConfig(MAP_NAME);
        mapConfig.setTimeToLiveSeconds(30);

        EntryListenerConfig entryListenerConfig = new EntryListenerConfig();
        entryListenerConfig.setImplementation(cacheListener());
        mapConfig.addEntryListenerConfig(entryListenerConfig);

        return config;
    }

    @Bean
    CacheListener cacheListener() {
        return new CacheListener();
    }
}
