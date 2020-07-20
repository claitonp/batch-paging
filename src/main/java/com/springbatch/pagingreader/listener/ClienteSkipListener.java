package com.springbatch.pagingreader.listener;

import org.springframework.batch.core.SkipListener;

import com.springbatch.pagingreader.dominio.Cliente;
import com.springbatch.pagingreader.dominio.app.ClienteApp;

public class ClienteSkipListener implements SkipListener<ClienteApp,Cliente> {
 
    @Override
    public void onSkipInRead(Throwable t) {
        System.out.println("onSkipInRead");
    }
 
    @Override
    public void onSkipInWrite(Cliente item, Throwable t) {
        System.out.println("onSkipInWrite");
    }
 
    @Override
    public void onSkipInProcess(ClienteApp item, Throwable t) {
        System.out.println("onSkipInProcess");
    }
}