package br.com.alura.consumoenergia.adapter.rest.controller.repository;

import br.com.alura.consumoenergia.adapter.rest.controller.dto.EnderecoDto;
import br.com.alura.consumoenergia.adapter.rest.controller.dto.PessoaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEndereco extends JpaRepository<EnderecoDto, Long> {

    List<EnderecoDto> findByRua(String rua);

    List<EnderecoDto> findByRuaAndNumeroIgnoreCaseAndIdNot(String rua, String numero, Long id);
}
