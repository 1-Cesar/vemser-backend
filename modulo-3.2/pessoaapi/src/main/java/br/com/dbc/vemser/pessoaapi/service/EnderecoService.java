package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return enderecoRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByIdEndereco(int id) throws RegraDeNegocioException {
        localizarEndereco(id);
        return enderecoRepository.findById(id).stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByIdPessoa(int id) throws RegraDeNegocioException {
        pessoaService.localizarPessoa(id);
        return enderecoRepository.findById(id).stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO create(Integer id, EnderecoDTO enderecoDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = pessoaService.localizarPessoa(id);

        List<PessoaEntity> pessoas = new ArrayList<>();
        pessoas.add(pessoaEntity);

        EnderecoEntity enderecoEntity = retornarEnderecoEntity(enderecoDTO);
        enderecoEntity.setPessoas(pessoas);

        enderecoRepository.save(enderecoEntity);

        return retornarDTO(enderecoEntity);
    }

    public EnderecoDTO update(Integer id,
                           EnderecoDTO enderecoDTO) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = localizarEndereco(id);

        enderecoEntity.setTipo(enderecoDTO.getTipo());
        enderecoEntity.setLogradouro(enderecoDTO.getLogradouro());
        enderecoEntity.setNumero(enderecoDTO.getNumero());
        enderecoEntity.setComplemento(enderecoDTO.getComplemento());
        enderecoEntity.setCep(enderecoDTO.getCep());
        enderecoEntity.setCidade(enderecoDTO.getCidade());
        enderecoEntity.setEstado(enderecoDTO.getEstado());
        enderecoEntity.setPais(enderecoDTO.getPais());

        PessoaEntity pessoaEntity = pessoaService.localizarPessoa(id);

        List<PessoaEntity> pessoas = new ArrayList<>();
        pessoas.add(pessoaEntity);

        enderecoEntity = retornarEnderecoEntity(enderecoDTO);

        enderecoEntity.setPessoas(pessoas);

        enderecoRepository.save(enderecoEntity);

        return retornarDTO(enderecoEntity);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = localizarEndereco(id);
        enderecoRepository.delete(enderecoEntity);
    }

    public EnderecoEntity localizarEndereco (Integer idEndereco) throws RegraDeNegocioException {
        log.info("Verificando se existe registro de Endereço.....");
        return enderecoRepository.findAll().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não localizado"));
    }

    public EnderecoDTO retornarDTO (EnderecoEntity enderecoEntity) {
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

    public EnderecoEntity retornarEnderecoEntity (EnderecoDTO enderecoDTO) {
        return objectMapper.convertValue(enderecoDTO, EnderecoEntity.class);
    }
}
