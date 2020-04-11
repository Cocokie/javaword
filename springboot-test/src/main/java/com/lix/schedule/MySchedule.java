package com.lix.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 12547
 */
@Component
public class MySchedule {
    @Scheduled(cron = "0/5 0 0 * * ?")
    public void print() {
        System.out.println("天地绝杀霸主");
    }
}
