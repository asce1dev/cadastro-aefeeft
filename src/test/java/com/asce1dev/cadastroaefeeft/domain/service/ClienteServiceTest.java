package com.asce1dev.cadastroaefeeft.domain.service;

import com.asce1dev.cadastroaefeeft.domain.exception.ClienteNaoEncontradoException;
import com.asce1dev.cadastroaefeeft.domain.exception.CpfDuplicadoException;
import com.asce1dev.cadastroaefeeft.domain.exception.EntidadeEmUsoException;
import com.asce1dev.cadastroaefeeft.domain.exception.NegocioException;
import com.asce1dev.cadastroaefeeft.domain.model.Cliente;
import com.asce1dev.cadastroaefeeft.domain.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void deve_listar_todos_quando_nome_e_cpf_vazios() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Cliente> pageMock = new PageImpl<>(List.of(), pageable, 0);

        when(clienteRepository.findAll(pageable)).thenReturn(pageMock);

        Page<Cliente> result = clienteService.listarClientes(null, null, pageable);

        assertNotNull(result);
        verify(clienteRepository).findAll(pageable);
        verifyNoMoreInteractions(clienteRepository);
    }

    @Test
    void deve_buscar_clientes_por_nome_quando_informado() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Cliente> pageMock = new PageImpl<>(List.of(), pageable, 0);

        when(clienteRepository.findClienteByNomeStartingWithIgnoreCase("Al", pageable)).thenReturn(pageMock);

        Page<Cliente> result = clienteService.listarClientes("  Al  ", null, pageable);

        assertNotNull(result);
        verify(clienteRepository, times(1))
                .findClienteByNomeStartingWithIgnoreCase("Al", pageable);
        verify(clienteRepository, never()).findAll(any(Pageable.class));
        verifyNoMoreInteractions(clienteRepository);
    }

    @Test
    void deve_buscar_clientes_por_cpf_removendo_mascara() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Cliente> pageMock = new PageImpl<>(List.of(), pageable, 0);

        when(clienteRepository.findClienteByCpfStartingWith("234109", pageable)).thenReturn(pageMock);

        Page<Cliente> result = clienteService.listarClientes(null, " 234.109 ", pageable);

        assertNotNull(result);
        verify(clienteRepository, times(1))
                .findClienteByCpfStartingWith("234109", pageable);
        verify(clienteRepository, never()).findAll(any(Pageable.class));
        verifyNoMoreInteractions(clienteRepository);
    }

    @Test
    void deve_acusar_erro_com_nome_e_cpf() {
        Pageable pageable = PageRequest.of(0, 10);

        assertThrows(NegocioException.class, () ->
                clienteService.listarClientes(" Al ", " 234.109", pageable));

        verifyNoInteractions(clienteRepository);
    }

    @Test
    void deve_salvar_cliente_com_sucesso() {
        Cliente cliente = new Cliente();

        when(clienteRepository.saveAndFlush(cliente)).thenReturn(cliente);

        Cliente result = clienteService.salvarCliente(cliente);

        assertNotNull(result);
        verify(clienteRepository).saveAndFlush(cliente);
        verifyNoMoreInteractions(clienteRepository);
    }

    @Test
    void deve_acusar_erro_de_cpf_duplicado() {
        Cliente cliente = new Cliente();

        when(clienteRepository.saveAndFlush(cliente))
                .thenThrow(DataIntegrityViolationException.class);

        assertThrows(CpfDuplicadoException.class, () ->
                clienteService.salvarCliente(cliente));

        verify(clienteRepository).saveAndFlush(cliente);
    }

    @Test
    void deve_deletar_cliente_com_sucesso() {
        Long id = 1L;

        clienteService.deletarCliente(id);

        verify(clienteRepository).deleteById(id);
        verifyNoMoreInteractions(clienteRepository);
    }

    @Test
    void deve_acusar_erro_de_cliente_nao_encontrado() {
        Long id = 1L;

        doThrow(new EmptyResultDataAccessException(1))
                .when(clienteRepository)
                .deleteById(id);

        assertThrows(ClienteNaoEncontradoException.class, () ->
                clienteService.deletarCliente(id));

        verify(clienteRepository).deleteById(id);
    }

    @Test
    void deve_acusar_erro_de_cliente_em_uso() {
        Long id = 1L;

        doThrow(new DataIntegrityViolationException(""))
                .when(clienteRepository)
                .deleteById(id);

        assertThrows(EntidadeEmUsoException.class, () ->
                clienteService.deletarCliente(id));

        verify(clienteRepository).deleteById(id);
    }

    @Test
    void deve_buscar_cliente_quando_id_existir() {
        Cliente cliente = new Cliente();
        Long id = 1L;

        when(clienteRepository.findById(id)).thenReturn(Optional.of(cliente));

        Cliente result = clienteService.buscarOuFalhar(id);

        assertNotNull(result);
        verify(clienteRepository).findById(id);
        verifyNoMoreInteractions(clienteRepository);
    }

    @Test
    void deve_acusar_erro_de_cliente_nao_encontrado_ao_tentar_buscar() {
        Long id = 1L;

        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ClienteNaoEncontradoException.class, () ->
                clienteService.buscarOuFalhar(id));

        verify(clienteRepository).findById(id);
    }
}
