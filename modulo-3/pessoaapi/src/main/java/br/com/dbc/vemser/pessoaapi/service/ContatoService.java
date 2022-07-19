package br.com.dbc.vemser.pessoaapi.service;
/**
 * @author Cesar
 * @version vemSer - DBC
 */
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
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
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> listById(int id) throws RegraDeNegocioException {
        localizarContato(id);
        return contatoRepository.findById(id).stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoCreateDTO create(Integer id, ContatoCreateDTO contato) throws RegraDeNegocioException {
        pessoaService.localizarPessoa(id);

        contato.setIdPessoa(id);
        ContatoEntity idContato = contatoRepository.save(objectMapper.convertValue(contato, ContatoEntity.class));


        return objectMapper.convertValue(idContato, ContatoDTO.class);
    }

    public ContatoDTO update(Integer id,
                          ContatoDTO contatoAtualizar) throws RegraDeNegocioException {
        ContatoEntity contatoRecuperado = localizarContato(id);

        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());

        return objectMapper.convertValue(contatoRepository.save(contatoRecuperado), ContatoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoRecuperado = localizarContato(id);
        contatoRepository.delete(contatoRecuperado);
    }

    public ContatoEntity localizarContato(Integer idContato) throws RegraDeNegocioException {
        log.info("Verificando se existe registro de Contato.....");
        return contatoRepository.findAll().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não localizado"));
    }
}