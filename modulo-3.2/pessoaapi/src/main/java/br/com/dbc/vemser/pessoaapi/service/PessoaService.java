package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public List<PessoaDTO> list(){
        return pessoaRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listById(Integer idPessoa) {
        return  pessoaRepository.findById(idPessoa).stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }



    public PessoaDTO create(PessoaDTO pessoaBodyDTO) {
        PessoaEntity pessoaEntity = retornarPessoaEntity(pessoaBodyDTO);
        pessoaRepository.save(pessoaEntity);

        return retornarDTO(pessoaEntity);
    }

    public PessoaDTO update(Integer id,
                         PessoaDTO pessoaBodyDTO) throws RegraDeNegocioException {
        localizarPessoa(id);

        PessoaEntity pessoaEntity = retornarPessoaEntity(pessoaBodyDTO);
        pessoaEntity.setIdPessoa(id);

        pessoaRepository.save(pessoaEntity);

        return retornarDTO(pessoaEntity);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = localizarPessoa(id);
        pessoaRepository.delete(pessoaEntity);
    }

    public PessoaEntity localizarPessoa (Integer idPessoa) throws RegraDeNegocioException {
        log.info("Verificando se existe registro de Pessoa.....");
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public PessoaDTO retornarDTO (PessoaEntity pessoaEntity) {
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }

    public PessoaEntity retornarPessoaEntity (PessoaDTO pessoaDTO) {
        return objectMapper.convertValue(pessoaDTO, PessoaEntity.class);
    }
}
