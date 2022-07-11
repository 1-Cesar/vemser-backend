package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pessoa")
@Validated
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    @GetMapping("/ambiente")
    public String teste() {
        return propertieReader.getAmbiente();
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list() {
        log.info("Mostrando todas as pessoas");
        return ResponseEntity.ok(pessoaService.list());
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<List<PessoaDTO>> listById (@PathVariable("idPessoa") int id) {
        log.info("Mostrando uma única pessoa por Id");
        return ResponseEntity.ok(pessoaService.listById(id));
    }

    @PostMapping
    public ResponseEntity<PessoaCreateDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) {
        log.info("Criando uma pessoa");
        return ResponseEntity.ok(pessoaService.create(pessoa));
        //return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.I_AM_TEAPOT
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                         @Valid @RequestBody PessoaDTO pessoaAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando uma pessoa");
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("Deletando uma pessoa");
        pessoaService.delete(id);
    }
}
