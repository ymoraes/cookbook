/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.receitas.modelo;

import java.util.Objects;

/**
 *
 * @author YMoraes
 */
public class Receita_Ingrediente {
    private Receita receita;
    private Ingrediente ingrediente;
    private int quantidade;
    private String unidade;

    public Receita_Ingrediente() {
    }
        
    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Receita_Ingrediente other = (Receita_Ingrediente) obj;
        if (!Objects.equals(this.receita, other.receita)) {
            return false;
        }
        if (!Objects.equals(this.ingrediente, other.ingrediente)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
