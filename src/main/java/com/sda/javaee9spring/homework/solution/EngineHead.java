package com.sda.javaee9spring.homework.solution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EngineHead {

    public EngineHead() {
        log.info("EngineHead was created");
    }
}
