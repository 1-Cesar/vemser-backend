package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.EnumTipo;
import br.com.dbc.vemser.pessoaapi.exceptions.CustomGlobalExceptionHandler;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> list() {
        return ResponseEntity.ok(enderecoService.list());
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<List<Endereco>> listByIdEndereco (@PathVariable("idEndereco") int id) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.listByIdEndereco(id));
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<Endereco>> listByIdPessoa (@PathVariable("idPessoa") int id) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.listByIdPessoa(id));
    }

    @GetMapping("/bytipo")
    public List<Endereco> listByTipo(@RequestParam("tipo") EnumTipo tipo) {
        return enderecoService.listByTipo(tipo);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody Endereco endereco) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.create(id, endereco));
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update(@PathVariable("idEndereco") Integer id,
                           @Valid @RequestBody Endereco enderecoAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizar));
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        enderecoService.delete(id);
    }

}
