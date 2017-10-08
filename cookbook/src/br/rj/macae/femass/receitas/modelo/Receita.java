/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.receitas.modelo;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author YMoraes
 */
public class Receita {
    private int id;
    private String nome;
    private String preparo;
    private String modoServir;
    private Categoria categoria;
    private List<Receita_Ingrediente> ingredientes;
    
    public Receita(String nome){
        this.setId(0);
        this.setNome(nome);
    }

    public Receita() {
    }
    

    public List<Receita_Ingrediente> getIngredientes() {
        return Collections.unmodifiableList(ingredientes);
       
    }

    public void setIngredientes(Receita_Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
    }
    
    public void removeIngrediente(Receita_Ingrediente ingrediente){
        if (this.ingredientes.contains(ingrediente))
            this.ingredientes.remove(ingrediente);
    }
    
    public String toString(){
        return "Cod:"+this.getId()+" | "+this.getNome();
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria c) {
        this.categoria = c;
        c.setReceita(this);
    }
    
    
    

}
