package com.example.demo.timeservices;

import com.example.demo.info.TimerInfo;
import com.example.demo.utils.TimerUtils;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class SchedulerService {

    private final Logger log = LoggerFactory.getLogger(SchedulerService.class);
    private final Scheduler scheduler;

    public SchedulerService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void schedule(Class jobClass, TimerInfo info) {
        JobDetail jobDetail = TimerUtils.buildJobDetail(jobClass, info);
        Trigger trigger = TimerUtils.buildTrigger(jobClass, info);

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            log.error("Error scheduling job", e);
        }
    }


    @PostConstruct
    public void init() {
        try {
            log.info("Starting scheduler");
            scheduler.start();
        } catch (Exception e) {
            log.error("Error starting scheduler", e);
        }
    }

    @PreDestroy
    public void shutdown() {
        try {
            scheduler.shutdown();
            log.info("Scheduler shut down");
        }
        catch (Exception e) {
            log.error("Error shutting down scheduler", e);
        }
    }
}
