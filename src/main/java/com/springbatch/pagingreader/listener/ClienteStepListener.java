package com.springbatch.pagingreader.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class ClienteStepListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.out.println("##### Inicio step " + stepExecution.getStepName() + " (" + stepExecution.getStatus().name() + ")");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("##### Fim step " + stepExecution.getStepName() + " (" + stepExecution.getStatus().name() + ")");
		return ExitStatus.COMPLETED;
	}
}