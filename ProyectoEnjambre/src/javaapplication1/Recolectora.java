/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import javax.swing.JLabel;

/**
 *
 * @author xavid
 */
public class Recolectora extends Hormigas{
    
    //CONSTRUCTOR
    
    public Recolectora(int x, int y){
        posX = x;
        posY = y;
    }
    
    // METODOS
    
    @Override
    public void recursoCerca() {
        System.out.println("RC");
    }

    @Override
    public void enemigoCerca() {
        System.out.println("EC");
    }

    @Override
    public void otraLlevaRecurso() {
        System.out.println("OLR");
    }

    @Override
    public void otraDetectoEnemigo() {
        System.out.println("ODE");
    }

    @Override
    public void otraBuscarecurso() {
        System.out.println("OBR");
    }

   
    
}
