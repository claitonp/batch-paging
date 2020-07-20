package com.springbatch.pagingreader.repository.app2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbatch.pagingreader.dominio.app2.TransacaoApp2;

@Repository
public interface TransacaoRepository extends JpaRepository<TransacaoApp2, String> {
	
	List<TransacaoApp2> findAllByEmail(String email);

}
