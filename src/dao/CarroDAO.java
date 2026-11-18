package dao;

import model.Carro;

import java.util.List;

public class CarroDAO extends DAO<Carro> {

    @Override
    public void add(Carro c){
        if (c != null)
            this.dados.add(c);
        else throw new IllegalArgumentException("Objeto Nulo/Vazio");
    }

    @Override
    public List<Carro> getAll() {
        return this.dados;
    }
}