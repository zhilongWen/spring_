package com.at.yuntai.test.quartz;

import com.at.yuntai.scheduler.job.MySQLMonitorJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.JobBuilder.newJob;


/**
 * @create 2023-09-15
 */
public class TestQuartz {

    public static void main1(String[] args) throws Exception{

        var stdSchedulerFactory = new StdSchedulerFactory();

        var scheduler = stdSchedulerFactory.getScheduler();

        scheduler.start();

        var jobDetail = newJob(SimpleJob.class)
                .withIdentity("myJob", "g1")
                .build();

        var trigger = newTrigger()
                .withIdentity("trigger", "g1")
                .startNow()
                .withSchedule(
                        simpleSchedule()
                                .withIntervalInSeconds(5)
                                .repeatForever()
                )
                .build();

        scheduler.scheduleJob(jobDetail,trigger);

    }

    public static void main(String[] args) throws Exception{

        var stdSchedulerFactory = new StdSchedulerFactory();

        var scheduler = stdSchedulerFactory.getScheduler();

        scheduler.start();
        var jobData = new JobDataMap();
        jobData.put("databaseName", "yuntai");
        jobData.put("tableName", "yuntai_zuoyuan");
        jobData.put("fieldName", "age");
        var jobDetail =  JobBuilder
                .newJob(MySQLMonitorJob.class)
                .withIdentity("a", "a")
                .setJobData(jobData)
                .build();

        var trigger = newTrigger()
                .withIdentity("trigger", "g1")
                .startNow()
                .withSchedule(
                        simpleSchedule()
                                .withIntervalInSeconds(5)
                                .repeatForever()
                )
                .build();

        scheduler.scheduleJob(jobDetail,trigger);

    }

}
