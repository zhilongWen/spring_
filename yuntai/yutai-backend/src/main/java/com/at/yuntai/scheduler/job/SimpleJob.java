package com.at.yuntai.scheduler.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @create 2023-09-15
 */
public class SimpleJob implements Job {

    public SimpleJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务被触发执行！");
    }
}
