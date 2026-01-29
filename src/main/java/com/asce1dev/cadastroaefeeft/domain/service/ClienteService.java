package com.asce1dev.cadastroaefeeft.domain.service;

import java.util.List;

import com.asce1dev.cadastroaefeeft.domain.exception.CpfDuplicadoException;
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
		try {
			return clienteRepository.save(cliente);
		} catch (DataIntegrityViolationException e) {
			throw new CpfDuplicadoException();
		}
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
		return clienteRepository.findClienteByNomeContainingIgnoreCase(nome);
	}
	
	public List<Cliente> findClienteByCpf(String cpf) {
		return clienteRepository.findClienteByCpfContaining(cpf);
	}

	public Cliente buscarOuFalhar(Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ClienteNaoEncontradoException(clienteId));
	}

}
