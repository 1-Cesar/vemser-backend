package br.com.dbc.vemser.pessoaapi.service;
/**
 * @author Cesar
 * @version vemSer - DBC
 */
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    public Contato create(Integer id, Contato contato) throws RegraDeNegocioException {
        pessoaService.localizarPessoa(id);
        return contatoRepository.create(id, contato);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update(Integer id,
                          Contato contatoAtualizar) throws RegraDeNegocioException {
        localizarContato(id);
        Contato contatoRecuperado = localizarContato(id);
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        localizarContato(id);
        Contato contatoRecuperado = localizarContato(id);
        contatoRepository.list().remove(contatoRecuperado);
    }

    public List<Contato> listById(int id) throws RegraDeNegocioException {
        localizarContato(id);
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .collect(Collectors.toList());
    }

    public Contato localizarContato(Integer idContato) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não localizado"));
        return contatoRecuperado;
    }
}