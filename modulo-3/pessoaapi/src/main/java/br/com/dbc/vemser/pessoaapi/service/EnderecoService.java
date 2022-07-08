package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.EnumTipo;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    public Endereco create(Integer id, Endereco endereco) throws RegraDeNegocioException {
        pessoaService.localizarPessoa(id);
        return enderecoRepository.create(id, endereco);
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco update(Integer id,
                           Endereco enderecoAtualizar) throws RegraDeNegocioException {
        localizarEndereco(id);
        Endereco enderecoRecuperado = localizarEndereco(id);
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

    public void delete(Integer id) throws RegraDeNegocioException {
        localizarEndereco(id);
        Endereco enderecoRecuperado = localizarEndereco(id);
        enderecoRepository.list().remove(enderecoRecuperado);
    }

    public List<Endereco> listByTipo(EnumTipo tipo) {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByIdEndereco(int id) throws RegraDeNegocioException {
        localizarEndereco(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByIdPessoa(int id) throws RegraDeNegocioException {
        pessoaService.localizarPessoa(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public Endereco localizarEndereco (Integer idEndereco) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não localizado"));
        return enderecoRecuperado;
    }
}
