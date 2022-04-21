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
    int cantidadH = 6;
    int cantidadO = 6;
    Hormigas listaH[] = new Hormigas [cantidadH];
    Objeto listaO[] = new Objeto [cantidadO];
    JLabel matriz[][] = new JLabel[10][10]; 
    
    /**
     * Creates new form Tablero
     */
    
    public Tablero() {
        initComponents();
    }
    
    public void inicializarHO(){
        for (int i = 0; i <6 ; i++ ){
            if (i%2 == 0){
                listaH[i] = new Defensora(0,0);
            }
            else{
                listaH[i] = new Recolectora(0,0);
            }
        }
        
        
        for (int i = 0; i < 10; i++){
            for (int j = 0; j<10; j++){
                matriz[i][j] = new JLabel();
       
                jPanel1.add(matriz[i][j], new org.netbeans.lib.awtextra.AbsoluteConstraints(150 + i * 150, 10, 150, 150 + j*200 ));
                System.out.println("Agregado");
            } 
        }
        matriz[0][0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/base.png")));
        pack();
     }
    
    
    
    public void moverHormiga(int hormigaX, int hormigaY){
        
        matriz[hormigaX][hormigaY].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ataque.png")));
        pack();
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
        Start = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setAutoscrolls(true);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Start.setText("Play");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
        jPanel1.add(Start, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 79, 41));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 0, 1780, 935));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1830, 940));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed

        inicializarHO();
        //for (int i = 0; i < 10; i++){
        //    moverHormiga(i,i);   
       // }
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
