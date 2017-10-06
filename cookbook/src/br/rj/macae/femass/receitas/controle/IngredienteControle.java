/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.receitas.controle;


import br.rj.macae.femass.receitas.dao.IngredienteDAO;
import br.rj.macae.femass.receitas.modelo.Ingrediente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JList;

/**
 *
 * @author YMoraes
 */
public class IngredienteControle {
    
    public void gravar(Ingrediente r, JList listaIngredientes) throws SQLException{
        if(r.getId()<=0){
            cadastrar(r, listaIngredientes);
        }else{
            alterar(r, listaIngredientes);
        }
    }
    private void cadastrar(Ingrediente r, JList listaIngredientes) throws SQLException{
        IngredienteDAO dao = new IngredienteDAO();
        dao.cadastrar(r);
        List ingredientes = dao.listarTodos();
        listaIngredientes.setListData(ingredientes.toArray());
    }
    private void alterar(Ingrediente r, JList listaIngredientes) throws SQLException{
        IngredienteDAO dao = new IngredienteDAO();
        dao.alterar(r);
        List ingredientes = dao.listarTodos();
        listaIngredientes.setListData(ingredientes.toArray());
    }
    public void excluir(Ingrediente r, JList listaIngredientes) throws SQLException{
        IngredienteDAO dao = new IngredienteDAO();
        dao.excluir(r);
        List ingredientes = dao.listarTodos();
        listaIngredientes.setListData(ingredientes.toArray());
    }
    public void atualizarListaIngredientes(JList listaIngredientes) throws SQLException{
        IngredienteDAO dao = new IngredienteDAO();        
        List ingredientes = dao.listarTodos();
        listaIngredientes.setListData(ingredientes.toArray());
    }
}
