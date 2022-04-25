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
    
    public Obstaculo (){
    }

    @Override
    public void desaparecer() {
        System.out.println("no desaparece");
    }

    @Override
    public void disminuirSalud() {
        System.out.println("Nada");
    }

    @Override
    public void recolocar() {
        System.out.println("Nada");
    }
    
    
}
