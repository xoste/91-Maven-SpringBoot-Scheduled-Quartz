package com.xoste.leon.quartz;

import com.xoste.leon.service.impl.UsersServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author Leon
 */
public class QuartzDemo implements Job {
    @Autowired
    private UsersServiceImpl usersServiceImpl;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Execute..." + new Date());
        usersServiceImpl.addUsers();
    }
}
