package com.asce1dev.cadastroaefeeft.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asce1dev.cadastroaefeeft.domain.model.ClienteAposentado;

@Repository
public interface ClienteAposentadoRepository extends JpaRepository<ClienteAposentado, Long>{
	
	List<ClienteAposentado> findClienteByNomeContainingIgnoreCase(String nome);
	
	List<ClienteAposentado> findClienteByCpfContaining(String cpf);
}
