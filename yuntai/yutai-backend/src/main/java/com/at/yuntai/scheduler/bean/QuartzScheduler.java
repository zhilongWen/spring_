package com.at.yuntai.scheduler.bean;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @create 2023-09-15
 */

public class QuartzScheduler {

    private static Scheduler scheduler = null;

    public static Scheduler getInstance() throws Exception {
        if (scheduler == null) {
            scheduler = new StdSchedulerFactory().getScheduler();
        }

        return scheduler;
    }

}

