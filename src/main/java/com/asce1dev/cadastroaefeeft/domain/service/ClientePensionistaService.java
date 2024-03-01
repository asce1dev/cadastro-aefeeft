package com.asce1dev.cadastroaefeeft.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.asce1dev.cadastroaefeeft.domain.exception.ClienteNaoEncontradoException;
import com.asce1dev.cadastroaefeeft.domain.exception.EntidadeEmUsoException;
import com.asce1dev.cadastroaefeeft.domain.model.ClientePensionista;
import com.asce1dev.cadastroaefeeft.domain.repository.ClientePensionistaRepository;

@Service
public class ClientePensionistaService {

	private static final String MSG_ENTIDADE_EM_USO = "Cliente de código %d não pode ser removido, pois está em uso";
	
	@Autowired
	private ClientePensionistaRepository clientePensionistaRepository;
	
	public List<ClientePensionista> listarClientes(){
		return clientePensionistaRepository.findAll();
	}
	
	public ClientePensionista salvarCliente(ClientePensionista cliente) {
		return clientePensionistaRepository.save(cliente);
	}
	
	public void deletarCliente(Long clientePensionistaId) {
		try {
			clientePensionistaRepository.deleteById(clientePensionistaId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradoException(clientePensionistaId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_ENTIDADE_EM_USO,clientePensionistaId));
		}
	}
	
	public List<ClientePensionista> findClienteByNome(String nome) {
		List<ClientePensionista> clientes = clientePensionistaRepository.findClienteByNomeContainingIgnoreCase(nome);
		
		if(clientes.isEmpty()) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado com o nome: " + nome);
		}
		return clientes;
	}
	
	public List<ClientePensionista> findClienteByCpf(String cpf) {
		List<ClientePensionista> clientes = clientePensionistaRepository.findClienteByCpfContaining(cpf);
		
		if(clientes.isEmpty()) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado com o CPF: " + cpf);
		}
		return clientes;
	}

	public ClientePensionista buscarOuFalhar(Long clientePensionistaId) {
		return clientePensionistaRepository.findById(clientePensionistaId)
				.orElseThrow(() -> new ClienteNaoEncontradoException(clientePensionistaId));
	}
}
