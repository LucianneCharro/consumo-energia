package br.com.alura.consumoenergia.adapter.rest.controller.repository;

import br.com.alura.consumoenergia.adapter.rest.controller.dto.PessoaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPessoa extends JpaRepository<PessoaDto, Long> {
    List<PessoaDto> findByCpf(String cpf);

    List<PessoaDto> findByCpfAndNomeIgnoreCaseAndIdNot(String cpf, String nome, Long id);
}
