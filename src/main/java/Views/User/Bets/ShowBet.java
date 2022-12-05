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
import Models.Partida;
import Models.Time;
import Models.User;
import Views.Admin.Groups.CreateGroup;
import Views.User.Matches.ListMatches;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author bruno
 */
public class ShowBet extends javax.swing.JFrame {

    private User user;
    private Aposta aposta;
    DefaultListModel listModel = new DefaultListModel();
    ArrayList<Aposta> apostas;

    public ShowBet(User user, Aposta aposta) {
        this.user = user;
        this.aposta = aposta;
        this.apostas = ApostaDAO.list(user.getId());
        initComponents();
        
        lbl_betAmount.setText("R$ " + String.format("%.2f", aposta.getValor()));
        lbl_betTeam.setText(aposta.getNomeTimeApostado());
        lbl_match.setText(aposta.getNomesTimesPartida());
   
        setLocationRelativeTo(null);
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
        btn_groups4 = new javax.swing.JButton();
        jp_btns_times = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_betTeam = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_betAmount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_match = new javax.swing.JLabel();

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

        btn_groups4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_groups4.setText("Partidas");
        btn_groups4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245)));
        btn_groups4.setFocusable(false);
        btn_groups4.setOpaque(true);
        btn_groups4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_groups4ActionPerformed(evt);
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
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(btn_groups4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(64, Short.MAX_VALUE)))
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
                .addContainerGap(396, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(338, 338, 338)
                    .addComponent(btn_groups4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(339, Short.MAX_VALUE)))
        );

        jp_btns_times.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Detalhes da Aposta");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        jLabel2.setText("Valor Apostado: ");

        lbl_betTeam.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        lbl_betTeam.setMaximumSize(new java.awt.Dimension(250, 42));
        lbl_betTeam.setMinimumSize(new java.awt.Dimension(250, 42));
        lbl_betTeam.setPreferredSize(new java.awt.Dimension(250, 42));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        jLabel3.setText("Partida: ");

        lbl_betAmount.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        lbl_betAmount.setMaximumSize(new java.awt.Dimension(250, 42));
        lbl_betAmount.setMinimumSize(new java.awt.Dimension(250, 42));
        lbl_betAmount.setPreferredSize(new java.awt.Dimension(250, 42));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        jLabel4.setText("Time Apostado: ");

        lbl_match.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        lbl_match.setMaximumSize(new java.awt.Dimension(400, 42));
        lbl_match.setMinimumSize(new java.awt.Dimension(400, 42));
        lbl_match.setPreferredSize(new java.awt.Dimension(400, 42));

        javax.swing.GroupLayout jp_btns_timesLayout = new javax.swing.GroupLayout(jp_btns_times);
        jp_btns_times.setLayout(jp_btns_timesLayout);
        jp_btns_timesLayout.setHorizontalGroup(
            jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_btns_timesLayout.createSequentialGroup()
                .addGroup(jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_btns_timesLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_btns_timesLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(161, 161, 161)
                                .addComponent(lbl_match, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jp_btns_timesLayout.createSequentialGroup()
                                .addGroup(jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(37, 37, 37)
                                .addGroup(jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_betTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_betAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jp_btns_timesLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel1)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jp_btns_timesLayout.setVerticalGroup(
            jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_btns_timesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(90, 90, 90)
                .addGroup(jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jp_btns_timesLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4))
                    .addGroup(jp_btns_timesLayout.createSequentialGroup()
                        .addComponent(lbl_betAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_betTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(jp_btns_timesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(lbl_match, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(270, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jp_btns_times, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jp_btns_times, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_groups4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_groups4ActionPerformed
        (new ListMatches(user)).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_groups4ActionPerformed

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
            java.util.logging.Logger.getLogger(ShowBet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowBet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowBet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowBet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btn_groups;
    private javax.swing.JButton btn_groups1;
    private javax.swing.JButton btn_groups2;
    private javax.swing.JButton btn_groups3;
    private javax.swing.JButton btn_groups4;
    private javax.swing.JButton btn_times;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jp_btns_times;
    private javax.swing.JLabel lbl_betAmount;
    private javax.swing.JLabel lbl_betTeam;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_match;
    // End of variables declaration//GEN-END:variables
}
