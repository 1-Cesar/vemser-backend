package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;

import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    public List<PetDTO> list(){
        return petRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<PetDTO> listById(Integer idPet) {
        return  petRepository.findById(idPet).stream()
                .filter(pet -> pet.getIdPet().equals(idPet))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public PetDTO create(PetCreateDTO petDTO) throws RegraDeNegocioException {
        PetEntity petEntity = retornerPetEntityByCreateDto(petDTO);
        petEntity.setPessoa(pessoaService.localizarPessoa(petDTO.getIdPessoa()));
        petRepository.save(petEntity);

        return retornarDTO(petEntity);
    }

    public PetDTO update(Integer id,
                            PetDTO petDTO) throws RegraDeNegocioException {


        PetEntity petEntity = retornarPetEntity(petDTO);
        petEntity.setIdPet(id);
        petEntity.setPessoa(pessoaService.localizarPessoa(petDTO.getIdPessoa()));
        petRepository.save(petEntity);

        return retornarDTO(petEntity);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        PetEntity petEntity = localizarPet(id);
        petRepository.delete(petEntity);
    }

    public PetDTO retornarDTO (PetEntity petEntity) {
        return objectMapper.convertValue(petEntity, PetDTO.class);
    }

    public PetEntity retornerPetEntityByCreateDto (PetCreateDTO petEntity) {
        return objectMapper.convertValue(petEntity, PetEntity.class);
    }

    public PetEntity retornarPetEntity (PetDTO petDTO) {
        return objectMapper.convertValue(petDTO, PetEntity.class);
    }

    public PetEntity localizarPet (Integer idPet) throws RegraDeNegocioException {
        return petRepository.findAll().stream()
                .filter(pet -> pet.getIdPet().equals(idPet))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
    }
}
