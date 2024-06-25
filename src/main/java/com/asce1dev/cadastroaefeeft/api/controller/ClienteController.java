package com.asce1dev.cadastroaefeeft.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.asce1dev.cadastroaefeeft.api.assembler.ClienteInputDisassembler;
import com.asce1dev.cadastroaefeeft.api.assembler.ClienteModelAssembler;
import com.asce1dev.cadastroaefeeft.api.assembler.ClienteResumoModelAssembler;
import com.asce1dev.cadastroaefeeft.api.model.ClienteModel;
import com.asce1dev.cadastroaefeeft.api.model.ClienteResumoModel;
import com.asce1dev.cadastroaefeeft.api.model.input.ClienteInput;
import com.asce1dev.cadastroaefeeft.domain.exception.ClienteNaoEncontradoException;
import com.asce1dev.cadastroaefeeft.domain.exception.NegocioException;
import com.asce1dev.cadastroaefeeft.domain.model.Cliente;
import com.asce1dev.cadastroaefeeft.domain.service.ClienteService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteModelAssembler clienteModelAssembler;
	
	@Autowired
	private ClienteInputDisassembler clienteInputDisassembler;
	
	@Autowired
	private ClienteResumoModelAssembler clienteResumoModelAssembler;
	
	@GetMapping
	public List<ClienteResumoModel> listarClientes() {
		List<Cliente> todosClientes = clienteService.listarClientes();
		
		return clienteResumoModelAssembler.toCollectionModel(todosClientes);
	}

	@GetMapping("/{clienteId}")
	public ClienteModel obterClientePorId(@PathVariable Long clienteId) {
		Cliente cliente = clienteService.buscarOuFalhar(clienteId);
		
		return clienteModelAssembler.toModel(cliente);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteModel salvarCliente(@RequestBody @Valid ClienteInput clienteInput){
		try {
			Cliente cliente = clienteInputDisassembler.toDomainObject(clienteInput);

			return clienteModelAssembler.toModel(clienteService.salvarCliente(cliente));
		} catch (ClienteNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
		
	}
	
	@PutMapping("/{clienteId}")
	public ClienteModel atualizar(@PathVariable Long clienteId,
			@RequestBody @Valid ClienteInput clienteInput) {
		try {
			Cliente clienteAtual = clienteService.buscarOuFalhar(clienteId);
			
			clienteInputDisassembler.copyToDomainObject(clienteInput, clienteAtual);	
			
			return clienteModelAssembler.toModel(clienteService.salvarCliente(clienteAtual));
		} catch (ClienteNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
	}

	@GetMapping("/por-nome/{nome}")
	public List<ClienteModel> clientePorNome(@PathVariable String nome) {
		List<Cliente> cliente = clienteService.findClienteByNome(nome);
		
		return clienteModelAssembler.toCollectionModel(cliente);
	}

	@GetMapping("/por-cpf/{cpf}")
	public List<ClienteModel>clientePorCpf(@PathVariable String cpf) {
		List<Cliente> cliente = clienteService.findClienteByCpf(cpf);
		
		return clienteModelAssembler.toCollectionModel(cliente);
	}
	
}
