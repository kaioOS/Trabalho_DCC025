
package com.mycompany.telas;
import com.mycompany.sistemagestaodiscente.*;
import java.util.List;
import javax.swing.JOptionPane;
/**
Kaio de Oliveira e Sousa(202165080AC)
Filipe de Lima Namorato(202165035AB)
Gustavo Silva Ribeiro (202165057AC)
 */
public class telaLogin extends javax.swing.JFrame {

    /**
     * Creates new form telaLogin
     */
    public telaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserType = new javax.swing.ButtonGroup();
        panelLogin = new javax.swing.JPanel();
        labelUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        buttonLogin = new javax.swing.JButton();
        labelLogoSGD1 = new javax.swing.JLabel();
        labelLogoSGD2 = new javax.swing.JLabel();
        rbAdm = new javax.swing.JRadioButton();
        rbProf = new javax.swing.JRadioButton();
        rbAluno = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));

        labelUser.setText("Usuário(CPF)");

        labelPassword.setText("Senha");

        buttonLogin.setText("Entrar");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        labelLogoSGD1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        labelLogoSGD1.setText("Sistema de Gestão");

        labelLogoSGD2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        labelLogoSGD2.setText("Discente");

        UserType.add(rbAdm);
        rbAdm.setText("Administrador");

        UserType.add(rbProf);
        rbProf.setText("Professor");
        rbProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProfActionPerformed(evt);
            }
        });

        UserType.add(rbAluno);
        rbAluno.setText("Aluno");

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonLogin)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelUser)
                                    .addComponent(labelPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUser)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(291, Short.MAX_VALUE))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLogoSGD1)
                            .addComponent(labelLogoSGD2))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addComponent(rbAdm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbProf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAluno)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(labelLogoSGD1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelLogoSGD2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAdm)
                    .addComponent(rbProf)
                    .addComponent(rbAluno))
                .addGap(26, 26, 26)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonLogin)
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed

        String cpf = txtUser.getText();
        cpf = cpf.replaceAll("[^0-9]", "");
        char[] Csenha = txtPassword.getPassword();
        String senha = new String(Csenha);
        if (!rbAluno.isSelected() && !rbProf.isSelected() && !rbAdm.isSelected()) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de usuário");
        }
        else if(rbAluno.isSelected())
        {
            if(Usuario.verificaLoginUsuario(cpf, senha, 2))
            {
                homeAluno aluno = new homeAluno();
                aluno.setVisible(true);
                this.setVisible(false);
            }
            else
                JOptionPane.showMessageDialog(null, "Usuário inválido");
        }
        else if(rbProf.isSelected())
        {
            if(Usuario.verificaLoginUsuario(cpf,senha,1))
            {
                homeProfessor professor = new homeProfessor();
                professor.setVisible(true);
                this.setVisible(false);
            }
            else
                JOptionPane.showMessageDialog(null, "Usuário inválido");
                
        }
        else if(rbAdm.isSelected())
        {
            if(Usuario.verificaLoginUsuario(cpf,senha,0))
            {
                
                PersistenciaAdministrador persistenciaAdministrador = new PersistenciaAdministrador();
                List<Administrador> administradores = persistenciaAdministrador.carregarDados();
                for (Administrador administrador : administradores) {
                    if (administrador.getCPF().equals(cpf)) {
                        homeAdmin admin = new homeAdmin();
                        admin.setVisible(true);
                        this.setVisible(false);
                    }
                }
                
                
            }
            else
                JOptionPane.showMessageDialog(null, "Usuário inválido");
        }
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void rbProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbProfActionPerformed

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
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup UserType;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel labelLogoSGD1;
    private javax.swing.JLabel labelLogoSGD2;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUser;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JRadioButton rbAdm;
    private javax.swing.JRadioButton rbAluno;
    private javax.swing.JRadioButton rbProf;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
