package com.asce1dev.cadastroaefeeft.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.asce1dev.cadastroaefeeft.domain.exception.ClienteNaoEncontradoException;
import com.asce1dev.cadastroaefeeft.domain.exception.EntidadeEmUsoException;
import com.asce1dev.cadastroaefeeft.domain.exception.EntidadeNaoEncontradaException;
import com.asce1dev.cadastroaefeeft.domain.model.ClienteAposentado;
import com.asce1dev.cadastroaefeeft.domain.repository.ClienteAposentadoRepository;


@Service
public class ClienteAposentadoService {

	private static final String MSG_ENTIDADE_EM_USO = "Cozinha de código %d não pode ser removida, pois está em uso";
	private static final String MSG_ENTIDADE_NAO_ENCONTRADA = "Não existe um cadastro de aposentado com código %d";
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
			throw new ClienteNaoEncontradoException(
					String.format(MSG_ENTIDADE_NAO_ENCONTRADA,id));
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_ENTIDADE_EM_USO,id));
		}
	}
	
	public List<ClienteAposentado> findClienteByNome(String nome) {
		return clienteAposentadoRepository.findClienteByNomeContainingIgnoreCase(nome);
	}
	
	public List<ClienteAposentado> findClienteByCpf(String cpf) {
		return clienteAposentadoRepository.findClienteByCpfContaining(cpf);
	}

	public ClienteAposentado buscarOuFalhar(Long id) {
		return clienteAposentadoRepository.findById(id)
				.orElseThrow(() -> new ClienteNaoEncontradoException(
						String.format(
								MSG_ENTIDADE_NAO_ENCONTRADA, id)));
	}

}
