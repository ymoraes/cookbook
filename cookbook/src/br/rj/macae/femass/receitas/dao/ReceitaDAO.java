/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.receitas.dao;

import br.rj.macae.femass.receitas.modelo.Receita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anamm
 */
public class ReceitaDAO implements IDAO{

    @Override
    public void cadastrar(Object o) throws SQLException {
        Receita receita = (Receita) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "insert into receita (nome,ingredientes,preparo) "
                    + "values (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, receita.getNome());
            stmt.setString(2, receita.getIngredientes());
            stmt.setString(3, receita.getPreparo());
            
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new SQLException("Eroo ao tentar cadastrar a receita. \n" + e.getMessage());
        }
    }

    @Override
    public void alterar(Object o) throws SQLException {
        Receita receita = (Receita) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "update receita  set "
                    + "nome = ?, "
                    + "ingredientes = ?,"
                    + "preparo = ?"                    
                    + "where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, receita.getNome());
            stmt.setString(2, receita.getIngredientes());
            stmt.setString(3, receita.getPreparo());
            stmt.setInt(4, receita.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new SQLException("Eroo ao tentar alterar a receita. \n" + e.getMessage());
        }
    }

    @Override
    public void excluir(Object o) throws SQLException {
        Receita receita = (Receita) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "delete from receita "
                    + "where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setInt(1, receita.getId());
            //executa o sql (DML) para atualizar o banco. Pode ser um insert, update ou delete
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new SQLException("Eroo ao tentar remover a receita. \n" + e.getMessage());
        }
    }

    @Override
    public List listarTodos() throws SQLException {
        List lista = new ArrayList();
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "select * from receita";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Receita r = new Receita(rs.getString("nome"));
                r.setIngredientes(rs.getString("ingredientes"));
                r.setPreparo(rs.getString("preparo"));
                r.setId(rs.getInt("id"));
                lista.add(r);
            }

            rs.close();
            stmt.close();
            conn.close();
            return lista;
        } catch (SQLException e) {
            throw new SQLException("Eroo ao recuperar a lista de receitas. \n" + e.getMessage());
        }
    }

    @Override
    public Object listarPorId(int id) throws SQLException {
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "select * from receita where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Receita r = new Receita(rs.getString("nome"));
            r.setIngredientes(rs.getString("ingredientes"));
            r.setPreparo(rs.getString("preparo"));
            r.setId(rs.getInt("id"));
            

            rs.close();
            stmt.close();
            conn.close();
            return r;
        } catch (SQLException e) {
            throw new SQLException("Eroo ao recuperar a receita. \n" + e.getMessage());
        }
    }
    
}
