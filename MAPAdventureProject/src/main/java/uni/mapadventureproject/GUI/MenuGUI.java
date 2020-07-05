/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.GUI;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException; 
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import uni.mapadventureproject.GameManager;
import uni.mapadventureproject.Menu;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;



/**
 *
 * @author Admin
 */
public class MenuGUI extends javax.swing.JFrame {

    Menu gMenu;
    Font font;
    Font fontMinecraft;
    
    
    /**
     * Creates new form MenuGUI
     */
    public MenuGUI(GameManager gManager) {
        initComponents();
        init();
        gMenu = new Menu(gManager);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMenu = new javax.swing.JPanel();
        jbNuovo = new javax.swing.JButton();
        jbCarica = new javax.swing.JButton();
        jbEsci = new javax.swing.JButton();
        jTitolo1 = new javax.swing.JLabel();
        jTitolo2 = new javax.swing.JLabel();
        jlOscuro = new javax.swing.JLabel();
        jlLuce = new javax.swing.JLabel();
        jlVerde = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jmOpzioni = new javax.swing.JMenu();
        jmiNuovo = new javax.swing.JMenuItem();
        jmiCarica = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Metastation: the last exam");
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jpMenu.setLayout(null);

        jbNuovo.setBackground(new java.awt.Color(0, 102, 102));
        jbNuovo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbNuovo.setForeground(new java.awt.Color(255, 255, 255));
        jbNuovo.setText("Nuova Partita");
        jbNuovo.setToolTipText("Inizia una nuova avventura");
        jbNuovo.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 255, 255), new java.awt.Color(153, 255, 255)));
        jbNuovo.setFocusable(false);
        jbNuovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbNuovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuovoActionPerformed(evt);
            }
        });
        jpMenu.add(jbNuovo);
        jbNuovo.setBounds(260, 150, 180, 30);

        jbCarica.setBackground(new java.awt.Color(0, 102, 102));
        jbCarica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbCarica.setForeground(new java.awt.Color(255, 255, 255));
        jbCarica.setText("Carica Partita");
        jbCarica.setToolTipText("Carica e continua una partita salvata");
        jbCarica.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 255, 255), new java.awt.Color(153, 255, 255)));
        jbCarica.setFocusable(false);
        jbCarica.setPreferredSize(new java.awt.Dimension(180, 30));
        jbCarica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCaricaActionPerformed(evt);
            }
        });
        jpMenu.add(jbCarica);
        jbCarica.setBounds(260, 260, 180, 30);

        jbEsci.setBackground(new java.awt.Color(0, 102, 102));
        jbEsci.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbEsci.setForeground(new java.awt.Color(255, 255, 255));
        jbEsci.setText("Esci");
        jbEsci.setToolTipText("Chiudi il gioco");
        jbEsci.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 255, 255), new java.awt.Color(153, 255, 255)));
        jbEsci.setFocusable(false);
        jbEsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEsciActionPerformed(evt);
            }
        });
        jpMenu.add(jbEsci);
        jbEsci.setBounds(260, 370, 180, 30);

        jTitolo1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jTitolo1.setForeground(new java.awt.Color(204, 255, 255));
        jTitolo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitolo1.setText("Metastation:");
        jTitolo1.setPreferredSize(new java.awt.Dimension(700, 50));
        jpMenu.add(jTitolo1);
        jTitolo1.setBounds(0, 30, 700, 50);

        jTitolo2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jTitolo2.setForeground(new java.awt.Color(204, 255, 255));
        jTitolo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitolo2.setText("the last exam");
        jTitolo2.setPreferredSize(new java.awt.Dimension(700, 40));
        jpMenu.add(jTitolo2);
        jTitolo2.setBounds(0, 70, 700, 40);

        jlOscuro.setIcon(new javax.swing.ImageIcon("resources//img//portale oscuro.png"));
        jpMenu.add(jlOscuro);
        jlOscuro.setBounds(0, 0, 350, 250);

        jlLuce.setIcon(new javax.swing.ImageIcon("resources//img//portale luce.png"));
        jpMenu.add(jlLuce);
        jlLuce.setBounds(0, 250, 350, 230);

        jlVerde.setIcon(new javax.swing.ImageIcon("resources//img//portale verde.png"));
        jpMenu.add(jlVerde);
        jlVerde.setBounds(350, -20, 350, 500);

        jMenuBar.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jMenuBar.setToolTipText("");
        jMenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jmOpzioni.setText("Opzioni");

        jmiNuovo.setText("Nuova partita");
        jmiNuovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuovoActionPerformed(evt);
            }
        });
        jmOpzioni.add(jmiNuovo);

        jmiCarica.setText("Carica partita");
        jmiCarica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCaricaActionPerformed(evt);
            }
        });
        jmOpzioni.add(jmiCarica);

        jMenuBar.add(jmOpzioni);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void init() {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("resources//font//Minecraftia-Regular.ttf"));
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            fontMinecraft = font.deriveFont(Font.PLAIN, 12);
            
            this.setFont(fontMinecraft);
            jbNuovo.setFont(fontMinecraft);
            jbCarica.setFont(fontMinecraft);
            jbEsci.setFont(fontMinecraft);
            jMenuBar.setFont(fontMinecraft);
            jmOpzioni.setFont(fontMinecraft);
            jmiCarica.setFont(fontMinecraft);
            jmiNuovo.setFont(fontMinecraft);
        } catch (FontFormatException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Font non caricato correttamente; e'stato impostato un font di default.", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void jmiNuovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuovoActionPerformed
        
        this.jbNuovoActionPerformed(evt);
    }//GEN-LAST:event_jmiNuovoActionPerformed

    private void jbEsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEsciActionPerformed
        int option;
        option = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler chiudere il gioco?", "Sei sicuro di voler chiudere il gioco", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jbEsciActionPerformed

    private void jbNuovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuovoActionPerformed

        try {

            gMenu.newGame();
            
            //Per iniziare il gioco si passa al GameGUI
            GameGUI g = new GameGUI(gMenu.getgInteraction());
            g.setVisible(true);
            this.dispose();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Errore: " + e.getMessage(), "Errore nell'apertura del file", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            /*???*/JOptionPane.showMessageDialog(this, "Errore: " + e.getMessage(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbNuovoActionPerformed

    private void jbCaricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCaricaActionPerformed
        
        JFileChooser fChooser = new JFileChooser();
        fChooser.setMultiSelectionEnabled(false);
        fChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fChooser.setCurrentDirectory(new File("."));
        
        try {
            
        if ( fChooser.showOpenDialog(this) == (JFileChooser.APPROVE_OPTION)) {
            gMenu.loadGame(fChooser.getSelectedFile().getAbsolutePath());
            
            //Per iniziare il gioco si passa al GameGUI
            GameGUI g = new GameGUI(gMenu.getgInteraction());
            g.setVisible(true);
            this.dispose();
        }
        
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Errore: " + e.getMessage(), "Errore nell'apertura del file", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            /*???*/JOptionPane.showMessageDialog(this, "Errore: File non valido\n " + e.getMessage(), "File non valido", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jbCaricaActionPerformed

    private void jmiCaricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCaricaActionPerformed
        
        this.jbCaricaActionPerformed(evt);
    }//GEN-LAST:event_jmiCaricaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JLabel jTitolo1;
    private javax.swing.JLabel jTitolo2;
    private javax.swing.JButton jbCarica;
    private javax.swing.JButton jbEsci;
    private javax.swing.JButton jbNuovo;
    private javax.swing.JLabel jlLuce;
    private javax.swing.JLabel jlOscuro;
    private javax.swing.JLabel jlVerde;
    private javax.swing.JMenu jmOpzioni;
    private javax.swing.JMenuItem jmiCarica;
    private javax.swing.JMenuItem jmiNuovo;
    private javax.swing.JPanel jpMenu;
    // End of variables declaration//GEN-END:variables
}
