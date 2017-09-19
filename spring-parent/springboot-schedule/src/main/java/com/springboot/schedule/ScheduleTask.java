package com.springboot.schedule;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
	public final static long ONE_Minute =  1 * 1000;
	@Scheduled(cron="0 22 17 * * ?")
    public void fixedDelayJob(){
        System.out.println(new Date()+" >>fixedDelay执行....");
    }

}
