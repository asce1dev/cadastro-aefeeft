package com.asce1dev.cadastroaefeeft.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asce1dev.cadastroaefeeft.api.model.ClienteModel;
import com.asce1dev.cadastroaefeeft.domain.model.Cliente;

@Component
public class ClienteModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ClienteModel toModel(Cliente cliente) {
		return modelMapper.map(cliente, ClienteModel.class);
	}
	
	public List<ClienteModel> toCollectionModel(List<Cliente> clientes) {
		return clientes.stream()
				.map(clienteAposentado -> toModel(clienteAposentado))
				.collect(Collectors.toList());
	}
}
