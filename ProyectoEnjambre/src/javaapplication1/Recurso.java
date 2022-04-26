/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.util.Random;
import javax.swing.JLabel;


/**
 *
 * @author xavid
 */
public class Recurso extends Objeto {
    
    public Recurso (){
        this.salud = 10;
    }
    public int rangoRandom(int rango){
        Random aleatorio = new Random();
        int x = aleatorio.nextInt();
        return x;
    }
    @Override
    public void desaparecer() {
        this.imagen.setIcon(null);
        System.out.println("Desaparece xd");
    }
    @Override
    public void disminuirSalud() {
        if (this.salud > 0){
            this.salud = this.salud - 1; 
        }
        else{
            desaparecer();
        }
    }
    @Override
    public void recolocar() {
        this.posX = rangoRandom(25);
        this.posY = rangoRandom(12);
    }
    
}
