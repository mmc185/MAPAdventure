/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.GUI;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Admin
 */
public class InventoryGUI extends javax.swing.JFrame {

    /**
     * Creates new form InventoryGUI
     */
    public InventoryGUI() {
        initComponents();
        init();
    }

    public void init() {
        //inventory.add(oggetto);
        //jLabel2.setIcon(oggetto.path);
        int i;

        this.setSize(712, 737);

        jScrollPane1.setSize(660, 660);
        jScrollPane1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jScrollPane1.setAlignmentX(50);
        //jScrollPane1.setAlignmentY(50);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        //jScrollPane1.setVisible(false);

        for (i = 0; i < 3; i++) {
            //String label="jl"+i;
            //if(i>35){
            //JOptionPane.showMessageDialog(rootPane,"inventario pieno");
            //break;
            //}else{

            JButton jbImage = new JButton();
            jbImage.setBackground(Color.black);

            ImageIcon img = new ImageIcon("C://Users//marta//MAPAdventure//MAPAdventureProject//img//placeHolder.png");
            Image img2 = img.getImage();
            jbImage.setIcon(new ImageIcon(img2.getScaledInstance(75, 75, 0)));
            jbImage.setSize(75, 75);
            jbImage.setToolTipText("Treno");

            jbImage.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jbImageActionPerformed(evt, "mi piacciono i treni", "treno");
                }
            });
        
            jInventoryPanel.add(jbImage);
        }

        //}
    }

    private void jbImageActionPerformed(java.awt.event.ActionEvent evt, String ItemDesc, String ItemName) {
        JOptionPane.showMessageDialog(this, ItemDesc, ItemName, JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jInventoryPanel = new javax.swing.JPanel();
        jBackgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(700, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setMaximumSize(new java.awt.Dimension(700, 700));
        jPanel2.setMinimumSize(new java.awt.Dimension(700, 700));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanel2.setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(650, 650));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(650, 650));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(650, 650));

        jInventoryPanel.setBackground(new java.awt.Color(0, 0, 0));
        jInventoryPanel.setLayout(new java.awt.GridLayout(6, 6));
        jScrollPane1.setViewportView(jInventoryPanel);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 660, 660);

        jBackgroundLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBackgroundLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\marta\\Downloads\\Telegram Desktop\\v3b.png")); // NOI18N
        jBackgroundLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jBackgroundLabel.setMaximumSize(new java.awt.Dimension(700, 700));
        jBackgroundLabel.setMinimumSize(new java.awt.Dimension(700, 700));
        jBackgroundLabel.setPreferredSize(new java.awt.Dimension(700, 700));
        jBackgroundLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel2.add(jBackgroundLabel);
        jBackgroundLabel.setBounds(0, 0, 700, 700);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 700, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBackgroundLabel;
    private javax.swing.JPanel jInventoryPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
