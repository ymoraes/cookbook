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
public class Ingrediente {
    private int id;
    private String nome;
    private String descricao;
    private List<Receita_Ingrediente> receitas;

    public Ingrediente() {
    }

    
    public List<Receita_Ingrediente> getReceitas() {
        return Collections.unmodifiableList(receitas);
       
    }

    public void setReceitas(Receita_Ingrediente receita) {
        this.receitas.add(receita);
    }
    
    public void removeReceita(Receita_Ingrediente receita){
        if (this.receitas.contains(receita))
            this.receitas.remove(receita);
    }
    
    public Ingrediente(String nome) {
        this.setId(0);
        this.setNome(nome);
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingrediente other = (Ingrediente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
