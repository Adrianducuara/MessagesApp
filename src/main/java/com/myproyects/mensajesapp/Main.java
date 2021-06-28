/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproyects.mensajesapp;

import java.sql.Connection;


/**
 *
 * @author a.ducuara.benitez
 */
public class Main {
    public static void main(String[] args) {
        ConnectionDB connection = new ConnectionDB();
        try(Connection cnx = connection.get_connection()){
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
