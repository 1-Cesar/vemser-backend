package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Operation(summary = "listar todos os endereços", description = "recupera todos os endereços do banco de dados")
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> list() {
        log.info("Mostrando todos os endereços");
        return ResponseEntity.ok(enderecoService.list());
    }

    @Operation(summary = "lista um endereço por seu id", description = "recupera um endereço do banco de dados atraves de seu id")
    @GetMapping("/{idEndereco}")
    public ResponseEntity<List<EnderecoDTO>> listById(@PathVariable("idEndereco") int id) throws RegraDeNegocioException {
        log.info("Mostrando um único endereço por Id");
        return ResponseEntity.ok(enderecoService.listByIdEndereco(id));
    }

    @Operation(summary = "lista um endereço pelo id da pessoa", description = "recupera um endereço do banco de dados atraves do id da pessoa")
    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<EnderecoDTO>> listByIdPessoa(@PathVariable("idPessoa") int id) throws RegraDeNegocioException {
        log.info("Mostrando um endereço filtrado por uma pessoa");
        return ResponseEntity.ok(enderecoService.listByIdPessoa(id));
    }

    @Operation(summary = "filtra endereços por país", description = "recupera todos os endereços com base no país fornecido")
    @GetMapping("/endereco-pais")
    public List<EnderecoEntity> getEnderecoByPais(String enderecoEntity) {
        List<EnderecoEntity> enderecoEntities = enderecoRepository.listEnderecoByPais(enderecoEntity);
        return enderecoEntities;
    }

    @Operation(summary = "Paginação de endereços por país", description = "recupera todos os endereços com base no país fornecido, de forma paginada")
    @GetMapping("/relatorio-paginado-pais")
    public Page<EnderecoEntity> getRelatorioPaginadoPais(Integer pagina, Integer quantidadeRegistros, @RequestParam(required = false) String pais){
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros);
        return enderecoRepository.paginacaoEnderecoByPais(pais, pageable);
    }

    @Operation(summary = "Paginação de endereços por cep ordenado", description = "recupera todos os endereços, de forma paginada e cep ordenado")
    @GetMapping("/relatorio-paginado-cep")
    public Page<EnderecoEntity> getRelatorioPaginadoCep(Integer pagina, Integer quantidadeRegistros){
        Sort ordenacao = Sort.by("cep");
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
        return enderecoRepository.paginacaoEnderecoByCep(pageable);
    }

    @Operation(summary = "cria um endereço atraves do id da pessoa", description = "cria um endereço dentro do banco de dados com base no id da pessoa")
    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer id,
                                              @Valid @RequestBody EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        log.info("Criando um endereço");
        return ResponseEntity.ok(enderecoService.create(id, enderecoCreateDTO));
    }

    @Operation(summary = "altera um endereço por id", description = "altera os registros de um endereço no banco de dados atraves de seu id")
    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                                              @Valid @RequestBody EnderecoDTO enderecoDTO) throws RegraDeNegocioException {
        log.info("Atualizando um endereço");
        return ResponseEntity.ok(enderecoService.update(id, enderecoDTO));
    }

    @Operation(summary = "deleta um endereço", description = "deleta um endereço do banco de dados atraves de seu id")
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        log.info("Deletando um endereço");
        enderecoService.delete(id);
    }
}
