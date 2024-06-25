package com.asce1dev.cadastroaefeeft.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asce1dev.cadastroaefeeft.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findClienteByNomeContainingIgnoreCase(String nome);
	
	List<Cliente> findClienteByCpfContaining(String cpf);
}
