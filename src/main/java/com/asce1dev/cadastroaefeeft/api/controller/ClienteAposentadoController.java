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
import com.asce1dev.cadastroaefeeft.api.assembler.ClienteAposentadoResumoModelAssembler;
import com.asce1dev.cadastroaefeeft.api.model.ClienteAposentadoModel;
import com.asce1dev.cadastroaefeeft.api.model.ClienteAposentadoResumoModel;
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
	
	@Autowired
	private ClienteAposentadoResumoModelAssembler clienteAposentadoResumoModelAssembler;
	
	@GetMapping
	public List<ClienteAposentadoResumoModel> listarClientes() {
		List<ClienteAposentado> todosClientes = clienteAposentadoService.listarClientes();
		
		return clienteAposentadoResumoModelAssembler.toCollectionModel(todosClientes);
	}

	@GetMapping("/{clienteAposentadoId}")
	public ClienteAposentadoModel obterClientePorId(@PathVariable Long clienteAposentadoId) {
		ClienteAposentado clienteAposentado = clienteAposentadoService.buscarOuFalhar(clienteAposentadoId);
		
		return clienteAposentadoModelAssembler.toModel(clienteAposentado);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteAposentadoModel salvarCliente(@RequestBody @Valid ClienteAposentadoInput clienteAposentadoInput){
		try {
			ClienteAposentado clienteAposentado = clienteAposentadoInputDisassembler.toDomainObject(clienteAposentadoInput);

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
	public List<ClienteAposentadoModel> clientePorNome(@PathVariable String nome) {
		List<ClienteAposentado> clienteAposentado = clienteAposentadoService.findClienteByNome(nome);
		
		return clienteAposentadoModelAssembler.toCollectionModel(clienteAposentado);
	}

	@GetMapping("/por-cpf/{cpf}")
	public List<ClienteAposentadoModel>clientePorCpf(@PathVariable String cpf) {
		List<ClienteAposentado> clienteAposentado = clienteAposentadoService.findClienteByCpf(cpf);
		
		return clienteAposentadoModelAssembler.toCollectionModel(clienteAposentado);
	}
	
}
