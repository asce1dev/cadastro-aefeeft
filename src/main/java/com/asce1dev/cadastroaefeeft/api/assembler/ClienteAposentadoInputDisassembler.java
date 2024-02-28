package com.asce1dev.cadastroaefeeft.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asce1dev.cadastroaefeeft.api.model.input.ClienteAposentadoInput;
import com.asce1dev.cadastroaefeeft.domain.model.ClienteAposentado;

@Component
public class ClienteAposentadoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ClienteAposentado toDomainObject(ClienteAposentadoInput clienteAposentadoInput) {
		return modelMapper.map(clienteAposentadoInput, ClienteAposentado.class);
	}
	
	//teste
	public void copyToDomainObject(ClienteAposentadoInput clienteAposentadoInput, ClienteAposentado clienteAposentado) {
		modelMapper.map(clienteAposentadoInput, clienteAposentado);
	}
}
