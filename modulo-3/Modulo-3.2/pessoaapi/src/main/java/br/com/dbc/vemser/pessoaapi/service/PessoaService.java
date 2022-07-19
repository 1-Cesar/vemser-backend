package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
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
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listById(Integer idPessoa) {
        return  pessoaRepository.findById(idPessoa).stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO create(PessoaCreateDTO pessoa) {
        PessoaEntity id = pessoaRepository.save(objectMapper.convertValue(pessoa, PessoaEntity.class));
        emailService.sendEmail(objectMapper.convertValue(id, PessoaDTO.class), EnumEmail.CREATE);
        return objectMapper.convertValue(id, PessoaDTO.class);
    }

    public PessoaDTO update(Integer id,
                         PessoaDTO pessoaAtualizar) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = localizarPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        emailService.sendEmail(objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class), EnumEmail.PUT);
        return objectMapper.convertValue(pessoaRepository.save(pessoaRecuperada), PessoaDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = localizarPessoa(id);

        emailService.sendEmail(objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class),EnumEmail.DELETE);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public PessoaEntity localizarPessoa (Integer idPessoa) throws RegraDeNegocioException {
        log.info("Verificando se existe registro de Pessoa.....");
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }
}
