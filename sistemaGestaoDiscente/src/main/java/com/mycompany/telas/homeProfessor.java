/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.telas;
import com.mycompany.sistemagestaodiscente.*;
/**
Kaio de Oliveira e Sousa(202165080AC)
Filipe de Lima Namorato(202165035AB)
Gustavo Silva Ribeiro (202165057AC)
 */
public class homeProfessor extends javax.swing.JFrame {

    /**
     * Creates new form homeProfessor
     */
    public homeProfessor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProfessor = new javax.swing.JPanel();
        BackButton2 = new javax.swing.JButton();
        menuProfessor = new javax.swing.JMenuBar();
        menuAtribProfessor = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuTurmaProfessor = new javax.swing.JMenu();
        LFreq = new javax.swing.JMenuItem();
        LNota = new javax.swing.JMenuItem();
        menuConsultProfessor = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelProfessor.setBackground(new java.awt.Color(255, 255, 255));

        BackButton2.setText("Sair");
        BackButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProfessorLayout = new javax.swing.GroupLayout(panelProfessor);
        panelProfessor.setLayout(panelProfessorLayout);
        panelProfessorLayout.setHorizontalGroup(
            panelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProfessorLayout.createSequentialGroup()
                .addGap(0, 328, Short.MAX_VALUE)
                .addComponent(BackButton2))
        );
        panelProfessorLayout.setVerticalGroup(
            panelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfessorLayout.createSequentialGroup()
                .addComponent(BackButton2)
                .addGap(0, 254, Short.MAX_VALUE))
        );

        menuAtribProfessor.setText("Atribuir");

        jMenuItem1.setText("Atribuir Aluno a turma");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuAtribProfessor.add(jMenuItem1);

        menuProfessor.add(menuAtribProfessor);

        menuTurmaProfessor.setText("Turma");
        menuTurmaProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTurmaProfessorActionPerformed(evt);
            }
        });

        LFreq.setText("Lançar frequência");
        LFreq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LFreqActionPerformed(evt);
            }
        });
        menuTurmaProfessor.add(LFreq);

        LNota.setText("Lançar notas");
        LNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LNotaActionPerformed(evt);
            }
        });
        menuTurmaProfessor.add(LNota);

        menuProfessor.add(menuTurmaProfessor);

        menuConsultProfessor.setText("Consultar");

        jMenuItem4.setText("Consultar turmas");
        menuConsultProfessor.add(jMenuItem4);

        menuProfessor.add(menuConsultProfessor);

        setJMenuBar(menuProfessor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProfessor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void LNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LNotaActionPerformed
        lancarNotaProfessor tela = new lancarNotaProfessor();
        tela.setVisible(true);
    }//GEN-LAST:event_LNotaActionPerformed

    private void menuTurmaProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTurmaProfessorActionPerformed
                    
    }//GEN-LAST:event_menuTurmaProfessorActionPerformed

    private void LFreqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFreqActionPerformed
        lancarFreqProfessor tela = new lancarFreqProfessor();
        tela.setVisible(true);
    }//GEN-LAST:event_LFreqActionPerformed

    private void BackButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton2ActionPerformed

        this.setVisible(false);
        telaLogin login = new telaLogin();
        login.setVisible(true);
    }//GEN-LAST:event_BackButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(homeProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homeProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homeProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homeProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homeProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton2;
    private javax.swing.JMenuItem LFreq;
    private javax.swing.JMenuItem LNota;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu menuAtribProfessor;
    private javax.swing.JMenu menuConsultProfessor;
    private javax.swing.JMenuBar menuProfessor;
    private javax.swing.JMenu menuTurmaProfessor;
    private javax.swing.JPanel panelProfessor;
    // End of variables declaration//GEN-END:variables
}
