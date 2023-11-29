package com.asce1dev.cadastroaefeeft.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asce1dev.cadastroaefeeft.domain.model.ClientePensionista;

@Repository
public interface ClientePensionistaRepository extends JpaRepository<ClientePensionista, Long>{

	List<ClientePensionista> findClienteByNomeContainingIgnoreCase(String nome);
	
	List<ClientePensionista> findClienteByCpfContaining(String cpf);
	
}

