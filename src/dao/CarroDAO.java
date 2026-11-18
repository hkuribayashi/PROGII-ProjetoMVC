package dao;

import model.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

    private final List<Carro> dados;

    public CarroDAO(){
        this.dados = new ArrayList<>();
    }

    public void inserir(Carro c){
        if (c != null)
            this.dados.add(c);
        else throw new IllegalArgumentException("Carro inválido");
    }

    public List<Carro> getCarros(){
        return this.dados;
    }
}
