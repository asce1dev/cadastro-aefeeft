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

import com.asce1dev.cadastroaefeeft.api.assembler.ClientePensionistaInputDisassembler;
import com.asce1dev.cadastroaefeeft.api.assembler.ClientePensionistaModelAssembler;
import com.asce1dev.cadastroaefeeft.api.assembler.ClientePensionistaResumoModelAssembler;
import com.asce1dev.cadastroaefeeft.api.model.ClientePensionistaModel;
import com.asce1dev.cadastroaefeeft.api.model.ClientePensionistaResumoModel;
import com.asce1dev.cadastroaefeeft.api.model.input.ClientePensionistaInput;
import com.asce1dev.cadastroaefeeft.domain.exception.ClienteNaoEncontradoException;
import com.asce1dev.cadastroaefeeft.domain.exception.NegocioException;
import com.asce1dev.cadastroaefeeft.domain.model.ClientePensionista;
import com.asce1dev.cadastroaefeeft.domain.service.ClientePensionistaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pensionistas")
public class ClientePensionistaController {

	@Autowired
	private ClientePensionistaService clientePensionistaService;
	
	@Autowired
	private ClientePensionistaModelAssembler clientePensionistaModelAssembler;
	
	@Autowired
	private ClientePensionistaInputDisassembler clientePensionistaInputDisassembler;

	@Autowired
	private ClientePensionistaResumoModelAssembler clientePensionistaResumoModelAssembler;
	
	@GetMapping
	public List<ClientePensionistaResumoModel> listarClientes() {
		List<ClientePensionista> todosClientes = clientePensionistaService.listarClientes();
		
		return clientePensionistaResumoModelAssembler.toCollectionModel(todosClientes);
	}

	@GetMapping("/{ClientePensionistaId}")
	public ClientePensionistaModel obterClientePorId(@PathVariable Long ClientePensionistaId) {
		ClientePensionista cliente = clientePensionistaService.buscarOuFalhar(ClientePensionistaId);
		
		return clientePensionistaModelAssembler.toModel(cliente);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClientePensionistaModel salvarCliente(@RequestBody @Valid ClientePensionistaInput clientePensionistaInput){
		try {
			ClientePensionista clienteAtual = clientePensionistaInputDisassembler.toDomainObject(clientePensionistaInput);
			
			return clientePensionistaModelAssembler.toModel(clientePensionistaService.salvarCliente(clienteAtual));
		} catch(ClienteNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@PutMapping("/{clientePensionistaId}")
	public ClientePensionistaModel atualizar(@PathVariable Long clientePensionistaId,
			@RequestBody @Valid ClientePensionistaInput clientePensionistaInput) {
		try {
			ClientePensionista clienteAtual = clientePensionistaService.buscarOuFalhar(clientePensionistaId);
			
			clientePensionistaInputDisassembler.copyToDomainObject(clientePensionistaInput, clienteAtual);
			
			return clientePensionistaModelAssembler.toModel(clientePensionistaService.salvarCliente(clienteAtual));
		} catch(ClienteNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCliente(@PathVariable Long id) {
		clientePensionistaService.deletarCliente(id);
	}

	@GetMapping("/por-nome/{nome}")
	public List<ClientePensionistaModel> clientePorNome(@PathVariable String nome) {
		List<ClientePensionista> clientePensionista = clientePensionistaService.findClienteByNome(nome);
		
		return clientePensionistaModelAssembler.toCollectionModel(clientePensionista);
	}

	@GetMapping("/por-cpf/{cpf}")
	public List<ClientePensionistaModel>clientePorCpf(@PathVariable String cpf) {
		List<ClientePensionista> clientePensionista = clientePensionistaService.findClienteByCpf(cpf);
		
		return clientePensionistaModelAssembler.toCollectionModel(clientePensionista);
	}
}