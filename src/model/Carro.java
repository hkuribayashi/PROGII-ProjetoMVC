package model;

public class Carro {

    private Integer ano;
    private String modelo;

    public Carro(Integer ano, String modelo) {
        this.ano = ano;
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
