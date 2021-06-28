/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproyects.mensajesapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author a.ducuara.benitez
 */
public class MessageDAO {
public static void createMessageDB(Message message){
        ConnectionDB db_connection = new ConnectionDB();
        PreparedStatement preparedStatement = null;
        try(Connection connection = db_connection.get_connection()){
            try{
                String query = "INSERT INTO `mensajes` (`message`, `author_message`) VALUES (?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, message.getMessage());
                preparedStatement.setString(2, message.getAuthor_message());
                preparedStatement.executeUpdate();
                
                System.out.println("Mensaje creado");
            }catch(SQLException ex){
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void readMessageDB(){
        ConnectionDB db_connection = new ConnectionDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try(Connection connection = db_connection.get_connection()){
            
            String query = "SELECT * FROM `mensajes`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            //read data
            while(resultSet.next()){
                System.out.println("ID: "+resultSet.getInt("id_message"));
                System.out.println("Mensaje: "+resultSet.getString("message"));
                System.out.println("Autor: "+resultSet.getString("author_message"));
                System.out.println("Fecha del mensaje: "+resultSet.getString("date_message"));
                System.out.println("");
            }
            
        }catch(SQLException e){
            System.out.println("No se pudo recuperar los mensajes");
            System.out.println(e);
        }
    }
    public static void deleteMessageDB(int id_message){
        ConnectionDB db_connection = new ConnectionDB();
        
        try(Connection connection = db_connection.get_connection()){
            PreparedStatement preparedStatement = null;
            
            try{
                String query = "DELETE FROM mensajes WHERE id_message = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id_message);
                preparedStatement.executeUpdate();
                System.out.println("El mensaje a sido borrado");
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo borrar el mensaje");
            }
                
            
        }catch(SQLException e){
         
        }
    }
    public static void updateMessage(Message message){
        ConnectionDB db_connection = new ConnectionDB();
        try(Connection connection = db_connection.get_connection()){
            PreparedStatement preparedStatement = null;
            try{
                String query = "UPDATE mensajes SET message = ? WHERE id_message = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, message.getMessage());
                preparedStatement.setInt(2, message.getId());
                preparedStatement.executeUpdate();
                System.out.println("El mensaje se actualizó correctamente");
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo actualizar el mensaje");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
