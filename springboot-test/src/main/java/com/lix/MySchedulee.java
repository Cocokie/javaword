package com.lix;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileDescriptor;
import java.io.PrintStream;

/**
 * @author 12547
 */
@Component
public class MySchedulee {
    @Scheduled(cron = "0/3 * * * * ?")
    public void print() {
        System.out.println("天地绝杀霸主");

    }
}
