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
public class Recolectora extends Hormigas{
    
    //CONSTRUCTOR
    
    public Recolectora(){
        posX = 0;
        posY = 0;
    }
    
    // METODOS
    @Override
    public void mover(JLabel campo, int masX, int masY){
        this.imagen.setIcon(null);
        campo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/recoleccion.png")));
        this.imagen = campo;
        this.posX = masX;
        this.posY = masY;
    }
    
    @Override
    public void prioridades(ArrayList<Objeto> cercanos, JLabel[][] matriz,  Hormigas[] listaH){
        if (this.accion[0]){
            for (int i = 0; i < cercanos.size(); i++) {
                if (cercanos.get(i).getClass().getTypeName()== "javaapplication1.Enemigo"){
                    System.out.println("paso ene");
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
                        this.mover(matriz[this.posX + difX][this.posY + difY], this.posX + difX, this.posY + difY);
                        break;
                    }
                }
                
                
                
                else if(cercanos.get(i).getClass().getTypeName() == "javaapplication1.Recurso"){
                    System.out.println("Paso Rec");
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
                
                
                else if(cercanos.get(i).getClass().getTypeName() == "javaapplication1.Obstaculo"){
                    System.out.println("paso obst");
                    int difX = cercanos.get(i).posX - this.posX;
                    int difY = cercanos.get(i).posY - this.posY;
                    
                    this.mover(matriz[this.posX][this.posY + 1], this.posX, this.posY + 1);
                    break;
                    /*
                    if (difX == 1  || difY == 1  ||  difX == -1  || difY == -1){
                        if (difX < 0){
                            difX += 2;
                        }
                        else{
                            difX -= 2; 
                        }
                        if (difY < 0){
                            difY += 2;
                        }
                        else{
                            difY -= 2;
                        }
                        
                    }
                    */
                }
                
                else{
                    
                }
                    
                
                
                
            }
            
            
            
        }
        
    }
    
    @Override
    public void verificarCasillasCercanas (JLabel[][] matriz, Objeto[] objeto, Hormigas[] listaH){
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
            verificarHormigas(matriz, listaH);
        }
        
        prioridades(cercanos, matriz, listaH);
    }
    
    @Override
    public int hormigasVacias(Hormigas[] listaH, int newX, int newY){
        return 1;
    }
    
    @Override
    public void verificarHormigas (JLabel[][] matriz, Hormigas[] listaH){
        ArrayList<Hormigas> hcercana = new ArrayList<>();
        
        int minX = this.posX - 2;
        int minY = this.posY - 2;
        
        int maxX = this.posX + 2;
        int maxY = this.posY + 2;
        
        for (int i = 0; i < 16; i++){
            if ((listaH[i].posX >= minX && listaH[i].posX <= maxX ) && (listaH[i].posY >=minY && listaH[i].posY <= maxY )){
                if (listaH[i] == this)
                    this.posX = this.posX;
                else
                   hcercana.add(listaH[i]);
            }
        }
        
    }
    
    
    
    
    
    
    
    
    public void interactuarHormigas (JLabel[][] matriz, ArrayList<Hormigas> hormigas, Hormigas[] listaH){
        for (int i = 0; i < hormigas.size(); i++) {
            System.out.println("Hola");
        }
    }
    
    @Override
    public void recursoCerca(Objeto recurso) {
        recurso.disminuirSalud();
        this.cambiarAccion(2);
    }
    
    @Override
    public void enemigoCerca (Objeto enemigo){
        this.cambiarAccion(1);
        enemigo.disminuirSalud();
    }
    
    @Override
    public void obstaculoCerca(Objeto obstaculo){
        
    }
    
    
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
