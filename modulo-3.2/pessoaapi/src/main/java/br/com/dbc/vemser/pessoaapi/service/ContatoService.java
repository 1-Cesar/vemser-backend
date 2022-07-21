package br.com.dbc.vemser.pessoaapi.service;
/**
 * @author Cesar
 * @version vemSer - DBC
 */

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    public List<ContatoDTO> list() {
        return contatoRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> listById(int id) throws RegraDeNegocioException {
        localizarContato(id);
        return contatoRepository.findById(id).stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public ContatoDTO create(Integer id, ContatoCreateDTO contatoDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = pessoaService.localizarPessoa(id);
        ContatoEntity contatoEntity = retornarContatoEntity(contatoDTO);

        contatoEntity.setPessoa(pessoaEntity);

        contatoRepository.save(contatoEntity);

        return retornarDTO(contatoEntity);
    }

    public ContatoDTO update(Integer id,
                          ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        ContatoEntity contatoEntity = localizarContato(id);

        contatoEntity.setNumero(contatoCreateDTO.getNumero());
        contatoEntity.setDescricao(contatoCreateDTO.getDescricao());
        contatoEntity.setTipoContato(contatoCreateDTO.getTipoContato());

        contatoRepository.save(contatoEntity);

        return retornarDTO(contatoEntity);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoEntity = localizarContato(id);
        contatoRepository.delete(contatoEntity);
    }

    public ContatoEntity localizarContato(Integer idContato) throws RegraDeNegocioException {
        log.info("Verificando se existe registro de Contato.....");
        return contatoRepository.findAll().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não localizado"));
    }

    public ContatoDTO retornarDTO (ContatoEntity contatoEntity) {
        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
    }

    public ContatoEntity retornarContatoEntity (ContatoCreateDTO contatoDTO) {
        return objectMapper.convertValue(contatoDTO, ContatoEntity.class);
    }
}