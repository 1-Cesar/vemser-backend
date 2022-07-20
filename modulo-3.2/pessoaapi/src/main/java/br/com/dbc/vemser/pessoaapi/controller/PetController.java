package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import br.com.dbc.vemser.pessoaapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public ResponseEntity<List<PetDTO>> list() {
        return ResponseEntity.ok(petService.list());
    }

    @GetMapping("/{idPet}")
    public ResponseEntity<List<PetDTO>> listById (@PathVariable("idPet") int id) throws RegraDeNegocioException {
        return ResponseEntity.ok(petService.listById(id));
    }

    @PostMapping
    public ResponseEntity<PetDTO> create(@Valid @RequestBody PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        return ResponseEntity.ok(petService.create(petCreateDTO));
        //return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.I_AM_TEAPOT
    }

    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> atualizar(@PathVariable("idPet") Integer id, @RequestBody PetDTO petDTO) throws RegraDeNegocioException {
        return ResponseEntity.ok(petService.update(id, petDTO));
    }

    @DeleteMapping("/{idPet}")
    public void delete(@PathVariable("idPet") Integer id) throws RegraDeNegocioException {
        petService.delete(id);
    }
}
