package com.usf.model;

public class Produto {
    private int idProduto;
    private String nome;
    private double valor;

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString(){
        return this.getNome();
    }

    public void status(){
        System.out.println(this.idProduto);
        System.out.println(this.nome);
        System.out.println(this.valor);
    }
}
