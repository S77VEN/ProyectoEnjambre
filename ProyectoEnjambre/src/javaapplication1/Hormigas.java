/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import javax.swing.JLabel;

/**
 *
 * @author stive
 */
public abstract class Hormigas{
    int posX;
    int posY;
    boolean accion[] = {false, false, false}; 
    JLabel imagen;
    
    public abstract void mover(JLabel campo, int masX, int masY);
    public abstract void prioridades(Objeto arriba, Objeto abajo, Objeto izquierda, Objeto derecha);
    public abstract void verificarCasillasCercanas(JLabel[][] matriz, Objeto[] objeto, Hormigas[] listaH);
    public abstract void verificarCasillasLejanas();
    public abstract void recursoCerca (Objeto recurso);
    public abstract void enemigoCerca (Objeto enemigo);
    public abstract void obstaculoCerca(Objeto obstaculo);
    public abstract void cambiarAccion(int opcion);
    public abstract void otraLlevaRecurso();
    public abstract void otraDetectoEnemigo();
    public abstract void otraBuscarecurso();  
}