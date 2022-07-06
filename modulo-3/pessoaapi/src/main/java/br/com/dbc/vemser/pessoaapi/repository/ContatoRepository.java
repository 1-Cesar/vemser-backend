package br.com.dbc.vemser.pessoaapi.repository;
/**
 * @author Cesar
 * @version vemSer - DBC
 */
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.EnumTipo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {
    private static List<Contato> listContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    private AtomicInteger COUNTER2 = new AtomicInteger();

    public ContatoRepository() {
        listContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, COUNTER2.incrementAndGet(), "Whatsapp", EnumTipo.COMERCIAL));
        listContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, COUNTER2.incrementAndGet(), "Telegram", EnumTipo.RESIDENCIAL));
        listContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, COUNTER2.incrementAndGet(), "Whatsapp", EnumTipo.COMERCIAL));
        listContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, COUNTER2.incrementAndGet(), "Whatsapp", EnumTipo.RESIDENCIAL));
        listContatos.add(new Contato(COUNTER.incrementAndGet() /*5*/, COUNTER2.incrementAndGet(), "Telegram", EnumTipo.COMERCIAL));
    }

    public Contato create(Integer id, Contato contato) {
        contato.setIdContato(COUNTER2.incrementAndGet());
        contato.setIdPessoa(id);
        listContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listContatos;
    }

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = listContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrada"));
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = listContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));
        listContatos.remove(contatoRecuperado);
    }

    public List<Contato> listByDescricao(String descricao) {
        return listContatos.stream()
                .filter(contato -> contato.getDescricao().toUpperCase().contains(descricao.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Contato> listById(int id) {
        return listContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .collect(Collectors.toList());
    }
}
