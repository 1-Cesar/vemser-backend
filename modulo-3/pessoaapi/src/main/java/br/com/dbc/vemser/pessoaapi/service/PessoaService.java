package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa create(Pessoa pessoa) {
        pessoa.setIdPessoa(pessoaRepository.getCOUNTER().incrementAndGet());
        pessoaRepository.getListaPessoas().add(pessoa);

        return pessoa;
    }

    public List<Pessoa> list(){
        return pessoaRepository.getListaPessoas();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = pessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não localizada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = pessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
        pessoaRepository.getListaPessoas().remove(pessoaRecuperada);
    }

    public List<Pessoa> listById(int id) {
        return pessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }
}
