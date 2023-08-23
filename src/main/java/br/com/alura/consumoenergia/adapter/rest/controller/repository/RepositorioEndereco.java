package br.com.alura.consumoenergia.adapter.rest.controller.repository;

import br.com.alura.consumoenergia.adapter.rest.controller.dto.EnderecoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEndereco extends JpaRepository<EnderecoDto, Long> {

}
