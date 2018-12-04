package com.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronScheduler {

    public static void main(String[] args) {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("CronJob","CronGroup")
                .usingJobData("message","jobDetialMap add message")
                .usingJobData("floatJobValue",8.88f).build();
        //每日的9点40触发任务
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("CornTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 51 14 * * ? ")).build();
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler;

        {
            try {
                scheduler = factory.getScheduler();
                scheduler.start();
                scheduler.scheduleJob(jobDetail, cronTrigger);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }
}
