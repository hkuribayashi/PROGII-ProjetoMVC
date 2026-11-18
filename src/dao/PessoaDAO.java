package dao;

import model.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends  DAO<Pessoa>{

    @Override
    public void add(Pessoa p){
        if (p != null)
            this.dados.add(p);
        else throw new IllegalArgumentException("Objeto Nulo/Vazio");
    }

    @Override
    public List<Pessoa> getAll(){
        return this.dados;
    }
}