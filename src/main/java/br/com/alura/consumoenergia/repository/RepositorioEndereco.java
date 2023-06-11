package br.com.alura.consumoenergia.repository;

import br.com.alura.consumoenergia.dominio.Endereco;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RepositorioEndereco {

    //colection que não aceita elementos duplicado
    private Set<Endereco> local;

    public RepositorioEndereco(){

        local = new HashSet<>();
    }
    public void salvar(Endereco endereco) {

        local.add(endereco);
    }
}
