package dao;

import model.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private final List<Pessoa> dados;

    public PessoaDAO(){
        this.dados = new ArrayList<>();
    }

    public void inserir(Pessoa p){
        if (p != null)
            this.dados.add(p);
        else throw new IllegalArgumentException("Objeto Nulo/Vazio");
    }

    public List<Pessoa> getPessoas(){
        return this.dados;
    }
}