package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.EnumTipo;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> listByIdEndereco (@PathVariable("idEndereco") int id) {
        return enderecoService.listByIdEndereco(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa (@PathVariable("idPessoa") int id) {
        return enderecoService.listByIdPessoa(id);
    }

    @GetMapping("/bytipo")
    public List<Endereco> listByTipo(@RequestParam("tipo") EnumTipo tipo) {
        return enderecoService.listByTipo(tipo);
    }

    @PostMapping("/{idPessoa}")
    public Endereco create(@PathVariable("idPessoa") Integer id, @RequestBody Endereco endereco) {
        return enderecoService.create(id, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable("idEndereco") Integer id,
                          @RequestBody Endereco enderecoAtualizar) throws Exception {
        return enderecoService.update(id, enderecoAtualizar);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }

}
