package br.com.dbc.vemser.pessoaapi.geradordesenha;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorDeSenha {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senha = bCryptPasswordEncoder.encode("123");
        System.out.println(senha);

        String minhaSenhaCript = "$2a$10$qAZyGU6HBpm8W.kVpyg9eO70nNc.Cp3kp/FAyvRq7qN7f2x84X7ai";
        boolean matches = bCryptPasswordEncoder.matches("123", minhaSenhaCript);
        System.out.println(matches);
    }
}
