package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private PessoaRepository pessoaRepository;

    @Autowired
    private PropertieReader propertieReader;

    @Autowired
    private EmailService emailService;

    /*@GetMapping("/ambiente")
    public String teste() {
        return propertieReader.getAmbiente();
    }*/

    @Value("${ola}")
    private String app;

    @Operation(summary = "listar pessoas", description = "recupera todas as pessoas do banco de dados")
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list() {
        log.info("Mostrando todas as pessoas");
        return ResponseEntity.ok(pessoaService.list());
    }

    @Operation(summary = "listar pessoa por id", description = "recupera uma pessoa do banco de dados atraves de seu id")
    @GetMapping("/{idPessoa}")
    public ResponseEntity<List<PessoaDTO>> listById (@PathVariable("idPessoa") int id) throws RegraDeNegocioException {
        log.info("Mostrando uma única pessoa por Id");
        return ResponseEntity.ok(pessoaService.listById(id));
    }

    @GetMapping("nome/{nome}")
    public ResponseEntity<List<PessoaEntity>> listByNome (@PathVariable("nome") String nome) throws RegraDeNegocioException {
        log.info("Mostrando uma única pessoa por nome");
        return ResponseEntity.ok(pessoaRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @GetMapping("cpf/{cpf}")
    public ResponseEntity<List<PessoaEntity>> listByCpf (@PathVariable("cpf") String cpf) throws RegraDeNegocioException {
        log.info("Mostrando uma única pessoa por cpf");
        return ResponseEntity.ok(pessoaRepository.findAllByCpfContainingIgnoreCase(cpf));
    }

    @Operation(summary = "criar pessoa", description = "cria uma pessoa dentro do banco de dados")
    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaDTO pessoa) {
        log.info("Criando uma pessoa");
        return ResponseEntity.ok(pessoaService.create(pessoa));
        //return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.I_AM_TEAPOT
    }

    @Operation(summary = "deleta pessoa", description = "deleta uma pessoa do banco de dados atraves de seu id")
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("Deletando uma pessoa");
        pessoaService.delete(id);
    }
}
