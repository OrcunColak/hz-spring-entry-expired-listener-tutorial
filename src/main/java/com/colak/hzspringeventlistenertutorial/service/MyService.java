package com.colak.hzspringeventlistenertutorial.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyService {

    @Async
    public void deleteFromRepository(String key) {
        log.info("deleteFromRepository is called for key : {}", key);
    }

}
