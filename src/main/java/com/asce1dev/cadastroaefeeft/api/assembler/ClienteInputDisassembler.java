package com.asce1dev.cadastroaefeeft.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asce1dev.cadastroaefeeft.api.model.input.ClienteInput;
import com.asce1dev.cadastroaefeeft.domain.model.Cliente;

@Component
public class ClienteInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Cliente toDomainObject(ClienteInput clienteInput) {
		return modelMapper.map(clienteInput, Cliente.class);
	}
	
	public void copyToDomainObject(ClienteInput clienteInput, Cliente cliente) {
		modelMapper.map(clienteInput, cliente);
	}
}
