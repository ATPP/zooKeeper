package com.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("now time:" + simpleDateFormat.format(date));
        System.out.println("execute mission");
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("jobDetail name:"+jobKey.getName());//jobname
        System.out.println("jobDetail group:"+jobKey.getGroup());//jobgroup

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println("jobDeailMap message:"+jobDataMap.getString("message"));
        System.out.println("jobDetailMap floatJobValue:"+jobDataMap.getString("floatJobValue"));
    }
}
