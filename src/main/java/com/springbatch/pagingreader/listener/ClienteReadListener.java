package com.springbatch.pagingreader.listener;

import org.springframework.batch.core.ItemReadListener;

import com.springbatch.pagingreader.dominio.app.ClienteApp;


public class ClienteReadListener implements ItemReadListener<ClienteApp> {

	@Override
	public void beforeRead() {
		System.out.println("##### beforeRead ");		
	}

	@Override
	public void afterRead(ClienteApp obj) {
		System.out.println("##### afterRead " + obj.getEmail());		
	}

	@Override
	public void onReadError(Exception ex) {
		System.out.println("##### onReadError " + ex.getMessage());	
		
	}

}
