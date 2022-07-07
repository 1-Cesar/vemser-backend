package br.com.dbc.vemser.pessoaapi.service;
/**
 * @author Cesar
 * @version vemSer - DBC
 */
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato create(Integer id, Contato contato) {
        contato.setIdContato(contatoRepository.getCOUNTER2().incrementAndGet());
        contato.setIdPessoa(id);
        contatoRepository.getListContatos().add(contato);
        return contato;
    }

    public List<Contato> list() {
        return contatoRepository.getListContatos();
    }

    public Contato update(Integer id,
                          Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = contatoRepository.getListContatos().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não localizado"));
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = contatoRepository.getListContatos().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não localizado"));
        contatoRepository.getListContatos().remove(contatoRecuperado);
    }

    public List<Contato> listByDescricao(String descricao) {
        return contatoRepository.getListContatos().stream()
                .filter(contato -> contato.getDescricao().toUpperCase().contains(descricao.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Contato> listById(int id) {
        return contatoRepository.getListContatos().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .collect(Collectors.toList());
    }
}
