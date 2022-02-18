package com.sda.javaee9spring.homework.solution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Engine {

    private final EngineHead engineHead;
    private final EngineBody engineBody;

    public Engine(EngineHead engineHead, EngineBody engineBody) {
        this.engineHead = engineHead;
        this.engineBody = engineBody;
        log.info("Engine was created");
    }
}
