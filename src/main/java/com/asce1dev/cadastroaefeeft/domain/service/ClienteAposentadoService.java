package com.asce1dev.cadastroaefeeft.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.asce1dev.cadastroaefeeft.domain.exception.ClienteNaoEncontradoException;
import com.asce1dev.cadastroaefeeft.domain.exception.EntidadeEmUsoException;
import com.asce1dev.cadastroaefeeft.domain.model.ClienteAposentado;
import com.asce1dev.cadastroaefeeft.domain.repository.ClienteAposentadoRepository;


@Service
public class ClienteAposentadoService {

	private static final String MSG_ENTIDADE_EM_USO = "Cliente de código %d não pode ser removido, pois está em uso";
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
		try {
			clienteAposentadoRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradoException(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_ENTIDADE_EM_USO,id));
		}
	}
	
	public List<ClienteAposentado> findClienteByNome(String nome) {
		List<ClienteAposentado> clientes = clienteAposentadoRepository.findClienteByNomeContainingIgnoreCase(nome);
		
		if(clientes.isEmpty()) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado com o nome: " + nome);
		}
		return clientes;
	}
	
	public List<ClienteAposentado> findClienteByCpf(String cpf) {
		List<ClienteAposentado> clientes = clienteAposentadoRepository.findClienteByCpfContaining(cpf);
		
		if(clientes.isEmpty()) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado com o CPF: " + cpf);
		}
		return clientes;
	}

	public ClienteAposentado buscarOuFalhar(Long id) {
		return clienteAposentadoRepository.findById(id)
				.orElseThrow(() -> new ClienteNaoEncontradoException(id));
	}

}
