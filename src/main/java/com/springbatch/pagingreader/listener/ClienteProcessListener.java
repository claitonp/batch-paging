package com.springbatch.pagingreader.listener;
import org.springframework.batch.core.ItemProcessListener;

import com.springbatch.pagingreader.dominio.Cliente;
import com.springbatch.pagingreader.dominio.app.ClienteApp;
 
public class ClienteProcessListener implements ItemProcessListener<ClienteApp, Cliente> {
 
    @Override
    public void beforeProcess(ClienteApp clienteApp) {
        System.out.println("beforeProcess");
    }
 
    @Override
    public void afterProcess(ClienteApp clienteApp, Cliente cliente) {
        System.out.println("afterProcess");
    }
 
    @Override
    public void onProcessError(ClienteApp clienteApp, Exception e) {
        System.out.println("onProcessError");
    }
}