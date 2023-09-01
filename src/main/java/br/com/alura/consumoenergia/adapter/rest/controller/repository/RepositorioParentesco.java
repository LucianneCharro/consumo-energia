package br.com.alura.consumoenergia.adapter.rest.controller.repository;

import br.com.alura.consumoenergia.adapter.rest.controller.dto.ParentescoDto;
import br.com.alura.consumoenergia.adapter.rest.controller.dto.PessoaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioParentesco extends JpaRepository<ParentescoDto, Long> {
    List<ParentescoDto> findByDescricao(String descricao);

}
