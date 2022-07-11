package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> list() {
        log.info("Mostrando todos os endereços");
        return ResponseEntity.ok(enderecoService.list());
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<List<EnderecoDTO>> listByIdEndereco (@PathVariable("idEndereco") int id) throws RegraDeNegocioException {
        log.info("Mostrando um único endereço por Id");
        return ResponseEntity.ok(enderecoService.listByIdEndereco(id));
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<EnderecoDTO>> listByIdPessoa (@PathVariable("idPessoa") int id) throws RegraDeNegocioException {
        log.info("Mostrando um endereço filtrado por uma pessoa");
        return ResponseEntity.ok(enderecoService.listByIdPessoa(id));
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoCreateDTO> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        log.info("Criando um endereço");
        return ResponseEntity.ok(enderecoService.create(id, endereco));
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                           @Valid @RequestBody EnderecoDTO enderecoAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando um endereço");
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizar));
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        log.info("Deletando um endereço");
        enderecoService.delete(id);
    }
}
