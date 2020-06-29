/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import uni.mapadventureproject.GameInteraction;

/**
 *
 * @author Admin
 */
public class GameGUI extends javax.swing.JFrame {

    GameInteraction gInteraction;
    Font font;
    Font fontMinecraft;

    /**
     * Creates new form GameGUI
     */
    public GameGUI(GameInteraction gInteraction) {

        initComponents();
        init();
        this.gInteraction = gInteraction;
        initGame();

    }

    private void init() {

        // La risorsa del try with resource si chiuderà da sola poiché implementa l'interfaccia AutoCloseable
        try (InputStream is = new BufferedInputStream(new FileInputStream("font//Minecraftia-Regular.ttf"))){
            
            font = Font.createFont(Font.TRUETYPE_FONT, is); 
            fontMinecraft = font.deriveFont(Font.PLAIN, 14);

            this.setFont(fontMinecraft);
            jmbOptions.setFont(fontMinecraft);
            jmOptions.setFont(fontMinecraft);
            jmiBackMenu.setFont(fontMinecraft);
            jmiSaveGame.setFont(fontMinecraft);
            jmHelp.setFont(fontMinecraft);
            jmiHelp.setFont(fontMinecraft);
            jlCommand.setFont(fontMinecraft.deriveFont(Font.BOLD, 14));
            jtTypingField.setFont(fontMinecraft);
            jbSend.setFont(fontMinecraft);
            jbUp.setFont(fontMinecraft);
            jbDown.setFont(fontMinecraft);
            jtpReadingArea.setFont(fontMinecraft);
           

        } catch (FontFormatException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Font non caricato correttamente; e'stato impostato un font di default.", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public void initGame() {
        
        jtpReadingArea.setText(gInteraction.getGameManager().getGame().getCurrentRoom().getDesc() + "\n");
        
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
        jlCommand = new javax.swing.JLabel();
        jbInv = new javax.swing.JButton();
        jbSend = new javax.swing.JButton();
        jspWrite = new javax.swing.JScrollPane();
        jtTypingField = new javax.swing.JTextField();
        jlImage = new javax.swing.JLabel();
        jspRead2 = new javax.swing.JScrollPane();
        jtpReadingArea = new javax.swing.JTextPane();
        jlBackground = new javax.swing.JLabel();
        jmbOptions = new javax.swing.JMenuBar();
        jmOptions = new javax.swing.JMenu();
        jmiSaveGame = new javax.swing.JMenuItem();
        jmiBackMenu = new javax.swing.JMenuItem();
        jmHelp = new javax.swing.JMenu();
        jmiHelp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Metastation: the last exam");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        setForeground(java.awt.Color.white);
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(null);

        jpButtons.setForeground(new java.awt.Color(60, 63, 65));
        jpButtons.setOpaque(false);

        jbNorth.setBackground(new java.awt.Color(56, 86, 128));
        jbNorth.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbNorth.setIcon(new javax.swing.ImageIcon("img//arrowNorthT.png"));
        jbNorth.setToolTipText("nord [n]");
        jbNorth.setAlignmentY(0.0F);
        jbNorth.setBorder(new javax.swing.border.MatteBorder(null));
        jbNorth.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbNorth.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbNorth.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jbNorth.setMaximumSize(new java.awt.Dimension(50, 50));
        jbNorth.setMinimumSize(new java.awt.Dimension(50, 50));
        jbNorth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNorthActionPerformed(evt);
            }
        });

        jbSouth.setBackground(new java.awt.Color(56, 86, 128));
        jbSouth.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbSouth.setIcon(new javax.swing.ImageIcon("img//arrowSouthT.png"));
        jbSouth.setToolTipText("sud [s]");
        jbSouth.setAlignmentY(0.0F);
        jbSouth.setBorder(new javax.swing.border.MatteBorder(null));
        jbSouth.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbSouth.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbSouth.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jbSouth.setMaximumSize(new java.awt.Dimension(50, 50));
        jbSouth.setMinimumSize(new java.awt.Dimension(50, 50));
        jbSouth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSouthActionPerformed(evt);
            }
        });

        jbWest.setBackground(new java.awt.Color(56, 86, 128));
        jbWest.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbWest.setIcon(new javax.swing.ImageIcon("img//arrowWestT.png"));
        jbWest.setToolTipText("ovest [o]");
        jbWest.setAlignmentY(0.0F);
        jbWest.setBorder(new javax.swing.border.MatteBorder(null));
        jbWest.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbWest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbWest.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jbWest.setMaximumSize(new java.awt.Dimension(50, 50));
        jbWest.setMinimumSize(new java.awt.Dimension(50, 50));
        jbWest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbWestActionPerformed(evt);
            }
        });

        jbEast.setBackground(new java.awt.Color(56, 86, 128));
        jbEast.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbEast.setIcon(new javax.swing.ImageIcon("img//arrowEastT.png"));
        jbEast.setToolTipText("est [e]");
        jbEast.setAlignmentY(0.0F);
        jbEast.setBorder(new javax.swing.border.MatteBorder(null));
        jbEast.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbEast.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEast.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jbEast.setMaximumSize(new java.awt.Dimension(50, 50));
        jbEast.setMinimumSize(new java.awt.Dimension(50, 50));
        jbEast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEastActionPerformed(evt);
            }
        });

        jbUp.setBackground(new java.awt.Color(56, 86, 128));
        jbUp.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbUp.setForeground(new java.awt.Color(255, 255, 255));
        jbUp.setText("su");
        jbUp.setToolTipText("su");
        jbUp.setAlignmentY(0.0F);
        jbUp.setBorder(new javax.swing.border.MatteBorder(null));
        jbUp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbUp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbUp.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jbUp.setMaximumSize(new java.awt.Dimension(50, 50));
        jbUp.setMinimumSize(new java.awt.Dimension(50, 50));
        jbUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpActionPerformed(evt);
            }
        });

        jbDown.setBackground(new java.awt.Color(56, 86, 128));
        jbDown.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jbDown.setForeground(new java.awt.Color(255, 255, 255));
        jbDown.setText("giu'");
        jbDown.setToolTipText("giu'");
        jbDown.setAlignmentY(0.0F);
        jbDown.setBorder(new javax.swing.border.MatteBorder(null));
        jbDown.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        getContentPane().add(jpButtons);
        jpButtons.setBounds(680, 495, 242, 118);

        jlCommand.setBackground(new java.awt.Color(108, 202, 224));
        jlCommand.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlCommand.setForeground(new java.awt.Color(0, 0, 0));
        jlCommand.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlCommand.setText("Inserisci un comando:");
        jlCommand.setOpaque(true);
        getContentPane().add(jlCommand);
        jlCommand.setBounds(53, 514, 200, 28);

        jbInv.setBackground(new java.awt.Color(56, 86, 128));
        jbInv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbInv.setForeground(new java.awt.Color(255, 255, 255));
        jbInv.setIcon(new javax.swing.ImageIcon("img//inv.png"));
        jbInv.setToolTipText("inventario [inv]");
        jbInv.setFocusable(false);
        jbInv.setMaximumSize(new java.awt.Dimension(80, 80));
        jbInv.setMinimumSize(new java.awt.Dimension(80, 80));
        jbInv.setName(""); // NOI18N
        jbInv.setPreferredSize(new java.awt.Dimension(80, 80));
        jbInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInvActionPerformed(evt);
            }
        });
        getContentPane().add(jbInv);
        jbInv.setBounds(580, 490, 60, 60);

        jbSend.setBackground(new java.awt.Color(56, 86, 128));
        jbSend.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbSend.setForeground(new java.awt.Color(255, 255, 255));
        jbSend.setText("Invia");
        jbSend.setPreferredSize(new java.awt.Dimension(80, 38));
        jbSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSendActionPerformed(evt);
            }
        });
        getContentPane().add(jbSend);
        jbSend.setBounds(570, 560, 80, 38);

        jspWrite.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jspWrite.setAutoscrolls(true);
        jspWrite.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jspWrite.setMaximumSize(new java.awt.Dimension(500, 40));
        jspWrite.setMinimumSize(new java.awt.Dimension(500, 40));
        jspWrite.setPreferredSize(new java.awt.Dimension(500, 40));

        jtTypingField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtTypingField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jspWrite.setViewportView(jtTypingField);

        getContentPane().add(jspWrite);
        jspWrite.setBounds(43, 548, 520, 65);

        jlImage.setBackground(new java.awt.Color(0, 0, 0));
        jlImage.setIcon(new javax.swing.ImageIcon("img//placeHolder.png"));
        jlImage.setMaximumSize(new java.awt.Dimension(361, 450));
        jlImage.setOpaque(true);
        jlImage.setPreferredSize(new java.awt.Dimension(361, 448));
        getContentPane().add(jlImage);
        jlImage.setBounds(570, 50, 361, 410);

        jtpReadingArea.setEditable(false);
        jtpReadingArea.setBackground(new java.awt.Color(0, 0, 0));
        jtpReadingArea.setForeground(new java.awt.Color(255, 255, 255));
        jtpReadingArea.setMaximumSize(new java.awt.Dimension(900, 450));
        jtpReadingArea.setMinimumSize(new java.awt.Dimension(900, 450));
        jtpReadingArea.setPreferredSize(new java.awt.Dimension(280, 360));
        jspRead2.setViewportView(jtpReadingArea);

        getContentPane().add(jspRead2);
        jspRead2.setBounds(40, 30, 520, 450);

        jlBackground.setIcon(new javax.swing.ImageIcon("img//background232.png"));
        getContentPane().add(jlBackground);
        jlBackground.setBounds(0, 0, 1000, 660);

        jmOptions.setText("Opzioni");
        jmOptions.setToolTipText("");
        jmOptions.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jmiSaveGame.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jmiSaveGame.setText("Salva partita");
        jmiSaveGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSaveGameActionPerformed(evt);
            }
        });
        jmOptions.add(jmiSaveGame);

        jmiBackMenu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jmiBackMenu.setText("Torna al menu principale");
        jmiBackMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBackMenuActionPerformed(evt);
            }
        });
        jmOptions.add(jmiBackMenu);

        jmbOptions.add(jmOptions);

        jmHelp.setText("?");
        jmHelp.setToolTipText("");
        jmHelp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jmiHelp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jmiHelp.setText("Guida...");
        jmHelp.add(jmiHelp);

        jmbOptions.add(jmHelp);

        setJMenuBar(jmbOptions);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void appendToPane(JTextPane tp, String msg, Color c) {
        
        try {

            StyledDocument sDoc = tp.getStyledDocument();
            
            // Aggiungo come attributo il colore desiderato c
            SimpleAttributeSet sAttrSet = new SimpleAttributeSet();
            StyleConstants.setForeground(sAttrSet, c);
            
            // Inserisco la stringa in coda, con gli attributi desiderati
            sDoc.insertString(sDoc.getLength(), msg, sAttrSet);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Errore: " + e.getMessage(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }

    private void jtTypingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTypingFieldActionPerformed
        //Qui l'utente inserisce il suo testo
    }//GEN-LAST:event_jtTypingFieldActionPerformed

    private void jbSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSendActionPerformed

        if (!jtTypingField.getText().isBlank()) {

            String s = jtTypingField.getText();
            appendToPane(jtpReadingArea, "\n> " + s + "\n", new Color(104, 140, 189));

            jtTypingField.setText("");

            appendToPane(jtpReadingArea, "\n" + gInteraction.inputManager(s) + "\n", Color.white);

        }

    }//GEN-LAST:event_jbSendActionPerformed

    private void jbNorthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNorthActionPerformed
        // L'utente si muove verso nord
        appendToPane(jtpReadingArea, "\n" + gInteraction.inputManager("nord") + "\n", Color.white);

    }//GEN-LAST:event_jbNorthActionPerformed

    private void jbSouthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSouthActionPerformed
        // L'utente si muove verso sud
        appendToPane(jtpReadingArea, "\n" + gInteraction.inputManager("sud") + "\n", Color.white);
    }//GEN-LAST:event_jbSouthActionPerformed

    private void jbWestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbWestActionPerformed
        // L'utente si muove verso ovest
        appendToPane(jtpReadingArea, "\n" + gInteraction.inputManager("ovest") + "\n", Color.white);
    }//GEN-LAST:event_jbWestActionPerformed

    private void jbEastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEastActionPerformed
        // L'utente si muove verso est
        appendToPane(jtpReadingArea, "\n" + gInteraction.inputManager("est") + "\n", Color.white);
    }//GEN-LAST:event_jbEastActionPerformed

    private void jbUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpActionPerformed
        // L'utente si muove verso su
        appendToPane(jtpReadingArea, "\n" + gInteraction.inputManager("sali") + "\n", Color.white);
    }//GEN-LAST:event_jbUpActionPerformed

    private void jbDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDownActionPerformed
        // L'utente si muove verso giù
        appendToPane(jtpReadingArea, "\n" + gInteraction.inputManager("scendi") + "\n", Color.white);
    }//GEN-LAST:event_jbDownActionPerformed

    private void jtTypingFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTypingFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jbSend.doClick();
        }
    }//GEN-LAST:event_jtTypingFieldKeyPressed

    private void jmiBackMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBackMenuActionPerformed

        int yesOption;
        yesOption = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler tornare al menu principale?", "Ritorno al menu principale", JOptionPane.YES_NO_OPTION);
        if (yesOption == JOptionPane.YES_OPTION) {
            MenuGUI m = new MenuGUI(gInteraction.getGameManager());
            m.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jmiBackMenuActionPerformed

    private void jmiSaveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaveGameActionPerformed

        JFileChooser fChooser = new JFileChooser();
        fChooser.setMultiSelectionEnabled(false);
        fChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fChooser.setCurrentDirectory(new File("."));

        try {

            if (fChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                gInteraction.getGameManager().getGame().saveGame(fChooser.getSelectedFile().getPath());
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Errore: " + e.getMessage(), "Errore nel salvataggio del file", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            /*???*/
            JOptionPane.showMessageDialog(this, "Errore: " + e.getMessage(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jmiSaveGameActionPerformed

    private void jbInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInvActionPerformed
      InventoryGUI inventory = new InventoryGUI(gInteraction.getGameManager().getGame().getInventory());
      inventory.setVisible(true);
    }//GEN-LAST:event_jbInvActionPerformed

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
                //new GameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbDown;
    private javax.swing.JButton jbEast;
    private javax.swing.JButton jbInv;
    private javax.swing.JButton jbNorth;
    private javax.swing.JButton jbSend;
    private javax.swing.JButton jbSouth;
    private javax.swing.JButton jbUp;
    private javax.swing.JButton jbWest;
    private javax.swing.JLabel jlBackground;
    private javax.swing.JLabel jlCommand;
    private javax.swing.JLabel jlImage;
    private javax.swing.JMenu jmHelp;
    private javax.swing.JMenu jmOptions;
    private javax.swing.JMenuBar jmbOptions;
    private javax.swing.JMenuItem jmiBackMenu;
    private javax.swing.JMenuItem jmiHelp;
    private javax.swing.JMenuItem jmiSaveGame;
    private javax.swing.JPanel jpButtons;
    private javax.swing.JScrollPane jspRead2;
    private javax.swing.JScrollPane jspWrite;
    private javax.swing.JTextField jtTypingField;
    private javax.swing.JTextPane jtpReadingArea;
    // End of variables declaration//GEN-END:variables
}
