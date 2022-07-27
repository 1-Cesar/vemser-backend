package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.security.TokenService;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    private final TokenService tokenService;

    @Operation(summary = "realiza o login de um usuário", description = "realiza o login de um determinado usuário gerando seu respectivo token")
    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO login) throws RegraDeNegocioException {
        Optional<UsuarioEntity> usuarioOptional = usuarioService.findByLoginAndSenha(login.getLogin(), login.getSenha());
        if(usuarioOptional.isPresent()){
            String token = tokenService.getToken(usuarioOptional.get());
            return token;
        }
        throw new RegraDeNegocioException("Usuario ou senha inválidos!");
    }
}
