/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproyects.mensajesapp;

import java.sql.Connection;
import java.util.Scanner;


/**
 *
 * @author a.ducuara.benitez
 */
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int option = 0;
        
        do{
            System.out.println("-------------------------");
            System.out.println("Aplicación de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Editar un mensaje");
            System.out.println("4. Eliminar mensaje");
            System.out.println("5. Salir");
            
            //we read the option of the user
            option = sc.nextInt();
            
            switch(option){
                case 1:
                    MessageService.createMessage();
                    break;
                case 2:
                    MessageService.listMessage();
                    break;
                case 3:
                    MessageService.updateMessage();
                    break;
                case 4:
                    MessageService.deleteMessage();
                    break;
                default:
                    break;
            }
            
            
        }while(option != 5);
        
    }
}
