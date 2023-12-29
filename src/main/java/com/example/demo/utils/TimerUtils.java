package com.example.demo.utils;

import org.quartz.*;
import com.example.demo.info.TimerInfo;

import java.util.Date;

public class TimerUtils {

    private TimerUtils() {}

    public static JobDetail buildJobDetail(final Class jobClass, TimerInfo timerInfo) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobClass.getSimpleName(), timerInfo);
        return JobBuilder
                .newJob(jobClass)
                .withIdentity(jobClass.getSimpleName())
                .setJobData(jobDataMap)
                .build();
    }

    public static Trigger buildTrigger(Class jobClass, TimerInfo info) {
        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(info.getRepeatIntervalMs());
        SimpleScheduleBuilder scheduledBuilder;
        if (info.isRunForever()) {
            scheduledBuilder = builder.repeatForever();
        }
        else {
            scheduledBuilder = builder.withRepeatCount(info.getTotalFileCount() - 1);
        }
        return TriggerBuilder
                .newTrigger()
                .withIdentity(jobClass.getSimpleName())
                .withSchedule(scheduledBuilder)
                .startAt(new Date(System.currentTimeMillis() + info.getInitialOffsetMs()))
                .build();
    }
}
