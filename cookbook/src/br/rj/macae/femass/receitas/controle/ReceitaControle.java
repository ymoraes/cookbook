/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.receitas.controle;

import br.rj.macae.femass.receitas.dao.ReceitaDAO;
import br.rj.macae.femass.receitas.modelo.Receita;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JList;

/**
 *
 * @author anamm
 */
public class ReceitaControle {
    
    public void gravar(Receita r, JList listaReceitas) throws SQLException{
        if(r.getId()<=0){
            cadastrar(r, listaReceitas);
        }else{
            alterar(r, listaReceitas);
        }
    }
    private void cadastrar(Receita r, JList listaReceitas) throws SQLException{
        ReceitaDAO dao = new ReceitaDAO();
        dao.cadastrar(r);
        List receitas = dao.listarTodos();
        listaReceitas.setListData(receitas.toArray());
    }
    private void alterar(Receita r, JList listaReceitas) throws SQLException{
        ReceitaDAO dao = new ReceitaDAO();
        dao.alterar(r);
        List receitas = dao.listarTodos();
        listaReceitas.setListData(receitas.toArray());
    }
    public void atualizarListaReceitas(JList listaReceitas) throws SQLException{
        ReceitaDAO dao = new ReceitaDAO();        
        List receitas = dao.listarTodos();
        listaReceitas.setListData(receitas.toArray());
    }
}
