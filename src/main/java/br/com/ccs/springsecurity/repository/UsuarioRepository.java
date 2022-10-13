package br.com.ccs.springsecurity.repository;

import br.com.ccs.springsecurity.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u join fetch u.roles where u.login = :login")
    Usuario findByLogin(String login);

}
