package com.lab.demo.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class BatchJobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Job start at: " + jobExecution.getCreateTime());
        System.out.println("Job name : " + jobExecution.getJobConfigurationName());
        System.out.println("Job context before job : " + jobExecution.getExecutionContext());
        jobExecution.getExecutionContext().put("test", "testValue");

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("Job end at: " + jobExecution.getEndTime());
        System.out.println("Job end status: " + jobExecution.getExitStatus());
        System.out.println("Job context after job : " + jobExecution.getExecutionContext());

    }
}
