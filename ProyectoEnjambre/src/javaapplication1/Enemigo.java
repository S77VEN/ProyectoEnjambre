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
public class Enemigo extends Objeto{
    
    public Enemigo (int x, int y){
        this.posX = x;
        this.posY = y;
        this.salud = 10;
        imagen = new JLabel();
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enemigo.png")));
    }

    @Override
    public void desaparecer() {
        System.out.println("Desaparece xd");
    }
    
    
}
