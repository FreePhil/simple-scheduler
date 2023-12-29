package com.example.demo.player;

import com.example.demo.info.TimerInfo;
import com.example.demo.jobs.HelloWorldJob;
import com.example.demo.timeservices.SchedulerService;
import org.springframework.stereotype.Service;

@Service
public class PlayerGround {

    private final SchedulerService scheduler;

    public PlayerGround(SchedulerService scheduler) {
        this.scheduler = scheduler;
    }

    public void runHelloWorldJob() {
        TimerInfo info = new TimerInfo();
        info.setTotalFireCount(5);
        info.setRepeatIntervalMs(2000);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("My callback data");

        scheduler.schedule(HelloWorldJob.class, info);
    }
}
