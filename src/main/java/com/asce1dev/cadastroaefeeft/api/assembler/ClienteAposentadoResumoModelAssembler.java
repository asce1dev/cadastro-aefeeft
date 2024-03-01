package com.asce1dev.cadastroaefeeft.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asce1dev.cadastroaefeeft.api.model.ClienteAposentadoResumoModel;
import com.asce1dev.cadastroaefeeft.domain.model.ClienteAposentado;

@Component
public class ClienteAposentadoResumoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ClienteAposentadoResumoModel toModel(ClienteAposentado clienteAposentado) {
		return modelMapper.map(clienteAposentado, ClienteAposentadoResumoModel.class);
	}
	
	public List<ClienteAposentadoResumoModel> toCollectionModel(List<ClienteAposentado> clientesAposentados) {
		return clientesAposentados.stream()
				.map(clienteAposentado -> toModel(clienteAposentado))
				.collect(Collectors.toList());
	}
}
