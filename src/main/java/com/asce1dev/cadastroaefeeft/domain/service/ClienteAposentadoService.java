package com.asce1dev.cadastroaefeeft.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asce1dev.cadastroaefeeft.domain.model.ClienteAposentado;
import com.asce1dev.cadastroaefeeft.domain.repository.ClienteAposentadoRepository;


@Service
public class ClienteAposentadoService {

	@Autowired
	private ClienteAposentadoRepository clienteAposentadoRepository;
	
	public List<ClienteAposentado> listarClientes(){
		return clienteAposentadoRepository.findAll();
	}
	
	public ClienteAposentado obterClientePorId(Long id) {
		return clienteAposentadoRepository.findById(id).orElse(null);
	}
	
	public ClienteAposentado salvarCliente(ClienteAposentado cliente) {
		return clienteAposentadoRepository.save(cliente);
	}
	
	public void deletarCliente(Long id) {
		clienteAposentadoRepository.deleteById(id);
	}
	
	public List<ClienteAposentado> findClienteByNome(String nome) {
		return clienteAposentadoRepository.findClienteByNomeContainingIgnoreCase(nome);
	}
	
	public List<ClienteAposentado> findClienteByCpf(String cpf) {
		return clienteAposentadoRepository.findClienteByCpfContaining(cpf);
	}

}
