package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.EnumTipo;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco create(Integer id, Endereco endereco) {
        endereco.setIdEndereco(enderecoRepository.getCOUNTER2().incrementAndGet());
        endereco.setIdPessoa(id);
        enderecoRepository.getListEnderecos().add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return enderecoRepository.getListEnderecos();
    }

    public Endereco update(Integer id,
                           Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.getListEnderecos().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não localizado"));
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.getListEnderecos().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não localizado"));
        enderecoRepository.getListEnderecos().remove(enderecoRecuperado);
    }

    public List<Endereco> listByTipo(EnumTipo tipo) {
        return enderecoRepository.getListEnderecos().stream()
                .filter(endereco -> endereco.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByIdEndereco(int id) {
        return enderecoRepository.getListEnderecos().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByIdPessoa(int id) {
        return enderecoRepository.getListEnderecos().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}
