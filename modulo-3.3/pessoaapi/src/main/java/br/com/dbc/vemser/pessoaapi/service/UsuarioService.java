package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.UsuarioCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final ObjectMapper objectMapper;

    public Optional<UsuarioEntity> findByLoginAndSenha (String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    //public Optional<UsuarioEntity> findById(Integer idUsuario) {
//        return usuarioRepository.findById(idUsuario);
//    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }


    public UsuarioDTO registrar(UsuarioCreateDTO usuarioCreateDTO){
        UsuarioEntity usuarioEntity = objectMapper.convertValue(usuarioCreateDTO, UsuarioEntity.class);

        LdapShaPasswordEncoder encoder = new LdapShaPasswordEncoder();
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaEncoder = encoder.encode(usuarioEntity.getSenha());

        usuarioEntity.setSenha(senhaEncoder);
        usuarioRepository.save(usuarioEntity);

        return objectMapper.convertValue(usuarioEntity, UsuarioDTO.class);
    }

//    public UsuarioDTO recuperarUsuario(UsuarioDTO usuarioDTO) {
//    }

    public Integer getIdLoggedUser() {
        return (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public UsuarioDTO getLoggedUser() throws RegraDeNegocioException {
        return recuperarUsuario(getIdLoggedUser());
    }

    public UsuarioDTO recuperarUsuario(Integer idUsuario) throws  RegraDeNegocioException {
        return usuarioRepository.findById(idUsuario).stream()
                .map(usuarioEntity -> objectMapper.convertValue(usuarioEntity, UsuarioDTO.class))
                .findFirst().orElseThrow(() ->
                        new RegraDeNegocioException("Usuário não encontrado"));
    }
    /*public UsuarioDTO recuperarUsuario(Integer idUsuario) throws  RegraDeNegocioException {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new RegraDeNegocioException("Usuário não encontrado"));
        UsuarioDTO usuarioDTO = objectMapper.convertValue(usuarioEntity, UsuarioDTO.class);
        return usuarioDTO;
    }*/
}
