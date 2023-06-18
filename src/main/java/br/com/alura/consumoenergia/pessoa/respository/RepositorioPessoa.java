package br.com.alura.consumoenergia.pessoa.respository;

import br.com.alura.consumoenergia.pessoa.dominio.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RepositorioPessoa {

    //colection que não aceita elementos duplicado
    private Set<Pessoa> perfil;

    public RepositorioPessoa(){

        perfil = new HashSet<>();
    }
    public void salvar(Pessoa pessoas) {

        perfil.add(pessoas);
    }
}
