/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.GUI;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


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

    public void init(){
        //inventory.add(oggetto);
        //jLabel2.setIcon(oggetto.path);
        int i;
        
        jDesktopPane1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        for(i=0;i<7;i++){
         //String label="jl"+i;
         if(i>35){
             JOptionPane.showMessageDialog(rootPane,"inventario pieno");
             break;
         }else{
        
        JLabel label = new javax.swing.JLabel();
        label.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        //label.setSize(new Dimension(75,75));
        label.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\casa1.jpg"));
        label.setToolTipText("casa per vacanze");
        jDesktopPane1.add(label);
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

        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(450, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1, 100));
        jDesktopPane1.setLayout(new java.awt.GridLayout(6, 6));
        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 450, 450);

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
    private javax.swing.JDesktopPane jDesktopPane1;
    // End of variables declaration//GEN-END:variables
}
