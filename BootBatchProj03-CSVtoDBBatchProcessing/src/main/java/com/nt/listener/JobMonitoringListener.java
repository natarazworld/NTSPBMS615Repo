package com.nt.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobMonitoringListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println(" Job Status ::"+jobExecution.getStatus());
		System.out.println("Job Start time ::"+jobExecution.getStartTime());

	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println(" Job Status ::"+jobExecution.getStatus());
		System.out.println("Job End time ::"+jobExecution.getEndTime());
		System.out.println("Job Exit Status ::"+jobExecution.getExitStatus());
	}

}
