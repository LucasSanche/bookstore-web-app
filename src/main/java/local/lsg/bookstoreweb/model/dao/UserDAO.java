/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.lsg.bookstoreweb.model.dao;

import local.lsg.bookstoreweb.model.bean.User;
import connection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author devsys-b
 */
public class UserDAO {
     private static final String SQL_INSERT = "INSERT INTO user(email, "
            +"password,fullName)"
            +"VALUES(?, ?, ?)";
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM user";
    private static final String SQL_SELECT_ID = "SELECT * FROM user WHERE id = ? ";
    
    
    
    private static final String SQL_UPDATE = "UPDATE user SET email = ?,"
            +"password = ?,fullName = ? "
            +"WHERE id = ?";
    
    private static final String SQL_DELETE = "DELETE FROM user WHERE id = ?";
            
    
    
    /**
     * Insere um usuario na base de dados User
     * @param u
     */
    
    public void create(User u){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getFullName());
            
            
            
            //Executa a query
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.INFO,null,
                    "Inclusão: "+auxRetorno);
            
           
            
        }catch(SQLException sQLException){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null,
                    sQLException);
        } finally{
            //Encerra a conexão com o banco e o statement.
            MySQLConnection.closeConnection(conn, stmt);
        }
        
        
        
    }
    
    /**
     * Retorna todos os registros da tabela produto
     * @return
     */
    
    public List<User> getResults() {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs  = null;
        User u = null;
        List<User> listaUsers = null;
        
        try{
            //Prepara a string de SELECT e executa a query.
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            
            //Carrega os dados do ResultSet rs, converte em produto e
            //adiciona na lista de retorno
            listaUsers = new ArrayList<>();
            
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFullName(rs.getString("fullName"));
                
                listaUsers.add(u);
            }
        }catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return listaUsers;
    }
    
    /**
     * Retorna um produto da tabela produto
     * @param id IDentificação do User
     * @return
     */
    
    public User getResultById(int id) {
        
    Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs  = null;
        User u = null;
        
        
        try{
            //Prepara a string de SELECT e executa a query.
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            
          
            
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFullName(rs.getString("fullName"));
                
                
            }
        }catch (SQLException sQLException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null,sQLException);
        }finally{
            //Encerra a conexão com o banco e o statement.
            MySQLConnection.closeConnection(conn,stmt,rs);
        }
        return u;
    }
    
    
    /**
     * Atualiza um registro na tabela produto.
     * @param p User a ser atualizado.
     */
    
    public void update(User u){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getFullName());
            stmt.setInt(4
                    , u.getId());
            
            //Executa a query
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.INFO,null,
                    "Update: "+auxRetorno);
            
           
            
        }catch(SQLException sQLException){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null,
                    sQLException);
        } finally{
            //Encerra a conexão com o banco e o statement.
            MySQLConnection.closeConnection(conn, stmt);
        }
    }
    
    public void delete(int id) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            
            //Executa a query
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.INFO,null,
                    "Delete: "+auxRetorno);
            
        }catch(SQLException sQLException){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null,
                    sQLException);
        } finally{
            //Encerra a conexão com o banco e o statement.
            MySQLConnection.closeConnection(conn, stmt);
        }
    }
    
    public User checkLogin(String email, String password){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs  = null;
        User u = null;
        
        
        try{
            //Prepara a string de SELECT e executa a query.
            stmt = conn.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
            stmt.setString(1,email);
            stmt.setString(2,password);
            rs = stmt.executeQuery();
            
//          if(rs.next()==false){
//              Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, "Usuario não encontrado");;;;;;
          
              while (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFullName(rs.getString("fullName")); 
                
            }
          
            
            
        }catch (SQLException sQLException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null,sQLException);
        }finally{
            //Encerra a conexão com o banco e o statement.
            MySQLConnection.closeConnection(conn,stmt,rs);
        }
        return u;
    }
}
