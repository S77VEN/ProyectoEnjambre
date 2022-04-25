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
    public void prioridades(Objeto arriba, Objeto abajo, Objeto izquierda, Objeto derecha){
        if (this.accion[0]){
            if (arriba.getClass().getSimpleName() == "Enemigo"){
                this.enemigoCerca(arriba);
                
            }
            else if (abajo.getClass().getSimpleName() == "Enemigo"){
                
            }
            else if (izquierda.getClass().getSimpleName() == "Enemigo"){
                
            }
            else if (derecha.getClass().getSimpleName() == "Enemigo"){
                
            }
            
        }
    }
    
    @Override
    public void verificarCasillasCercanas(JLabel[][] matriz, Objeto[] objeto, Hormigas[] listaH){
        
        Objeto derecha = null;
        Objeto izquierda = null;
        Objeto arriba = null;
        Objeto abajo = null;
        
        // COMPARANDO CASILLAS OBJETOS
        for (int i = 0; i < 9; i++) {
            //DERECHA
            if (objeto[i].posX == this.posX + 1 && objeto[i].posY == this.posY){
                derecha = objeto[i];
            }
            //ABAJO
            if (objeto[i].posX == this.posX && objeto[i].posY == this.posY + 1){
                abajo = objeto[i];
            }
            //IZQUIERDA
            if (objeto[i].posX == this.posX - 1 && objeto[i].posY == this.posY){
                izquierda = objeto[i];
            }
            //ARRIBA
            if (objeto[i].posX == this.posX && objeto[i].posY == this.posY - 1){
                arriba = objeto[i];
            }
        }
        
        // BUSCAR HORMIGAS
        if (derecha == null){
            for (int i = 0; i < 16; i++) {
                if (listaH[i].posX == posX + 1 && listaH[i].posY == posY){
                    
                }
            }
        }
        if (abajo == null){
            for (int i = 0; i < 16; i++) {
                if (listaH[i].posX == posX && listaH[i].posY == posY + 1){
                    
                }
            }
        }
        if (izquierda == null){
            for (int i = 0; i < 16; i++) {
                if (listaH[i].posX == posX - 1 && listaH[i].posY == posY){
                    
                }
            }
        }
        if (arriba == null){
            for (int i = 0; i < 16; i++) {
                if (listaH[i].posX == posX && listaH[i].posY == posY - 1){
                    
                }
            }
        }
        
        prioridades(arriba, abajo, izquierda, derecha);
    }
    
    @Override
    public void verificarCasillasLejanas(){
        
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
