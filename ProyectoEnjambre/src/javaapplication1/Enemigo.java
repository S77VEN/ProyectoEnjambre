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
public class Enemigo extends Objeto{
    
    public Enemigo (){
        this.salud = 10;
    }
    public int rangoRandom(int rango){
        Random aleatorio = new Random();
        int x = aleatorio.nextInt(rango);
        return x;
    }
    @Override
    public void desaparecer(JLabel[][] matriz) {
        this.imagen.setIcon(null);
        this.recolocar(matriz);
        System.out.println(this.imagen);
    }
    @Override
    public void disminuirSalud(JLabel[][] matriz){
        if (this.salud > 0){
            this.salud = this.salud - 1; 
        }
        else{
            desaparecer(matriz);
        }
    }
    @Override
    public void recolocar(JLabel[][] matriz){
        this.posX = rangoRandom(24);
        System.out.println(this.posX);
        this.posY = rangoRandom(11);
        matriz[this.posX][this.posY].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enemigo.png")));
        this.imagen = matriz[this.posX][this.posY];
        this.salud = 10;
        System.out.println("recolocado xd");
    }  
}
