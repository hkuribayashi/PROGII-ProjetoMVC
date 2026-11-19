package dao;

import model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends  DAO<Pessoa>{

    @Override
    public void add(Pessoa p){
        String sql = "INSERT INTO Pessoas VALUES (?, ?)";
        try {
            Connection c = Conexao.obterConexao();
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, p.getNome());
            stm.setString(2, p.getEmail());
            stm.executeUpdate();
            IO.println("Pessoas cadastrada com sucesso");
        } catch (SQLException e) {
            IO.println("Deu erro na conexao com o Banco de Dados!");
        }
    }

    @Override
    public List<Pessoa> getAll(){
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM Pessoas";
        try {
            Connection c = Conexao.obterConexao();
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Pessoa p = new Pessoa(nome, email);
                pessoas.add(p);
            }

        } catch (SQLException e) {
            IO.println("Erro na consulta: "+sql);
            IO.println(e);
        }
        return pessoas;
    }
}