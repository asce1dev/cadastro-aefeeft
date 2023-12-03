package com.asce1dev.cadastroaefeeft.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.asce1dev.cadastroaefeeft.domain.model.ClienteAposentado;
import com.asce1dev.cadastroaefeeft.domain.service.ClienteAposentadoService;

@RestController
@RequestMapping("/aposentados")
public class ClienteAposentadoController {

	@Autowired
	private ClienteAposentadoService clienteAposentadoService;
	/**
	 * Lista todos os Aposentados Cadastrados.
	 * 
	 * @return Lista de Aposentados.
	 */
	@GetMapping
	public List<ClienteAposentado> listarClientes() {
		return clienteAposentadoService.listarClientes();
	}
	/**
	 * Busca um cliente específico por ID (identificador do cliente).
	 * 
	 * @param id ID do cliente a ser exibido.
	 * @return Cliente específico.
	 */
	@GetMapping("/{id}")
	public ClienteAposentado obterClientePorId(@PathVariable Long id) {
		return clienteAposentadoService.buscarOuFalhar(id);
	}
	/**
	 * Cadastrar novo cliente ou atualizar cliente existente.
	 * 
	 * Os requisitos mínimos são que os campos "nome, cpf, email" sejam preenchidos.
	 * 
	 * @param cliente 
	 * @return Novo cliente ou atualização cadastral.
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteAposentado salvarCliente(@RequestBody ClienteAposentado cliente){
		return clienteAposentadoService.salvarCliente(cliente);
	}
	
	@PutMapping("/{id}")
	public ClienteAposentado atualizar(@PathVariable Long id,
			@RequestBody ClienteAposentado cliente) {
		ClienteAposentado clienteAtual = clienteAposentadoService.buscarOuFalhar(id);

		BeanUtils.copyProperties(cliente, clienteAtual, "id", "nome", "cpf");
			
		return clienteAposentadoService.salvarCliente(clienteAtual);
	}
	/**
	 * Faz a exclusão de um cliente específico por id.
	 * 
	 * @param id ID do cliente a ser excluído.
	 * @throws NoSuchElementException Se nenhum cliente com o ID fornecido for encontrado.
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCliente(@PathVariable Long id) {
		clienteAposentadoService.deletarCliente(id);
	}
	/**
	 * Busca uma lista de clientes por nome.
	 * 
	 * @param nome
	 * @return Lista de Clientes.
	 */
	@GetMapping("/por-nome/{nome}")
	public ResponseEntity<List<ClienteAposentado>> clientePorNome(@PathVariable String nome) {
		List<ClienteAposentado> cliente = clienteAposentadoService.findClienteByNome(nome);
		
		if (cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(cliente);
		}
	}
	/**
	 * Busca uma lista de clientes por CPF.
	 * 
	 * @param cpf
	 * @return Lista de Clientes.
	 */
	@GetMapping("/por-cpf/{cpf}")
	public ResponseEntity<List<ClienteAposentado>>clientePorCpf(@PathVariable String cpf) {
		List<ClienteAposentado> cliente = clienteAposentadoService.findClienteByCpf(cpf);
		
		if (cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(cliente);
		}
	}
}
