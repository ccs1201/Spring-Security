package br.com.ccs.springsecurity.service;

import br.com.ccs.springsecurity.entity.Usuario;
import br.com.ccs.springsecurity.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class SecurityDatabaseService implements UserDetailsService {

    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        Usuario userEntity = repository.findByLogin(login);
        if (userEntity == null) {
            throw new UsernameNotFoundException(login);
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        userEntity.getRoles().forEach(role ->
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role)));
        UserDetails user = new User(userEntity.getLogin(),
                userEntity.getSenha(),
                authorities);
        return user;
    }
}