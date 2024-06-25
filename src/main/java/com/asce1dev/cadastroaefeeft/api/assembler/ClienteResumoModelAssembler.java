package com.asce1dev.cadastroaefeeft.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asce1dev.cadastroaefeeft.api.model.ClienteResumoModel;
import com.asce1dev.cadastroaefeeft.domain.model.Cliente;

@Component
public class ClienteResumoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ClienteResumoModel toModel(Cliente clienteAposentado) {
		return modelMapper.map(clienteAposentado, ClienteResumoModel.class);
	}
	
	public List<ClienteResumoModel> toCollectionModel(List<Cliente> clientes) {
		return clientes.stream()
				.map(cliente -> toModel(cliente))
				.collect(Collectors.toList());
	}
}
