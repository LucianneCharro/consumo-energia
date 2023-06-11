package br.com.alura.consumoenergia.repository;

import br.com.alura.consumoenergia.dominio.Pessoas;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RepositorioPessoas {

    //colection que não aceita elementos duplicado
    private Set<Pessoas> perfil;

    public RepositorioPessoas(){

        perfil = new HashSet<>();
    }
    public void salvar(Pessoas pessoas) {

        perfil.add(pessoas);
    }
}
