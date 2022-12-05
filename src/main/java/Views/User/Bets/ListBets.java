/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views.User.Bets;

import DAOs.ApostaDAO;
import Views.User.*;
import DAOs.GroupDAO;
import DAOs.TimeDAO;
import Models.Aposta;
import Models.Group;
import Models.Time;
import Models.User;
import Views.Admin.Groups.CreateGroup;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author bruno
 */
public class ListBets extends javax.swing.JFrame {

    private User user;
    DefaultListModel listModel = new DefaultListModel();
    ArrayList<Aposta> apostas;

    public ListBets(User user) {
        this.user = user;
        this.apostas = ApostaDAO.list(user.getId());
        initComponents();
        setLocationRelativeTo(null);
        loadUserBets();
    }

    private void loadUserBets() {
        for (int i = 0; i < apostas.size(); i++) {
            listModel.addElement("R$ " + String.format("%.2f", apostas.get(i).getValor()) + " apostado no " + apostas.get(i).getNomeTimeApostado() + " - (" + apostas.get(i).getNomesTimesPartida() + ")");
        }
        list_user_bets.setModel(listModel);
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
        jPanel2 = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        btn_times = new javax.swing.JButton();
        btn_groups = new javax.swing.JButton();
        btn_groups1 = new javax.swing.JButton();
        jp_btns_times = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_user_bets = new javax.swing.JList<>();
        btn_addGroup3 = new javax.swing.JButton();
        btn_addGroup4 = new javax.swing.JButton();
        btn_addGroup5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1280, 720));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFocusable(false);

        lbl_logo.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        lbl_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo.setIcon(new javax.swing.ImageIcon("assets/logo_menor.png"));
        lbl_logo.setToolTipText("");
        lbl_logo.setPreferredSize(new java.awt.Dimension(180, 100));

        btn_times.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_times.setText("Times");
        btn_times.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245)));
        btn_times.setFocusable(false);
        btn_times.setOpaque(true);
        btn_times.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timesActionPerformed(evt);
            }
        });

        btn_groups.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_groups.setText("Grupos");
        btn_groups.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245)));
        btn_groups.setFocusable(false);
        btn_groups.setOpaque(true);
        btn_groups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_groupsActionPerformed(evt);
            }
        });

        btn_groups1.setBackground(new java.awt.Color(27, 164, 72));
        btn_groups1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_groups1.setForeground(new java.awt.Color(255, 255, 255));
        btn_groups1.setText("Minhas Apostas");
        btn_groups1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245)));
        btn_groups1.setFocusable(false);
        btn_groups1.setOpaque(true);
        btn_groups1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_groups1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_groups1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_times, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_groups, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_times, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_groups, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_groups1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp_btns_times.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Minhas Apostas");

        list_user_bets.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        list_user_bets.setSelectionBackground(new java.awt.Color(27, 164, 72));
        list_user_bets.setSelectionForeground(new java.awt.Color(255, 255, 255));
        list_user_bets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_user_betsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list_user_bets);

        btn_addGroup3.setBackground(new java.awt.Color(27, 164, 72));
        btn_addGroup3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_addGroup3.setForeground(new java.awt.Color(255, 255, 255));
        btn_addGroup3.setText("Nova Aposta");
        btn_addGroup3.setBorderPainted(false);
        btn_addGroup3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addGroup3ActionPerformed(evt);
            }
        });

        btn_addGroup4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_addGroup4.setText("Ver Detalhes");
        btn_addGroup4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addGroup4ActionPerformed(evt);
            }
        });

        btn_addGroup5.setBackground(new java.awt.Color(255, 0, 0));
        btn_addGroup5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_addGroup5.setForeground(new java.awt.Color(255, 255, 255));
        btn_addGroup5.setText("Excluir");
        btn_addGroup5.setBorderPainted(false);
        btn_addGroup5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addGroup5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_btns_timesLayout = new javax.swing.GroupLayout(jp_btns_times);
        jp_btns_times.setLayout(jp_btns_timesLayout);
        jp_btns_timesLayout.setHorizontalGroup(
            jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_btns_timesLayout.createSequentialGroup()
                .addGroup(jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_btns_timesLayout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel1))
                    .addGroup(jp_btns_timesLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_addGroup3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_addGroup4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_addGroup5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(25, 25, 25))
        );
        jp_btns_timesLayout.setVerticalGroup(
            jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_btns_timesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_btns_timesLayout.createSequentialGroup()
                        .addComponent(btn_addGroup3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_addGroup4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_addGroup5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jp_btns_times, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jp_btns_times, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void list_user_betsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_user_betsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_list_user_betsMouseClicked

    private void btn_timesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timesActionPerformed
        (new ListTeams(this.user)).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_timesActionPerformed

    private void btn_groupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_groupsActionPerformed
        (new ListGroups(this.user)).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_groupsActionPerformed

    private void btn_groups1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_groups1ActionPerformed
        (new ListBets(user)).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_groups1ActionPerformed

    private void btn_addGroup3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addGroup3ActionPerformed
        (new CreateGroup()).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_addGroup3ActionPerformed

    private void btn_addGroup4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addGroup4ActionPerformed
        int index = list_user_bets.getSelectedIndex();
        Aposta aposta = this.apostas.get(index);
        (new ShowBet(user, aposta)).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_addGroup4ActionPerformed

    private void btn_addGroup5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addGroup5ActionPerformed
        int index = list_user_bets.getSelectedIndex();
        Aposta aposta = this.apostas.get(index);

        if (ApostaDAO.delete(aposta)) {
            listModel.removeElementAt(index);
            this.apostas.remove(index);
        }
    }//GEN-LAST:event_btn_addGroup5ActionPerformed

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
            java.util.logging.Logger.getLogger(ListBets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListBets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListBets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListBets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addGroup;
    private javax.swing.JButton btn_addGroup1;
    private javax.swing.JButton btn_addGroup2;
    private javax.swing.JButton btn_addGroup3;
    private javax.swing.JButton btn_addGroup4;
    private javax.swing.JButton btn_addGroup5;
    private javax.swing.JButton btn_groups;
    private javax.swing.JButton btn_groups1;
    private javax.swing.JButton btn_times;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_btns_times;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JList<String> list_user_bets;
    // End of variables declaration//GEN-END:variables
}
