package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;

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

    public List<RelatorioPersonalizadoDTO> relatorioPersonalizado(Integer id){
        return pessoaRepository.relatorioPersonalizado(id);
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listById(Integer idPessoa) throws RegraDeNegocioException {
        localizarPessoa(idPessoa);
        return  pessoaRepository.findById(idPessoa).stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listarComEnderecos(Integer id) {
        if (id != null) {
            return pessoaRepository.findById(id).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);
                        pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();

        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);
                        pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        }
    }

    public List<PessoaDTO> listarComContatos(Integer id) {
        if (id != null) {
            return pessoaRepository.findById(id).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);
                        pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();

        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);
                        pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                                             .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                             .toList());
                        return pessoaDTO;
                    }).toList();
        }
    }

    public List<PessoaDTO> listarComPet(Integer id) {
        if (id != null) {
            return pessoaRepository.findById(id).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);
                        pessoaDTO.setPet(objectMapper.convertValue(pessoaEntity.getPet(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();

        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = retornarDTO(pessoaEntity);
                        pessoaDTO.setPet(objectMapper.convertValue(pessoaEntity.getPet(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        }
    }

    public List<PessoaCompletaDTO> listaPessoaCompleta(Integer idPessoa) {
        if(idPessoa == null) {
            return pessoaRepository.findAll().stream()
                    .map(this::conversoes)
                    .collect(Collectors.toList());
        } else {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(this::conversoes)
                    .collect(Collectors.toList());
        }
    }

    private PessoaCompletaDTO conversoes(PessoaEntity pessoaEntity) {

        PessoaCompletaDTO pessoaCompletaDTO = objectMapper.convertValue(pessoaEntity,PessoaCompletaDTO.class);

        pessoaCompletaDTO.setEnderecoDTOS(pessoaEntity.getEnderecos().stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity,EnderecoDTO.class))
                .collect(Collectors.toList()));
        pessoaCompletaDTO.setPet(objectMapper.convertValue(pessoaEntity.getPet(), PetDTO.class));
        pessoaCompletaDTO.setContatoDTOS(pessoaEntity.getContatos().stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList()));
        return pessoaCompletaDTO;
    }

    public PessoaDTO create(PessoaCreateDTO pessoaBodyDTO) {
        PessoaEntity pessoaEntity = retornarPessoaEntity(pessoaBodyDTO);
        pessoaRepository.save(pessoaEntity);
        return retornarDTO(pessoaEntity);
    }

    public PessoaDTO update(Integer id,
                         PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = localizarPessoa(id);

        pessoaEntity.setNome(pessoaCreateDTO.getNome());
        pessoaEntity.setCpf(pessoaCreateDTO.getCpf());
        pessoaEntity.setEmail(pessoaCreateDTO.getEmail());
        pessoaEntity.setDataNascimento(pessoaCreateDTO.getDataNascimento());

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

    public PessoaEntity retornarPessoaEntity (PessoaCreateDTO pessoaDTO) {
        return objectMapper.convertValue(pessoaDTO, PessoaEntity.class);
    }
}
