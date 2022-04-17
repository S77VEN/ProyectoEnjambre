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
public class Hormigas {
    int posX;
    int posY;
    JLabel imagen;
public Hormigas(int x, int y){
    posX = x;
    posY = y;
    imagen = new JLabel();
    imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ataque.png")));
}
         
}
