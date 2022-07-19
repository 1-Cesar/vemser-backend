package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
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
        return enderecoRepository.findAll().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByIdEndereco(int id) throws RegraDeNegocioException {
        localizarEndereco(id);
        return enderecoRepository.findById(id).stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    /*public List<EnderecoDTO> listByIdPessoa(int id) throws RegraDeNegocioException {
        pessoaService.localizarPessoa(id);
        return enderecoRepository.findById(id).stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }*/

    public EnderecoDTO create(Integer id, EnderecoCreateDTO endereco) throws RegraDeNegocioException {

        pessoaService.localizarPessoa(id);
        endereco.setIdPessoa(id);

        EnderecoEntity idEndereco = enderecoRepository.save(objectMapper.convertValue(endereco, EnderecoEntity.class));

        return objectMapper.convertValue(idEndereco, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id,
                           EnderecoDTO enderecoAtualizar) throws RegraDeNegocioException {

        EnderecoEntity enderecoRecuperado = localizarEndereco(id);

        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        return objectMapper.convertValue(enderecoRepository.save(enderecoRecuperado), EnderecoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoRecuperado = localizarEndereco(id);

        enderecoRepository.delete(enderecoRecuperado);
    }

    public EnderecoEntity localizarEndereco (Integer idEndereco) throws RegraDeNegocioException {
        log.info("Verificando se existe registro de Endereço.....");
        return enderecoRepository.findAll().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não localizado"));
    }
}
