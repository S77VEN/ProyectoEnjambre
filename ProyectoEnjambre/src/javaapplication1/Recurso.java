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
public class Recurso extends Objeto {
    
    public Recurso (){
        this.salud = 10;
    }

    @Override
    public void desaparecer() {
        System.out.println("Desaparece xd");
    }

    @Override
    public void disminuirSalud() {
        
    }

    @Override
    public void recolocar() {
        
    }
    
}
