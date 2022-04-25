/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author xavid
 */
public class Defensora extends Hormigas {
    
    //CONSTRUCTOR
    
    public Defensora (){
        posX = 0;
        posY = 0;
    }
    
    @Override
    public void mover (JLabel campo, int masX, int masY){
        this.imagen.setIcon(null);
        campo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ataque.png")));
        this.imagen = campo;
        this.posX = this.posX + masX;
        this.posY = this.posY + masY;
    }
    
    @Override
    public void prioridades(ArrayList<Objeto> cercanos, JLabel[][] matriz, Hormigas[] listaH){
        if (this.accion[0]){
            for (int i = 0; i < cercanos.size(); i++) {
                if (cercanos.get(i).getClass().getSimpleName() == "Enemigos"){
                    int difX = cercanos.get(i).posX - this.posX;
                    int difY = cercanos.get(i).posY - this.posY;
                    
                    if (difX == 1  || difY == 1  ||  difX == -1  || difY == -1){
                        this.enemigoCerca(cercanos.get(i));
                        break;
                    }
                    else{
                        if (difX < 0){
                            difX += 1;
                        }
                        else{
                            difX -= 1; 
                        }
                        if (difY < 0){
                            difY += 1;
                        }
                        else{
                            difY -= 1;
                        }
                        this.mover(matriz[difX][difY], difX, difY);
                        break;
                    }
                }
                
                
                
                else if(cercanos.get(i).getClass().getSimpleName() == "Recurso"){
                    int difX = cercanos.get(i).posX - this.posX;
                    int difY = cercanos.get(i).posY - this.posY;
                    
                    if (difX == 1  || difY == 1  ||  difX == -1  || difY == -1){
                        this.recursoCerca(cercanos.get(i));
                        break;
                    }
                    else{
                        if (difX < 0){
                            difX += 1;
                        }
                        else{
                            difX -= 1; 
                        }
                        if (difY < 0){
                            difY += 1;
                        }
                        else{
                            difY -= 1;
                        }
                        this.mover(matriz[difX][difY], difX, difY);
                        break;
                    }
                }
                
                else if(cercanos.get(i).getClass().getSimpleName() == "Obstaculo"){
                    int difX = cercanos.get(i).posX - this.posX;
                    int difY = cercanos.get(i).posY - this.posY;
                    
                    if (difX == 1  || difY == 1  ||  difX == -1  || difY == -1){
                        if (difX < 0){
                            difX += 2;
                        }
                        else{
                            difX -= 2; 
                        }
                        if (difY < 0){
                            difY += 1;
                        }
                        else{
                            difY -= 1;
                        }
                    }
                }
                
                else{
                    verificarHormigas(listaH);
                    
                }
                    
                
                
                
            }
            
            
            
        }
    }
    
    
    
    
    @Override
    public void verificarCasillasCercanas(JLabel[][] matriz, Objeto[] objeto, Hormigas[] listaH){
        
        ArrayList<Objeto> cercanos = new ArrayList<>();
        int minX = this.posX - 2;
        int minY = this.posY - 2;
        
        int maxX = this.posX + 2;
        int maxY = this.posY + 2;
        
        // COMPARANDO CASILLAS OBJETOS
        for (int i = 0; i < 9; i++) {
            if((objeto[i].posX >= minX && objeto[i].posX <= maxX ) && (objeto[i].posY >=minY && objeto[i].posY <= maxY  )){
                cercanos.add(objeto[i]);
            }
        }
        
        if (cercanos.isEmpty()){
            verificarHormigas(listaH);
        }
        
        prioridades(cercanos, matriz, listaH);
    }
    
    @Override
    public void verificarHormigas(Hormigas[] listaH){
        
        
    }
    
    @Override
    public void recursoCerca(Objeto recurso) {
        recurso.disminuirSalud();
        this.cambiarAccion(2);
    }

    @Override
    public void enemigoCerca(Objeto enemigo) {
        this.cambiarAccion(1);
        enemigo.disminuirSalud();
    }
    
    @Override
    public void obstaculoCerca(Objeto obstaculo){
        
    }
    
    @Override
    public void cambiarAccion(int opcion){
        for (int i = 0; i < 3; i++) {
            this.accion[i] = false;
        }
        this.accion[opcion] = true;
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
