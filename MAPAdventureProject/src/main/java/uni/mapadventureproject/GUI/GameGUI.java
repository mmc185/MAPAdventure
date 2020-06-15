/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.GUI;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class GameGUI extends javax.swing.JFrame {

    /**
     * Creates new form GameGUI
     */
    public GameGUI() {
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

        jpButtons = new javax.swing.JPanel();
        jbNorth = new javax.swing.JButton();
        jbSouth = new javax.swing.JButton();
        jbWest = new javax.swing.JButton();
        jbEast = new javax.swing.JButton();
        jbUp = new javax.swing.JButton();
        jbDown = new javax.swing.JButton();
        jlType = new javax.swing.JLabel();
        jbSend = new javax.swing.JButton();
        jScrollPaneRead = new javax.swing.JScrollPane();
        jtaReadingArea = new javax.swing.JTextArea();
        jScrollPaneWrite = new javax.swing.JScrollPane();
        jtTypingField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmOptions = new javax.swing.JMenu();
        jmiSaveGame = new javax.swing.JMenuItem();
        jmiBackMenu = new javax.swing.JMenuItem();
        jmHelp = new javax.swing.JMenu();
        jmiSaveGame1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MAP Adventure");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 700));

        jpButtons.setForeground(new java.awt.Color(60, 63, 65));

        jbNorth.setBackground(new java.awt.Color(0, 102, 102));
        jbNorth.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbNorth.setIcon(new javax.swing.ImageIcon("img//arrowNorthT.png"));
        jbNorth.setToolTipText("nord [n]");
        jbNorth.setAlignmentY(0.0F);
        jbNorth.setBorder(new javax.swing.border.MatteBorder(null));
        jbNorth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNorth.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbNorth.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jbNorth.setMaximumSize(new java.awt.Dimension(50, 50));
        jbNorth.setMinimumSize(new java.awt.Dimension(50, 50));
        jbNorth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNorthActionPerformed(evt);
            }
        });

        jbSouth.setBackground(new java.awt.Color(0, 102, 102));
        jbSouth.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbSouth.setIcon(new javax.swing.ImageIcon("img//arrowSouthT.png"));
        jbSouth.setToolTipText("sud [s]");
        jbSouth.setAlignmentY(0.0F);
        jbSouth.setBorder(new javax.swing.border.MatteBorder(null));
        jbSouth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSouth.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbSouth.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jbSouth.setMaximumSize(new java.awt.Dimension(50, 50));
        jbSouth.setMinimumSize(new java.awt.Dimension(50, 50));
        jbSouth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSouthActionPerformed(evt);
            }
        });

        jbWest.setBackground(new java.awt.Color(0, 102, 102));
        jbWest.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbWest.setIcon(new javax.swing.ImageIcon("img//arrowWestT.png"));
        jbWest.setToolTipText("ovest [o]");
        jbWest.setAlignmentY(0.0F);
        jbWest.setBorder(new javax.swing.border.MatteBorder(null));
        jbWest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbWest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbWest.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jbWest.setMaximumSize(new java.awt.Dimension(50, 50));
        jbWest.setMinimumSize(new java.awt.Dimension(50, 50));
        jbWest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbWestActionPerformed(evt);
            }
        });

        jbEast.setBackground(new java.awt.Color(0, 102, 102));
        jbEast.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbEast.setIcon(new javax.swing.ImageIcon("img//arrowEastT.png"));
        jbEast.setToolTipText("est [e]");
        jbEast.setAlignmentY(0.0F);
        jbEast.setBorder(new javax.swing.border.MatteBorder(null));
        jbEast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEast.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEast.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jbEast.setMaximumSize(new java.awt.Dimension(50, 50));
        jbEast.setMinimumSize(new java.awt.Dimension(50, 50));
        jbEast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEastActionPerformed(evt);
            }
        });

        jbUp.setBackground(new java.awt.Color(0, 102, 102));
        jbUp.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbUp.setIcon(new javax.swing.ImageIcon("img//up.png"));
        jbUp.setToolTipText("su");
        jbUp.setAlignmentY(0.0F);
        jbUp.setBorder(new javax.swing.border.MatteBorder(null));
        jbUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbUp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbUp.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jbUp.setMaximumSize(new java.awt.Dimension(50, 50));
        jbUp.setMinimumSize(new java.awt.Dimension(50, 50));
        jbUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpActionPerformed(evt);
            }
        });

        jbDown.setBackground(new java.awt.Color(0, 102, 102));
        jbDown.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbDown.setIcon(new javax.swing.ImageIcon("img//down.png"));
        jbDown.setToolTipText("giu'");
        jbDown.setAlignmentY(0.0F);
        jbDown.setBorder(new javax.swing.border.MatteBorder(null));
        jbDown.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbDown.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbDown.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jbDown.setMaximumSize(new java.awt.Dimension(50, 50));
        jbDown.setMinimumSize(new java.awt.Dimension(50, 50));
        jbDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpButtonsLayout = new javax.swing.GroupLayout(jpButtons);
        jpButtons.setLayout(jpButtonsLayout);
        jpButtonsLayout.setHorizontalGroup(
            jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbWest, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSouth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNorth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEast, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbDown, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbUp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbEast, jbNorth, jbSouth, jbWest});

        jpButtonsLayout.setVerticalGroup(
            jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpButtonsLayout.createSequentialGroup()
                        .addComponent(jbUp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDown, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbWest, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpButtonsLayout.createSequentialGroup()
                        .addComponent(jbNorth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSouth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbEast, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbEast, jbNorth, jbSouth, jbWest});

        jlType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlType.setText("Inserisci un comando:");

        jbSend.setBackground(new java.awt.Color(0, 102, 102));
        jbSend.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbSend.setForeground(new java.awt.Color(255, 255, 255));
        jbSend.setText("Invia");
        jbSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSendActionPerformed(evt);
            }
        });

        jScrollPaneRead.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneRead.setToolTipText("");
        jScrollPaneRead.setColumnHeaderView(null);
        jScrollPaneRead.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPaneRead.setMaximumSize(new java.awt.Dimension(900, 450));
        jScrollPaneRead.setMinimumSize(new java.awt.Dimension(900, 450));
        jScrollPaneRead.setPreferredSize(new java.awt.Dimension(900, 450));
        jScrollPaneRead.setViewportView(jtaReadingArea);

        jtaReadingArea.setEditable(false);
        jtaReadingArea.setBackground(new java.awt.Color(0, 0, 0));
        jtaReadingArea.setColumns(20);
        jtaReadingArea.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtaReadingArea.setForeground(new java.awt.Color(255, 255, 255));
        jtaReadingArea.setLineWrap(true);
        jtaReadingArea.setRows(15);
        jtaReadingArea.setMaximumSize(new java.awt.Dimension(900, 450));
        jtaReadingArea.setMinimumSize(new java.awt.Dimension(900, 450));
        jScrollPaneRead.setViewportView(jtaReadingArea);

        jScrollPaneWrite.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPaneWrite.setAutoscrolls(true);
        jScrollPaneWrite.setColumnHeaderView(jtTypingField);
        jScrollPaneWrite.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jScrollPaneWrite.setMaximumSize(new java.awt.Dimension(500, 40));
        jScrollPaneWrite.setMinimumSize(new java.awt.Dimension(500, 40));
        jScrollPaneWrite.setPreferredSize(new java.awt.Dimension(500, 40));
        jScrollPaneWrite.setViewportView(jtTypingField);

        jtTypingField.setBackground(new java.awt.Color(255, 255, 255));
        jtTypingField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtTypingField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtTypingField.setMaximumSize(new java.awt.Dimension(500, 40));
        jtTypingField.setMinimumSize(new java.awt.Dimension(500, 40));
        jtTypingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTypingFieldActionPerformed(evt);
            }
        });
        jtTypingField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtTypingFieldKeyPressed(evt);
            }
        });
        jScrollPaneWrite.setViewportView(jtTypingField);

        jLabel1.setIcon(new javax.swing.ImageIcon("img//placeHolder.png"));
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));

        jmOptions.setText("Opzioni");
        jmOptions.setToolTipText("");
        jmOptions.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jmiSaveGame.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jmiSaveGame.setText("Salva partita");
        jmOptions.add(jmiSaveGame);

        jmiBackMenu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jmiBackMenu.setText("Torna al menu principale");
        jmiBackMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBackMenuActionPerformed(evt);
            }
        });
        jmOptions.add(jmiBackMenu);

        jMenuBar1.add(jmOptions);

        jmHelp.setText("?");
        jmHelp.setToolTipText("");
        jmHelp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jmiSaveGame1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jmiSaveGame1.setText("Aiuto...");
        jmHelp.add(jmiSaveGame1);

        jMenuBar1.add(jmHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneRead, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jlType))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPaneWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbSend)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPaneRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlType, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbSend)
                                .addGap(12, 12, 12))))
                    .addComponent(jpButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtTypingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTypingFieldActionPerformed
        //Qui l'utente inserisce il suo testo
    }//GEN-LAST:event_jtTypingFieldActionPerformed

    private void jbSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSendActionPerformed
        if (!jtTypingField.getText().isBlank()) {
            jtaReadingArea.append(jtTypingField.getText() + "\n");
            jtTypingField.setText("");
        }
    }//GEN-LAST:event_jbSendActionPerformed

    private void jbNorthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNorthActionPerformed
        // L'utente si muove verso nord
    }//GEN-LAST:event_jbNorthActionPerformed

    private void jbSouthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSouthActionPerformed
        // L'utente si muove verso sud
    }//GEN-LAST:event_jbSouthActionPerformed

    private void jbWestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbWestActionPerformed
        // L'utente si muove verso ovest
    }//GEN-LAST:event_jbWestActionPerformed

    private void jbEastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEastActionPerformed
        // L'utente si muove verso est
    }//GEN-LAST:event_jbEastActionPerformed

    private void jbUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpActionPerformed
        // L'utente si muove verso su
    }//GEN-LAST:event_jbUpActionPerformed

    private void jbDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDownActionPerformed
        // L'utente si muove verso giù
    }//GEN-LAST:event_jbDownActionPerformed

    private void jtTypingFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTypingFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbSend.doClick();
        }

        /*
Devi fare un getText sulla textfield
Salvarti il testo in una stringa
E fare un append alla textarea
In modo da farlo uscire sotto
Ah e poi ovviamente ripulisci la textfield Per pulirla di basta fare setText("")*/
    }//GEN-LAST:event_jtTypingFieldKeyPressed

    private void jmiBackMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBackMenuActionPerformed
        int yesOption;
        yesOption = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler tornare al menu principale?", "Ritorno al menu principale", JOptionPane.YES_NO_OPTION);
        if (yesOption == JOptionPane.YES_OPTION) {
            MenuGUI m = new MenuGUI();
            m.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jmiBackMenuActionPerformed

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
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPaneRead;
    private javax.swing.JScrollPane jScrollPaneWrite;
    private javax.swing.JButton jbDown;
    private javax.swing.JButton jbEast;
    private javax.swing.JButton jbNorth;
    private javax.swing.JButton jbSend;
    private javax.swing.JButton jbSouth;
    private javax.swing.JButton jbUp;
    private javax.swing.JButton jbWest;
    private javax.swing.JLabel jlType;
    private javax.swing.JMenu jmHelp;
    private javax.swing.JMenu jmOptions;
    private javax.swing.JMenuItem jmiBackMenu;
    private javax.swing.JMenuItem jmiSaveGame;
    private javax.swing.JMenuItem jmiSaveGame1;
    private javax.swing.JPanel jpButtons;
    private javax.swing.JTextField jtTypingField;
    private javax.swing.JTextArea jtaReadingArea;
    // End of variables declaration//GEN-END:variables
}
