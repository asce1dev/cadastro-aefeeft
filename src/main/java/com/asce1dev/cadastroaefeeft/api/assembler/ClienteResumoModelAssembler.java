package com.asce1dev.cadastroaefeeft.api.assembler;

import com.asce1dev.cadastroaefeeft.api.model.ClienteResumoModel;
import com.asce1dev.cadastroaefeeft.domain.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ClienteResumoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ClienteResumoModel toModel(Cliente cliente) {
		return modelMapper.map(cliente, ClienteResumoModel.class);
	}

	public Page<ClienteResumoModel> toPageModel(Page<Cliente> clientes) {
		return clientes.map(cliente -> toModel(cliente));
	}
}
