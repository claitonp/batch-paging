package com.springbatch.pagingreader.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbatch.pagingreader.dominio.app.ClienteApp;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteApp, String> {

}
