/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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
    
  public int randomNum(){
        Random aleatorio = new Random();
        boolean x = aleatorio.nextBoolean();
        if(x){
            return 1;
        }
        else{
            return -1;
        }
    }
    @Override
    public void mover (JLabel campo, int masX, int masY){
        this.imagen.setIcon(null);
        campo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/recoleccion.png")));
        this.imagen = campo;
        this.posX = masX;
        this.posY = masY;
    }
    
    @Override
    public void prioridades(ArrayList<Objeto> cercanos, JLabel[][] matriz, Hormigas[] listaH, Objeto[] listaO){
        if (this.accion[0] || this.accion[1]){
            for (int i = 0; i < cercanos.size(); i++) {
                if (cercanos.get(i).getClass().getTypeName()== "javaapplication1.Enemigo"){
                    
                    int difX = cercanos.get(i).posX - this.posX;
                    int difY = cercanos.get(i).posY - this.posY;
                    
                    if (difX == 1  || difY == 1  ||  difX == -1  || difY == -1){
                        this.enemigoCerca(cercanos.get(i),matriz);
                        break;
                    }
                    else{
                        if (difX == 0){
                            ;
                        }
                        else if (difX < 0){
                            difX += 1;
                        }
                        else{
                            difX -= 1; 
                        }
                        if (difY == 0){
                            ;
                        }
                        else if (difY < 0){
                            difY += 1;
                        }
                        else{
                            difY -= 1;
                        }
                        
                        if ((hormigasVacias(listaH, this.posX - difX, this.posY - difY) == 1)   ||   (objetosVacios(listaO,this.posX - difX, this.posY - difY) == 1 ) ) {
                            if ((hormigasVacias(listaH, this.posX, this.posY + 1) == 1)   ||   (objetosVacios(listaO,this.posX, this.posY + 1) == 1 )){
                                break;
                            }
                            else{
                                this.mover(matriz[this.posX][this.posY + 1], this.posX , this.posY + 1);
                                break; 
                            }
                            
                        }
                        else{
                           this.mover(matriz[this.posX - difX][this.posY - difY], this.posX - difX, this.posY - difY);
                           break; 
                        }
                    }
                }
                
                
                
                else if(cercanos.get(i).getClass().getTypeName() == "javaapplication1.Recurso"){
                    System.out.println("Paso Rec");
                    int difX = cercanos.get(i).posX - this.posX;
                    int difY = cercanos.get(i).posY - this.posY;
                    
                    if (difX == 1  || difY == 1  ||  difX == -1  || difY == -1){
                        this.recursoCerca(cercanos.get(i),matriz);
                        break;
                    }
                    else{
                        if (difX == 0){
                            ;
                        }
                        else if (difX < 0){
                            difX += 1;
                        }
                        else{
                            difX -= 1; 
                        }
                        if (difY == 0){
                            ;
                        }
                        else if (difY < 0){
                            difY += 1;
                        }
                        else{
                            difY -= 1;
                        }
                        
                        if ((hormigasVacias(listaH, this.posX - difX, this.posY - difY) == 1)   || (objetosVacios(listaO,this.posX - difX, this.posY - difY) == 1 ) ) {
                            break;
                        }
                        else{
                           this.mover(matriz[this.posX + difX][this.posY + difY], this.posX + difX, this.posY + difY);
                           break; 
                        }
                }
                }
                
                else if(cercanos.get(i).getClass().getTypeName() == "javaapplication1.Obstaculo"){
                    if ((cercanos.get(i).posX == this.posX + 1) && (cercanos.get(i).posY == this.posY)){
                        if ((cercanos.get(i).posX == this.posX) && (cercanos.get(i).posY == this.posY + 1)){
                            break;
                        }
                        else{
                            if (hormigasVacias(listaH, this.posX, this.posY + 1) == 1){
                                break;
                            }
                            else{
                                this.mover(matriz[this.posX][this.posY + 1], this.posX + 1, this.posY);
                            }
                        }
                    }
                    else
                        if (hormigasVacias(listaH, this.posX + 1, this.posY) == 1){
                            break;
                        }
                        else{
                            this.mover(matriz[this.posX + 1][this.posY], this.posX + 1, this.posY);
                        }
                        
                    
                }
                
                else{
                    verificarHormigas(matriz, listaH);
                    
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
            verificarHormigas(matriz, listaH);
        }
        prioridades(cercanos, matriz, listaH, objeto);
    }
    
    @Override
    public int objetosVacios(Objeto[] listaO, int newX, int newY){
        for (int i = 0; i < 9; i++){
            if ((listaO[i].posX == newX) && (listaO[i].posY == newY)){
                return 1;
            }
        }
        return 0;
    }
    
    @Override
    public int hormigasVacias (Hormigas[] listaH, int newX, int newY){
        for (int i = 0; i < 16; i++){
            if(listaH[i] == this){
                ;
            }
            else if ((listaH[i].posX == newX) && (listaH[i].posY == newY)){
                return 1;
            }
        }
        return 0;
    }
    
    
    @Override
    public void verificarHormigas(JLabel[][] matriz, Hormigas[] listaH){
        ArrayList<Hormigas> hcercana = new ArrayList<>();
        
        int minX = this.posX - 2;
        int minY = this.posY - 2;
        
        int maxX = this.posX + 2;
        int maxY = this.posY + 2;
        
        for (int i = 0; i < 16; i++){
            if ((listaH[i].posX >= minX && listaH[i].posX <= maxX ) && (listaH[i].posY >=minY && listaH[i].posY <= maxY )){
                if (listaH[i] == this)
                    ;
                else
                   hcercana.add(listaH[i]);
            }
        }
        if (hcercana.isEmpty()){
            this.mover(matriz[this.posX + 1][this.posY], this.posX + 1, this.posY);
        }  
        else{
            interactuarHormigas(matriz, hcercana,listaH);
        }
        
    }
    
    @Override
    public void interactuarHormigas (JLabel[][] matriz, ArrayList<Hormigas> hormigas,Hormigas[] listaH){
        
        for (int i = 0; i < hormigas.size(); i++) {
            if (this.accion[0] || this.accion[1]){                    //Si la hormiga anda buscando.
                this.cambiarAccion(0);
                int difX = hormigas.get(i).posX - this.posX;
                int difY = hormigas.get(i).posY - this.posY;
                
                if (hormigas.get(i).accion[1]){         //Si me topo anda atacando se equipa pa la guerra y la sigue.
                    if (hormigasVacias(listaH,this.posX + 1, this.posY) == 1){
                        break;
                    }
                }
                else if (hormigas.get(i).accion[0]){    //Si me topo anda buscando recurso vamos pa otro lado ese mae no ha encontrado.
                    if (difX == 1  || difY == 1  ||  difX == -1  || difY == -1){
                        if (hormigasVacias(listaH,this.posX+1,this.posY) == 1){
                            if(hormigasVacias(listaH,this.posX,this.posY + 1) == 1){
                                break;
                            }
                            else{
                                this.mover(matriz[this.posX][this.posY + 1],this.posX,this.posY + 1);
                                break;
                            }
                        }    
                        else{
                            this.mover(matriz[this.posX+1][this.posY],this.posX+1,this.posY);
                            break;
                        }
                    }
                }  
                
                else if (hormigas.get(i).accion[2]){    //Si me topo ya encontró recurso vamos por la carnita asada.
                    int x = randomNum();
                    if (difX == 1  || difY == 1  ||  difX == -1  || difY == -1){
                        hormigasVacias(listaH,this.posX+1,this.posY);
                        if (hormigasVacias(listaH,this.posX+1,this.posY) == 0){
                            this.mover(matriz[this.posX+1][this.posY],this.posX+1,this.posY);
                            break;
                        }    
                        else{
                            break;
                        }
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
                        this.mover(matriz[this.posX+difX][this.posY+difY],this.posX+difX,this.posY+difY);
                    } 
                }
            }
            else if(this.accion[2]){                                           //Si la hormiga anda llevando recurso.
                
                int difX = hormigas.get(i).posX - this.posX;
                int difY = hormigas.get(i).posY - this.posY;
                
                if (hormigas.get(i).accion[1] || hormigas.get(i).accion[0]){        //Si me topo anda atacando o buscando ignoro
                    if (difX == 1  || difY == 1  ||  difX == -1  || difY == -1){
                        hormigasVacias(listaH,this.posX-1,this.posY);
                        if (hormigasVacias(listaH,this.posX-1,this.posY) == 0){
                            this.mover(matriz[this.posX-1][this.posY],this.posX-1,this.posY);
                            break;
                        }    
                        else{
                            break;
                        }
                    }
                    
                    else{
                        if (difX < 0){
                        difX -= 1;
                        }
                        else{
                        difX += 1;
                        }
                        if (difY < 0){
                        difY -= 1;
                        }
                        else{
                        difY += 1;
                        }
                        this.mover(matriz[this.posX+difX][this.posY+difY],this.posX+difX,this.posY+difY);
                    } 
                }
                else if (hormigas.get(i).accion[2]){                                //Si me topo lleva la sigo a casita
                    if (difX == 1  || difY == 1  ||  difX == -1  || difY == -1){
                        hormigasVacias(listaH,this.posX-1,this.posY);
                        if (hormigasVacias(listaH,this.posX-1,this.posY) == 0){
                            this.mover(matriz[this.posX-1][this.posY],this.posX-1,this.posY);
                            break;
                        }    
                        else{
                            break;
                        }
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
                        this.mover(matriz[this.posX+difX][this.posY+difY],this.posX+difX,this.posY+difY);
                    } 
                }
                
            }
        }
    }
    
    
    
    @Override
    public void recursoCerca(Objeto recurso,JLabel[][] matriz) {
        recurso.disminuirSalud(matriz);
        //this.cambiarAccion(2);
    }
    

    @Override
    public void enemigoCerca(Objeto enemigo,JLabel[][] matriz) {
        this.cambiarAccion(1);
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
