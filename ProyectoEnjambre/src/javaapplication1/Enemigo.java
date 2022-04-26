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
    
    public Enemigo (){
        this.salud = 10;
    }

    @Override
    public void desaparecer() {
        System.out.println("Desaparece xd");
    }
    
    @Override
    public void disminuirSalud(){
        if (this.salud > 0){
            this.salud = this.salud - 1;
            
        }
        else{
            System.out.println("Se murio xd");
        }
    }
    
    @Override
    public void recolocar(){
        System.out.println("recolocado xd");
    }
    
    
}
