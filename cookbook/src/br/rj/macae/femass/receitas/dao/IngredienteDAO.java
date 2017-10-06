

package br.rj.macae.femass.receitas.dao;


import br.rj.macae.femass.receitas.dao.FabricaConexao;
import br.rj.macae.femass.receitas.dao.IDAO;
import br.rj.macae.femass.receitas.modelo.Ingrediente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YMoraes
 */
public class IngredienteDAO implements IDAO {
    
    @Override
    public void cadastrar(Object o) throws SQLException {
        Ingrediente ingrediente = (Ingrediente) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "insert into ingrediente (nome,descricao) "
                    + "values (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            stmt.setString(1, ingrediente.getNome());
            stmt.setString(2, ingrediente.getDescricao());
            
            
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new SQLException("Eroo ao tentar cadastrar a ingrediente. \n" + e.getMessage());
        }
    }

    @Override
    public void alterar(Object o) throws SQLException {
        Ingrediente ingrediente = (Ingrediente) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "update ingrediente  set "
                    + "nome =?,"
                    + "descricao = ?"                  
                    + "where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores         
            
            stmt.setString(1, ingrediente.getNome());
            stmt.setString(2, ingrediente.getDescricao());
            stmt.setInt(3, ingrediente.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar alterar a ingrediente. \n" + e.getMessage());
        }
    }

    @Override
    public void excluir(Object o) throws SQLException {
        Ingrediente ingrediente = (Ingrediente) o;
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();

            String sql = "delete from ingrediente "
                    + "where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // preenche os valores                     
            stmt.setInt(1, ingrediente.getId());
            //executa o sql (DML) para atualizar o banco. Pode ser um insert, update ou delete
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover a ingrediente. \n" + e.getMessage());
        }
    }

    @Override
    public List listarTodos() throws SQLException {
        List lista = new ArrayList();
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "select * from ingrediente ORDER BY id ASC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ingrediente r = new Ingrediente();
                r.setNome(rs.getString("nome"));
                r.setDescricao(rs.getString("descricao"));
                r.setId(rs.getInt("id"));
                lista.add(r);
            }

            rs.close();
            stmt.close();
            conn.close();
            return lista;
        } catch (SQLException e) {
            throw new SQLException("Erro ao recuperar a lista de ingredientes. \n" + e.getMessage());
        }
    }

    @Override
    public Object listarPorId(int id) throws SQLException {
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            String sql = "select * from ingrediente where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Ingrediente r = new Ingrediente();
                r.setNome(rs.getString("nome"));
                r.setDescricao(rs.getString("descricao"));
                r.setId(rs.getInt("id"));
                
            

            rs.close();
            stmt.close();
            conn.close();
            return r;
        } catch (SQLException e) {
            throw new SQLException("Eroo ao recuperar a ingrediente. \n" + e.getMessage());
        }
    }
    
}
