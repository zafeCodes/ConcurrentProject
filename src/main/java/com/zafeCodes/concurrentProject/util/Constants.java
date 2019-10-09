package com.zafeCodes.concurrentProject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Constants{
    @Autowired
    private Environment env;

    public static int CORE_POOL_SIZE;
    public static int MAX_POOL_SIZE;
    public static int QUEUE_CAPACITY;
    public static int KEEP_ALIVE_SECONDS;

    @PostConstruct
    private void init(){
        CORE_POOL_SIZE = Integer.parseInt(env.getProperty("CORE_POOL_SIZE"));
        MAX_POOL_SIZE = Integer.parseInt(env.getProperty("MAX_POOL_SIZE"));
        QUEUE_CAPACITY = Integer.parseInt(env.getProperty("QUEUE_CAPACITY"));
        KEEP_ALIVE_SECONDS = Integer.parseInt(env.getProperty("KEEP_ALIVE_SECONDS"));
    }
}
