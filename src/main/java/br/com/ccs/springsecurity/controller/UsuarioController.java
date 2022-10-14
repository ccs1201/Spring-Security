package br.com.ccs.springsecurity.controller;

import br.com.ccs.springsecurity.entity.Usuario;
import br.com.ccs.springsecurity.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
//@PreAuthorize("isAuthenticated()")
public class UsuarioController {

    private UsuarioRepository repository;

    @GetMapping
//    @PreAuthorize("hasAnyRole('USERS', 'MANAGERS')")
    protected List<Usuario> get() {
        return repository.findAll();
    }

    @PostMapping
//    @PreAuthorize("hasRole('MANAGERS')")
    protected List<Usuario> post(@RequestBody @NonNull Usuario usuario) {
        repository.save(usuario);
        return repository.findAll();

    }

    @DeleteMapping
//    @PreAuthorize("hasRole('MANAGERS')")
    protected List<Usuario> delete(@RequestBody Usuario usuario) {
        repository.delete(usuario);
        return repository.findAll();

    }

}
