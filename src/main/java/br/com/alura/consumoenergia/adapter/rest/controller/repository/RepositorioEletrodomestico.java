package br.com.alura.consumoenergia.adapter.rest.controller.repository;

import br.com.alura.consumoenergia.adapter.rest.controller.dto.EletrodomesticoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepositorioEletrodomestico extends JpaRepository<EletrodomesticoDto, Long> {
    List<EletrodomesticoDto> findByNome(String nome);

//    List<EletrodomesticoDto> findByNomeIgnoreCa(String nome, Long id);
}

