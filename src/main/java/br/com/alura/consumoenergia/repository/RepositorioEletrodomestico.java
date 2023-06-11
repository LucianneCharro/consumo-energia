package br.com.alura.consumoenergia.repository;

import br.com.alura.consumoenergia.dominio.Eletrodomestico;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RepositorioEletrodomestico {

    //colection que não aceita elementos duplicado
    private Set<Eletrodomestico> eletro;

    public RepositorioEletrodomestico(){

        eletro = new HashSet<>();
    }
    public void salvar(Eletrodomestico eletrodomestico) {

        eletro.add(eletrodomestico);
    }
}
