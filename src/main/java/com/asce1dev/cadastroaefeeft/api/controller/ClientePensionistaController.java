package com.asce1dev.cadastroaefeeft.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asce1dev.cadastroaefeeft.domain.model.ClientePensionista;
import com.asce1dev.cadastroaefeeft.domain.service.ClientePensionistaService;

@RestController
@RequestMapping("/pensionistas")
public class ClientePensionistaController {

	@Autowired
	private ClientePensionistaService clientePensionistaService;
	/**
	 * Lista todos os Pensionistas Cadastrados.
	 * 
	 * @return Lista de Pensionistas.
	 */
	@GetMapping
	public List<ClientePensionista> listarClientes() {
		return clientePensionistaService.listarClientes();
	}
	/**
	 * Busca um cliente específico por ID (identificador do cliente).
	 * 
	 * @param id ID do cliente a ser exibido.
	 * @return Cliente específico.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ClientePensionista> obterClientePorId(@PathVariable Long id) {
		ClientePensionista cliente = clientePensionistaService.obterClientePorId(id);
		
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
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
	public ResponseEntity<ClientePensionista> salvarCliente(@RequestBody ClientePensionista cliente){
		ClientePensionista clienteSalvo = clientePensionistaService.salvarCliente(cliente);
		return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
	}
	
//	TODO
//	@PutMapping("/{id}")
//	public ResponseEntity<ClientePensionista> atualizar(@PathVariable Long id,
//			@RequestBody ClientePensionista cliente) {
//		ClientePensionista clienteAtual = clientePensionistaService.obterClientePorId(id);
//		
//		if (clienteAtual != null) {
//			BeanUtils.copyProperties(cliente, clienteAtual, "id", "nome", "cpf", "email", "senhaGov");
//			
//			ClientePensionista clienteSalvo = clientePensionistaService.salvarCliente(clienteAtual);
//			return ResponseEntity.ok(clienteSalvo);
//		}
//		return ResponseEntity.notFound().build();
//		
//	}
	
	/**
	 * Faz a exclusão de um cliente específico por id.
	 * 
	 * @param id ID do cliente a ser excluído.
	 * @throws NoSuchElementException Se nenhum cliente com o ID fornecido for encontrado.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		clientePensionistaService.deletarCliente(id);
		return ResponseEntity.noContent().build();
	}
	/**
	 * Busca uma lista de clientes por nome.
	 * 
	 * @param nome
	 * @return Lista de Clientes.
	 */
	@GetMapping("/por-nome/{nome}")
	public ResponseEntity<List<ClientePensionista>> clientePorNome(@PathVariable String nome) {
		List<ClientePensionista> cliente = clientePensionistaService.findClienteByNome(nome);
		
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
	public ResponseEntity<List<ClientePensionista>> clientePorCPF(@PathVariable String cpf) {
		List<ClientePensionista> cliente = clientePensionistaService.findClienteByCpf(cpf);
		
		if (cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(cliente);
		}
	}
}