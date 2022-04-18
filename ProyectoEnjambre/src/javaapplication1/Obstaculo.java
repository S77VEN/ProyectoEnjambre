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
public class Obstaculo extends Objeto {
    
    public Obstaculo (int x, int y){
        this.posX = x;
        this.posY = y;
    }

    @Override
    public void desaparecer() {
        System.out.println("no desaparece");
    }
    
    
}
