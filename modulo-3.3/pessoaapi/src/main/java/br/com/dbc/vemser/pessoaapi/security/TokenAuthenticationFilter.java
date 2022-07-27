package br.com.dbc.vemser.pessoaapi.security;

import antlr.Token;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;


@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    private static final String BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // recuperar token da request
        String token = getTokenFromHeader(request);
        Optional<UsuarioEntity> optionalUsuarioEntity = tokenService.isValid(token);

        //validar token
        authenticate(optionalUsuarioEntity);

        filterChain.doFilter(request, response);
    }

    public void authenticate(Optional<UsuarioEntity> optionalUsuarioEntity) {

        //autenticar usuario
        boolean valido = !optionalUsuarioEntity.isEmpty();
        if(valido){
            UsuarioEntity usuarioEntity = optionalUsuarioEntity.get();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(usuarioEntity.getLogin(), null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }

    private String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null) {
            return  null;
        }
        return token.replace(BEARER, "");
    }
}
