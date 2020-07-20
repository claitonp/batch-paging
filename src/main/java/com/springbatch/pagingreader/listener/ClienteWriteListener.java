package com.springbatch.pagingreader.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import com.springbatch.pagingreader.dominio.Cliente;

public class ClienteWriteListener implements ItemWriteListener<Cliente> {

	@Override
	public void beforeWrite(List<? extends Cliente> clientes) {
		System.out.println("##### beforeWrite " + clientes.size());		
	}

	@Override
	public void afterWrite(List<? extends Cliente> clientes) {
		System.out.println("##### afterWrite " + clientes.size());		
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Cliente> clientes) {
		System.out.println("##### onWriteError " + clientes.size());		
	}
 
}