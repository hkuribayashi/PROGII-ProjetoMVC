package controller;

import dao.DAO;
import dao.PessoaDAO;
import model.Pessoa;

import java.util.List;

public class PessoaController {
    private final PessoaDAO dao;

    public PessoaController(){
        this.dao = new PessoaDAO();
    }

    public void cadastrarPessoa(String nome, String email){
        if (nome != null && email != null) {
            Pessoa p = new Pessoa(nome, email);
            this.dao.add(p);
        }else throw new IllegalArgumentException("Nome e E-mail são obrigatórios");
    }

    public List<Pessoa> getPessoas(){
        return this.dao.getAll();
    }

}