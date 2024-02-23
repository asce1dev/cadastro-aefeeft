package com.asce1dev.cadastroaefeeft.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asce1dev.cadastroaefeeft.api.model.ClienteAposentadoModel;
import com.asce1dev.cadastroaefeeft.domain.model.ClienteAposentado;

@Component
public class ClienteAposentadoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ClienteAposentadoModel toModel(ClienteAposentado clienteAposentado) {
		return modelMapper.map(clienteAposentado, ClienteAposentadoModel.class);
	}
	
	public List<ClienteAposentadoModel> toCollectionModel(List<ClienteAposentado> clientesAposentados) {
		return clientesAposentados.stream()
				.map(clienteAposentado -> toModel(clienteAposentado))
				.collect(Collectors.toList());
	}
}
