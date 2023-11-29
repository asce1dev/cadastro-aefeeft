package com.asce1dev.cadastroaefeeft.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asce1dev.cadastroaefeeft.domain.model.ClientePensionista;
import com.asce1dev.cadastroaefeeft.domain.repository.ClientePensionistaRepository;

@Service
public class ClientePensionistaService {

	@Autowired
	private ClientePensionistaRepository clientePensionistaRepository;
	
	public List<ClientePensionista> listarClientes(){
		return clientePensionistaRepository.findAll();
	}
	
	public ClientePensionista obterClientePorId(Long id) {
		return clientePensionistaRepository.findById(id).orElse(null);
	}
	
	public ClientePensionista salvarCliente(ClientePensionista cliente) {
		return clientePensionistaRepository.save(cliente);
	}
	
	public void deletarCliente(Long id) {
		clientePensionistaRepository.deleteById(id);
	}
	
	public List<ClientePensionista> findClienteByNome(String nome){
		return clientePensionistaRepository.findClienteByNomeContainingIgnoreCase(nome);
	}
	
	public List<ClientePensionista> findClienteByCpf(String cpf) {
		return clientePensionistaRepository.findClienteByCpfContaining(cpf);
	}
}
