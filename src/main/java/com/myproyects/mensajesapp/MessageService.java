/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproyects.mensajesapp;

import java.util.Scanner;

/**
 *
 * @author a.ducuara.benitez
 */
public class MessageService {
    public static void createMessage(){
        //We read the data in screen
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String message = sc.nextLine();
        
        System.out.println("Tu nombre (nos ayudará a definir el autor del mensaje)");
        String author_message = sc.nextLine();
        
        
        Message register = new Message();
        register.setMessage(message);
        register.setAuthor_message(author_message);
        
        MessageDAO.createMessageDB(register);
        
    }
    public static void listMessage(){
       MessageDAO.readMessageDB();
    }
    public static void deleteMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a eliminar");
        int idMessage = sc.nextInt();
        
        MessageDAO.deleteMessageDB(idMessage);
    }
    public static void updateMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String newMessage = sc.nextLine();
        
        System.out.println("Indica el ID del mensaje a editar");
        int idMessage = sc.nextInt();
        
        Message updateMessage = new Message();
        updateMessage.setMessage(newMessage);
        updateMessage.setId(idMessage);
        
        MessageDAO.updateMessage(updateMessage);
    }
}
