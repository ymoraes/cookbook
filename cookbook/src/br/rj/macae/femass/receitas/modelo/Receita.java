/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.receitas.modelo;

/**
 *
 * @author YMoraes
 */
public class Receita {
    private int id;
    private String nome;
    private String ingredientes;
    private String preparo;
    private String modoServir;
    
    public Receita(String nome){
        this.setId(0);
        this.setNome(nome);
    }

    public String toString(){
        return "Receita "+this.getNome();
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the ingredientes
     */
    public String getIngredientes() {
        return ingredientes;
    }

    /**
     * @param ingredientes the ingredientes to set
     */
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * @return the preparo
     */
    public String getPreparo() {
        return preparo;
    }

    /**
     * @param preparo the preparo to set
     */
    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }

    public String getModoServir() {
        return modoServir;
    }

    public void setModoServir(String modoServir) {
        this.modoServir = modoServir;
    }
    
    

}
