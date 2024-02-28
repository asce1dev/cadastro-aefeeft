package com.asce1dev.cadastroaefeeft.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.asce1dev.cadastroaefeeft.api.assembler.ClienteAposentadoInputDisassembler;
import com.asce1dev.cadastroaefeeft.api.assembler.ClienteAposentadoModelAssembler;
import com.asce1dev.cadastroaefeeft.api.model.ClienteAposentadoModel;
import com.asce1dev.cadastroaefeeft.api.model.input.ClienteAposentadoInput;
import com.asce1dev.cadastroaefeeft.domain.exception.ClienteNaoEncontradoException;
import com.asce1dev.cadastroaefeeft.domain.exception.NegocioException;
import com.asce1dev.cadastroaefeeft.domain.model.ClienteAposentado;
import com.asce1dev.cadastroaefeeft.domain.service.ClienteAposentadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aposentados")
public class ClienteAposentadoController {

	@Autowired
	private ClienteAposentadoService clienteAposentadoService;

	@Autowired
	private ClienteAposentadoModelAssembler clienteAposentadoModelAssembler;
	
	@Autowired
	private ClienteAposentadoInputDisassembler clienteAposentadoInputDisassembler;
	
	@GetMapping
	public List<ClienteAposentadoModel> listarClientes() {
		List<ClienteAposentado> todosClientes = clienteAposentadoService.listarClientes();
		
		return clienteAposentadoModelAssembler.toCollectionModel(todosClientes);
	}

	@GetMapping("/{clienteAposentadoId}")
	public ClienteAposentadoModel obterClientePorId(@PathVariable Long clienteAposentadoId) {
		ClienteAposentado clienteAposentado = clienteAposentadoService.buscarOuFalhar(clienteAposentadoId);
		
		return clienteAposentadoModelAssembler.toModel(clienteAposentado);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteAposentadoModel salvarCliente(@RequestBody @Valid ClienteAposentadoInput clienteInput){
		try {
			ClienteAposentado clienteAposentado = clienteAposentadoInputDisassembler.toDomainObject(clienteInput);

			return clienteAposentadoModelAssembler.toModel(clienteAposentadoService.salvarCliente(clienteAposentado));
		} catch (ClienteNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
		
	}
	
	@PutMapping("/{clienteAposentadoId}")
	public ClienteAposentadoModel atualizar(@PathVariable Long clienteAposentadoId,
			@RequestBody @Valid ClienteAposentadoInput clienteAposentadoInput) {
		try {
			ClienteAposentado clienteAtual = clienteAposentadoService.buscarOuFalhar(clienteAposentadoId);
			
			clienteAposentadoInputDisassembler.copyToDomainObject(clienteAposentadoInput, clienteAtual);	
			
			return clienteAposentadoModelAssembler.toModel(clienteAposentadoService.salvarCliente(clienteAtual));
		} catch (ClienteNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCliente(@PathVariable Long id) {
		clienteAposentadoService.deletarCliente(id);
	}

	@GetMapping("/por-nome/{nome}")
	public List<ClienteAposentado> clientePorNome(@PathVariable String nome) {
		return clienteAposentadoService.findClienteByNome(nome);
	}

	@GetMapping("/por-cpf/{cpf}")
	public List<ClienteAposentado>clientePorCpf(@PathVariable String cpf) {
		return clienteAposentadoService.findClienteByCpf(cpf);
	}
	
}
