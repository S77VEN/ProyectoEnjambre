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
        this.posX = this.posX + masX;
        this.posY = this.posY + masY;
    }
    
    @Override
    public void prioridades(Objeto arriba, Objeto abajo, Objeto izquierda, Objeto derecha){
        
    }
    
    @Override
    public void verificarCasillasCercanas (JLabel[][] matriz, Objeto[] objeto, Hormigas[] listaH){
    }
    
    @Override
    public void verificarCasillasLejanas(){
        
    }
    
    @Override
    public void recursoCerca(Objeto recurso) {
        System.out.println("RC");
    }
    
    @Override
    public void enemigoCerca (Objeto enemigo){
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
