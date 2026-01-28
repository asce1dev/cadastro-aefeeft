package com.asce1dev.cadastroaefeeft.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.asce1dev.cadastroaefeeft.domain.exception.ClienteNaoEncontradoException;
import com.asce1dev.cadastroaefeeft.domain.exception.EntidadeEmUsoException;
import com.asce1dev.cadastroaefeeft.domain.model.Cliente;
import com.asce1dev.cadastroaefeeft.domain.repository.ClienteRepository;


@Service
public class ClienteService {

	private static final String MSG_ENTIDADE_EM_USO = "Cliente de código %d não pode ser removido, pois está em uso";

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void deletarCliente(Long id) {
		try {
			clienteRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradoException(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_ENTIDADE_EM_USO,id));
		}
	}
	
	public List<Cliente> findClienteByNome(String nome) {
		List<Cliente> clientes = clienteRepository.findClienteByNomeContainingIgnoreCase(nome);
		
		if(clientes.isEmpty()) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado com o nome: " + nome);
		}
		return clientes;
	}
	
	public List<Cliente> findClienteByCpf(String cpf) {
		List<Cliente> clientes = clienteRepository.findClienteByCpfContaining(cpf);
		
		if(clientes.isEmpty()) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado com o CPF: " + cpf);
		}
		return clientes;
	}

	public Cliente buscarOuFalhar(Long clienteAposentadoId) {
		return clienteRepository.findById(clienteAposentadoId)
				.orElseThrow(() -> new ClienteNaoEncontradoException(clienteAposentadoId));
	}

}
