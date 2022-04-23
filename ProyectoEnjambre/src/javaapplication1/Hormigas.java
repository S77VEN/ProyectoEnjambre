/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import javax.swing.JLabel;

/**
 *
 * @author stive
 */
public abstract class Hormigas {
    int posX;
    int posY;
    boolean accion[] = {false, false, false}; 
    JLabel imagen;
    
    
    public abstract void recursoCerca (JLabel[][] matriz);
    public abstract void enemigoCerca ();
    public abstract void otraLlevaRecurso();
    public abstract void otraDetectoEnemigo();
    public abstract void otraBuscarecurso(); 
         
}