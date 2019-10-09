package com.zafeCodes.concurrentProject.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ThreadPoolExecutor {
    private  Integer count = 100;
    @Async(value="threadPoolTaskExecutor")
    public void execute(){
        synchronized (count){
            while(count>0){
                count--;
                System.out.println(Thread.currentThread().getName()+":"+count);
            }
        }
    }
}
