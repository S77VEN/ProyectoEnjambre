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
    JLabel imagen;
    
    
    public abstract void recursoCerca ();
    public abstract void enemigoCerca ();
    public abstract void otraLlevaRecurso();
    public abstract void otraDetectoEnemigo();
    public abstract void otraBuscarecurso(); 
         
}