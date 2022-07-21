package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import br.com.dbc.vemser.pessoaapi.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetRepository petRepository;

    @Operation(summary = "listar todos os pets", description = "recupera todos os pets do banco de dados")
    @GetMapping
    public ResponseEntity<List<PetDTO>> list() {
        return ResponseEntity.ok(petService.list());
    }

    @Operation(summary = "lista um único pet", description = "recupera um único pet do banco de dados")
    @GetMapping("/{idPet}")
    public ResponseEntity<List<PetDTO>> listById (@PathVariable("idPet") int id) throws RegraDeNegocioException {
        return ResponseEntity.ok(petService.listById(id));
    }

    @Operation(summary = "cadastra um pet pelo id da pessoa", description = "cadastra um pet no banco de dados através do id da pessoa")
    @PostMapping("/{idPessoa}")
    public ResponseEntity<PetDTO> create(@PathVariable ("idPessoa") Integer idPessoa,
                                         @RequestBody PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        return ResponseEntity.ok(petService.create(idPessoa, petCreateDTO));
        //return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.I_AM_TEAPOT
    }

    @Operation(summary = "atualiza um pet", description = "atualiza os registros de um pet dentro do banco de dados")
    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> atualizar(@PathVariable("idPet") Integer id,
                                            @RequestBody PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        return ResponseEntity.ok(petService.update(id, petCreateDTO));
    }

    @Operation(summary = "deleta um pet", description = "deleta um pet do banco de dados")
    @DeleteMapping("/{idPet}")
    public void delete(@PathVariable("idPet") Integer id) throws RegraDeNegocioException {
        petService.delete(id);
    }
}
