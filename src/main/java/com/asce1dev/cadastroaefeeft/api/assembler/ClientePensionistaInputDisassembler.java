package com.asce1dev.cadastroaefeeft.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asce1dev.cadastroaefeeft.api.model.input.ClientePensionistaInput;
import com.asce1dev.cadastroaefeeft.domain.model.ClientePensionista;

@Component
public class ClientePensionistaInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ClientePensionista toDomainObject(ClientePensionistaInput clientePensionistaInput) {
		return modelMapper.map(clientePensionistaInput, ClientePensionista.class);
	}
	
	public void copyToDomainObject(ClientePensionistaInput clientePensionistaInput, ClientePensionista clientePensionista) {
		modelMapper.map(clientePensionista, clientePensionistaInput);
	}
}
