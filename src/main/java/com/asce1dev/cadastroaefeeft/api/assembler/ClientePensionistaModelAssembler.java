package com.asce1dev.cadastroaefeeft.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asce1dev.cadastroaefeeft.api.model.ClientePensionistaModel;
import com.asce1dev.cadastroaefeeft.domain.model.ClientePensionista;

@Component
public class ClientePensionistaModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ClientePensionistaModel toModel(ClientePensionista clientePensionista) {
		return modelMapper.map(clientePensionista, ClientePensionistaModel.class);
	}
	
	public List<ClientePensionistaModel> toCollectionModel(List<ClientePensionista> clientesPensionistas) {
		return clientesPensionistas.stream()
				.map(pensionista -> toModel(pensionista))
				.collect(Collectors.toList());
		
	}
}
