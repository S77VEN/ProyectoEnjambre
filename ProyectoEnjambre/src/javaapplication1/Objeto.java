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
public abstract class Objeto extends SuperClase {
    int posX;
    int posY;
    int salud;
    JLabel imagen;
    
    public abstract void desaparecer();
    public abstract void disminuirSalud();
    public abstract void recolocar();
    
}
