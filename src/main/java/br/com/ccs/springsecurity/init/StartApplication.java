package br.com.ccs.springsecurity.init;

import br.com.ccs.springsecurity.entity.Usuario;
import br.com.ccs.springsecurity.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class StartApplication implements CommandLineRunner {

    private UsuarioRepository repository;

    @Transactional
    @Override
    public void run(String... args) throws RuntimeException {
        Usuario user = repository.findByLogin("admin");
        if (user == null) {
            user = new Usuario();
            user.setNome("ADMIN");
            user.setLogin("admin");
            user.setSenha("master123");
            user.getRoles().add("MANAGERS");
            repository.save(user);
        }
        user = repository.findByLogin("user");
        if (user == null) {
            user = new Usuario();
            user.setNome("USER");
            user.setLogin("user");
            user.setSenha("user123");
            user.getRoles().add("USERS");
            repository.save(user);
        }
    }
}