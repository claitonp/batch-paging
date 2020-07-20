package com.springbatch.pagingreader.listener;


import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class ClienteChunkListener implements ChunkListener {

	@Override
	public void beforeChunk(ChunkContext context) {
		System.out.println("##### beforeChunk " + context.getStepContext().getStepName());
	}

	@Override
	public void afterChunk(ChunkContext context) {
		System.out.println("##### afterChunk " + context.getStepContext().getStepName());		
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		System.out.println("##### afterChunkError " + context.getStepContext().getStepName());		
	}

}