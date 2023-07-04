/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.telas;
import com.mycompany.sistemagestaodiscente.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
Kaio de Oliveira e Sousa(202165080AC)
Filipe de Lima Namorato(202165035AB)
Gustavo Silva Ribeiro (202165057AC)
 */
public class cadastrarTurma extends javax.swing.JFrame {

    /**
     * Creates new form cadastrarProfessor
     */
    public cadastrarTurma() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelUser = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        txtCodDisc = new javax.swing.JTextField();
        labelPassword1 = new javax.swing.JLabel();
        labelLogoSGD1 = new javax.swing.JLabel();
        buttonRegister = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        txtDisc = new javax.swing.JTextField();
        rbS = new javax.swing.JRadioButton();
        rbMD = new javax.swing.JRadioButton();
        rbMA = new javax.swing.JRadioButton();
        rbMP = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelUser.setText(" Código da Turma");

        labelPassword.setText("Código da Disciplina correspondente");

        labelPassword1.setText("Forma de avaliação");

        labelLogoSGD1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelLogoSGD1.setText("Cadastrar Turma");

        buttonRegister.setText("Cadastrar");
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });

        BackButton.setText("Voltar");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbS);
        rbS.setText("Somatório");
        rbS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbMD);
        rbMD.setText("Média com descarte de menor nota");

        buttonGroup1.add(rbMA);
        rbMA.setText("Média Aritmética");

        buttonGroup1.add(rbMP);
        rbMP.setText("Média Ponderada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BackButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogoSGD1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPassword)
                            .addComponent(labelUser)
                            .addComponent(labelPassword1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCodDisc, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                .addComponent(txtDisc))
                            .addComponent(rbMA)
                            .addComponent(rbMP)
                            .addComponent(rbS)
                            .addComponent(rbMD)
                            .addComponent(buttonRegister))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BackButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(labelLogoSGD1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUser)
                    .addComponent(txtCodDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassword1)
                    .addComponent(rbS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbMA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbMD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbMP)
                .addGap(46, 46, 46)
                .addComponent(buttonRegister)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
        String codigoTurma = txtCodDisc.getText();
        String disciplina = txtDisc.getText();
        if (!rbS.isSelected() && !rbMA.isSelected() && !rbMD.isSelected() && !rbMP.isSelected()) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo avaliação");
        }
        else if(rbS.isSelected())
        {
            try {
                Administrador.cadastroTurmaPorAdm(codigoTurma, disciplina, 4);
                JOptionPane.showMessageDialog(null, "Cadastro completo!");
                this.setVisible(false);
                cadastrarTurma novaTela = new cadastrarTurma();
                novaTela.setVisible(true);
            } catch (ExceptionFormaAvaliacao ex) {
                JOptionPane.showMessageDialog(null, "Tipo de avaliação inválido");
            } catch (ExceptionTurmaCadastrada ex) {
                JOptionPane.showMessageDialog(null, "Turma já cadastrada anteriormente!");
            }
            
        }
        else if(rbMD.isSelected())
        {
            try {
                Administrador.cadastroTurmaPorAdm(codigoTurma, disciplina, 3);
                JOptionPane.showMessageDialog(null, "Cadastro completo!");
                this.setVisible(false);
                cadastrarTurma novaTela = new cadastrarTurma();
                novaTela.setVisible(true);
            } catch (ExceptionFormaAvaliacao ex) {
                JOptionPane.showMessageDialog(null, "Tipo de avaliação inválido");
            } catch (ExceptionTurmaCadastrada ex) {
                JOptionPane.showMessageDialog(null, "Turma já cadastrada anteriormente!");
            }
        }
        else if(rbMA.isSelected())
        {          
            try {
                Administrador.cadastroTurmaPorAdm(codigoTurma, disciplina, 1);
                JOptionPane.showMessageDialog(null, "Cadastro completo!");
                this.setVisible(false);
                cadastrarTurma novaTela = new cadastrarTurma();
                novaTela.setVisible(true);
            } catch (ExceptionFormaAvaliacao ex) {
                JOptionPane.showMessageDialog(null, "Tipo de avaliação inválido");
            } catch (ExceptionTurmaCadastrada ex) {
                JOptionPane.showMessageDialog(null, "Turma já cadastrada anteriormente!");
            }
        }
        else if(rbMP.isSelected())
        {
            try {
                Administrador.cadastroTurmaPorAdm(codigoTurma, disciplina, 2);
                JOptionPane.showMessageDialog(null, "Cadastro completo!");
                this.setVisible(false);
                cadastrarTurma novaTela = new cadastrarTurma();
                novaTela.setVisible(true);
            } catch (ExceptionFormaAvaliacao ex) {
                JOptionPane.showMessageDialog(null, "Tipo de avaliação inválido");
            } catch (ExceptionTurmaCadastrada ex) {
                JOptionPane.showMessageDialog(null, "Turma já cadastrada anteriormente!");
            }
        }
       
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void rbSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbSActionPerformed

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
            java.util.logging.Logger.getLogger(cadastrarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastrarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastrarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastrarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastrarTurma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelLogoSGD1;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelPassword1;
    private javax.swing.JLabel labelUser;
    private javax.swing.JRadioButton rbMA;
    private javax.swing.JRadioButton rbMD;
    private javax.swing.JRadioButton rbMP;
    private javax.swing.JRadioButton rbS;
    private javax.swing.JTextField txtCodDisc;
    private javax.swing.JTextField txtDisc;
    // End of variables declaration//GEN-END:variables
}
