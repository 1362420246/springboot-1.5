package com.qbk.quarz.job;

import org.quartz.*;

/**
 * @Author: quboka
 * @Date: 2018/10/19 10:58
 * @Description: job
 */
@DisallowConcurrentExecution
public class GrdbJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        System.out.println(dataMap.getString("data1"));

    }
}