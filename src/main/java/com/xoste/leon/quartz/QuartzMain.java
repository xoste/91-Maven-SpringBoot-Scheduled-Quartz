package com.xoste.leon.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author Leon
 */
public class QuartzMain {
    public static void main(String[] args) throws SchedulerException {
        // 1.创建Job对象，准备作什么事?
        JobDetail jobDetail = JobBuilder.newJob(QuartzDemo.class).build();
        // 2.创建Trigger对象，在什么时候做？
        /**
         * 简单的Trigger触发时间，通过Quartz提供一个方法来完成简单的重复调用
         * cron Trigger，按照Cron 的表达式来给定触发的时间
         * */
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
        // 3.创建scheduler对象，在什么时间做什么事?
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        // 4.开启schedule
        scheduler.start();
    }
}
