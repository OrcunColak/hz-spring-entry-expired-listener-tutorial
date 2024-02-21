package com.colak.hzspringeventlistenertutorial.hz;

import com.colak.hzspringeventlistenertutorial.service.MyService;
import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryExpiredListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@RequiredArgsConstructor
public class CacheListener implements EntryExpiredListener<String, String> {

    private MyService myService;


    @Autowired
    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void entryExpired(EntryEvent<String, String> event) {
        log.info("entryEvicted. Cache: {}. Value: {}. \nEvent: {} ", event.getName(), event.getOldValue(), event);
        myService.deleteFromRepository(event.getKey());
    }
}
