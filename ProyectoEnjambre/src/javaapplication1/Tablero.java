/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication1;

import java.awt.Point;
import javax.swing.JLabel;
import java.awt.event.*;

/**
 *
 * @author stive
 */
public class Tablero extends javax.swing.JFrame {
    int cantidadH = 16;
    int cantidadO = 9;
    Hormigas listaH[] = new Hormigas [cantidadH];
    Objeto listaO[] = new Objeto [cantidadO];
    JLabel matriz[][] = new JLabel[25][12]; 
    
    
    
    /**
     * Creates new form Tablero
     */
    
    public Tablero() {
        initComponents();
        inicializarArregloLabels();
        inicializarHormigas();
        inicializarObjetos();
        colocarBase();
        colocarHormigas();
        colocarObjetos();
    }
    public void inicializarArregloLabels(){
        for (int i = 0; i < 25; i++){
            for (int j = 0; j<12; j++){
                matriz[i][j] = new JLabel();
                matriz[i][j].setText(String.valueOf(i)+","+String.valueOf(j));
                matriz[i][j].setOpaque(true);
                matriz[i][j].setBackground(new java.awt.Color(255, 255, 0));
                jPanel1.add(matriz[i][j], new org.netbeans.lib.awtextra.AbsoluteConstraints(i*65, j*65, 60, 60));
            } 
        }
        pack();
     }
    
    public void inicializarHormigas (){
        for (int i = 0; i < cantidadH; i++) {
            if (i%2 == 0)
                listaH[i] = new Defensora();
            else
                listaH[i] = new Recolectora();
        }
    }
    
    public void inicializarObjetos (){
        for (int i = 0; i < cantidadO; i++) {
            if (i < 3)
                listaO[i] = new Enemigo();
            else if(i < 6)
                listaO[i] = new Recurso();
            else
                listaO[i] = new Obstaculo();
        }
    }
    
    
    public void colocarBase(){
        matriz[0][0].setOpaque(false);
        matriz[0][0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/base.png")));
    }
    
    public void colocarHormigas(){
        int contador = 0;
        for (int i = 0; i < 25; i++){
            for (int j = 0; j<12; j++){
                if (i < 5 & i > 0 & j < 5 & j > 0){
                    if ((i+j)% 2 == 0){
                        matriz[i][j].setOpaque(false);
                        matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/recoleccion.png")));
                        listaH[contador].posX = i;
                        listaH[contador].posY = j;
                        listaH[contador].imagen = matriz[i][j];
                        contador++;
                        
                    }
                    else{
                        matriz[i][j].setOpaque(false);
                        matriz[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ataque.png")));
                        listaH[contador].posX = i;
                        listaH[contador].posY = j;
                        listaH[contador].imagen = matriz[i][j];
                        contador++;
                    }
                }
            } 
        }
    }
    public void colocarObjetos(){
        listaO[0].posX = 22;
        listaO[0].posY = 6;
        listaO[1].posX = 10;
        listaO[1].posY = 1;
        listaO[2].posX = 2;
        listaO[2].posY = 9;
        
        listaO[3].posX = 22;
        listaO[3].posY = 10;
        listaO[4].posX = 22;
        listaO[4].posY = 1;
        listaO[5].posX = 10;
        listaO[5].posY = 8;
   
        listaO[6].posX = 12;
        listaO[6].posY = 5;
        listaO[7].posX = 6;
        listaO[7].posY = 9;
        listaO[8].posX = 19;
        listaO[8].posY = 3;
        
        for (int i = 0; i < cantidadO; i++) {
            if (i < 3){
                matriz[listaO[i].posX][listaO[i].posY].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enemigo.png")));
                listaO[i].imagen = matriz[listaO[i].posX][listaO[i].posY];
            }
            else if(i < 6){
                matriz[listaO[i].posX][listaO[i].posY].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/recurso.png")));
                listaO[i].imagen = matriz[listaO[i].posX][listaO[i].posY];
            }
            else{
                matriz[listaO[i].posX][listaO[i].posY].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/obstaculo.png")));
                listaO[i].imagen = matriz[listaO[i].posX][listaO[i].posY];
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Background = new javax.swing.JLabel();
        Start = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 51, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setAutoscrolls(true);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 1630, 820));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1830, 920));

        Start.setText("Play");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
        getContentPane().add(Start, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 79, 41));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        for (int i = 15; i >= 0; i--) {
            listaH[i].verificarCasillasCercanas(matriz, listaO, listaH);
        }
       
       
        
       
    }//GEN-LAST:event_StartActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton Start;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
