package com.springbatch.pagingreader.processor;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.springbatch.pagingreader.dominio.Cliente;
import com.springbatch.pagingreader.dominio.Transacao;
import com.springbatch.pagingreader.dominio.app.ClienteApp;
import com.springbatch.pagingreader.dominio.app2.TransacaoApp2;
import com.springbatch.pagingreader.repository.app2.TransacaoRepository;

@Configuration
public class ClienteItemProcessor implements ItemProcessor<ClienteApp, Cliente> {
 
	@Autowired
	private ModelMapper modelMapper;  
	
	@Autowired
	private TransacaoRepository transacaoRepository;
    
    public Cliente process(ClienteApp clienteApp) {
        Cliente cliente = toCliente(clienteApp);        
        List<TransacaoApp2> transacoesApp2 = transacaoRepository.findAllByEmail(cliente.getEmail());
        transacoesApp2.stream().forEach(t -> cliente.addTransacao(toTransacao(t)));        
		return cliente;
    }    

    public Cliente toCliente(ClienteApp clienteApp) {
        return modelMapper.map(clienteApp, Cliente.class);
    }

    public Transacao toTransacao(TransacaoApp2 transacaoApp2) {
        return modelMapper.map(transacaoApp2, Transacao.class);
    }
}