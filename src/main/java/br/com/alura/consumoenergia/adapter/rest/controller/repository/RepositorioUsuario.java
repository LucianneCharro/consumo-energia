package br.com.alura.consumoenergia.adapter.rest.controller.repository;

import br.com.alura.consumoenergia.adapter.rest.controller.dto.PessoaDto;
import br.com.alura.consumoenergia.adapter.rest.controller.dto.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioUsuario extends JpaRepository<UsuarioDto, Long> {
    List<UsuarioDto> findByEmail(String email);

}
