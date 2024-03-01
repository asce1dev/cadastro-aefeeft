package com.asce1dev.cadastroaefeeft.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asce1dev.cadastroaefeeft.api.model.ClientePensionistaResumoModel;
import com.asce1dev.cadastroaefeeft.domain.model.ClientePensionista;

@Component
public class ClientePensionistaResumoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ClientePensionistaResumoModel toModel(ClientePensionista clientePensionista) {
		return modelMapper.map(clientePensionista, ClientePensionistaResumoModel.class);
	}
	
	public List<ClientePensionistaResumoModel> toCollectionModel(List<ClientePensionista> clientesPensionistas) {
		return clientesPensionistas.stream()
				.map(pensionista -> toModel(pensionista))
				.collect(Collectors.toList());
		
	}
}
