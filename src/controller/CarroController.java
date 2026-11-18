package controller;

import dao.CarroDAO;
import model.Carro;

import java.util.List;

public class CarroController {

    private final CarroDAO dao;

    public CarroController(){
        this.dao = new CarroDAO();
    }

    public void inserirCarro(Integer ano, String modelo){
        if (ano != null && modelo != null){
            Carro c = new Carro(ano, modelo);
            this.dao.add(c);
        }else throw new IllegalArgumentException("Dados inválidos");
    }

    public List<Carro> getCarros(){
        return this.dao.getAll();
    }
}
