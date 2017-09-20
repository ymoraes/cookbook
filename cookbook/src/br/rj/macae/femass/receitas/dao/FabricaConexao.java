/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.receitas.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    public static Connection getConexao(){
        Connection conn=null;
        try { 
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receitas","postgres","12345678"); 
                        
       } catch(SQLException e) {
            e.printStackTrace();
       }
        return conn;
    }
}
