package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public List<EnderecoDTO> list(){
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByIdEndereco(int id) throws RegraDeNegocioException {
        localizarEndereco(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByIdPessoa(int id) throws RegraDeNegocioException {
        pessoaService.localizarPessoa(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoCreateDTO create(Integer id, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        Pessoa nome = pessoaService.localizarPessoa(id);
        emailService.nome = nome;
        Endereco idEndereco = enderecoRepository.create(id, objectMapper.convertValue(endereco, Endereco.class));
        return (EnderecoCreateDTO) emailService.sendEmail(objectMapper.convertValue(idEndereco, EnderecoDTO.class),4);
    }

    public EnderecoDTO update(Integer id,
                           EnderecoDTO enderecoAtualizar) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = localizarEndereco(id);
        Pessoa nome = pessoaService.localizarPessoa(enderecoRecuperado.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        emailService.nome = nome;
        return (EnderecoDTO) emailService.sendEmail(objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class),2);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = localizarEndereco(id);
        Pessoa nome = pessoaService.localizarPessoa(enderecoRecuperado.getIdPessoa());
        emailService.nome = nome;
        emailService.sendEmail(objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class),5);
        enderecoRepository.list().remove(enderecoRecuperado);
    }

    public Endereco localizarEndereco (Integer idEndereco) throws RegraDeNegocioException {
        log.info("Verificando se existe registro de Endereço.....");
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não localizado"));
        return enderecoRecuperado;
    }
}
