/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamapeditor;

import graficos.BackgroundTile;
import graficos.ImageTools;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FileUtils;
import xml.projectAssets.backgrounds.Background;
import xml.projectAssets.rooms.Room;

/**
 *
 * @author eltan
 */
public class BackgroundWindow extends javax.swing.JFrame {

    Interfaz mainWindow;
    Integer number = xml.Project.assets.backgrounds.size();
    Boolean newBackground = true;
    String imageURI = "";
    BufferedImage image;
    
    public BackgroundWindow(Interfaz caller) {
        initComponents();
        mainWindow = caller;
        name.setText("background" + (number));
        
        tileOptions(false);
    }
    
    public BackgroundWindow(Interfaz caller, String bgName) {
        newBackground = false;
        initComponents();
        mainWindow = caller;
        
        for (int i = 0; i < xml.Project.assets.backgrounds.size(); i++) {
            if (xml.Project.assets.backgrounds.get(i).name.equals(bgName)){
                number = i;
            }
        }
        
        Background background = xml.Project.assets.backgrounds.get(number);
        
        image = background.image;
         backgroundImage.setIcon(new ImageIcon(image));
        name.setText(background.name);
        istileset.setSelected(background.istileset);
        tilewidth.setText(String.valueOf(background.tilewidth));
        tileheight.setText(String.valueOf(background.tileheight));
        tilexoff.setText(String.valueOf(background.tilexoff));
        tileyoff.setText(String.valueOf(background.tileyoff));
        tilehsep.setText(String.valueOf(background.tilehsep));
        tilevsep.setText(String.valueOf(background.tilevsep));
        
        tileOptions(istileset.isSelected());
    }
    
    private void tileOptions(Boolean value){
        jLabel2.setVisible(value);
        jLabel3.setVisible(value);
        jLabel4.setVisible(value);
        jLabel5.setVisible(value);
        jLabel6.setVisible(value);
        jLabel7.setVisible(value);
        
        tilewidth.setVisible(value);
        tileheight.setVisible(value);
        tilexoff.setVisible(value);
        tileyoff.setVisible(value);
        tilehsep.setVisible(value);
        tilevsep.setVisible(value);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        backgroundImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        istileset = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        tilewidth = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tileheight = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tilexoff = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tileyoff = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tilehsep = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tilevsep = new javax.swing.JTextField();
        accept = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(backgroundImage);

        jLabel1.setText("Name:");

        name.setText("background0");

        istileset.setText("Use as Tile Set");
        istileset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                istilesetActionPerformed(evt);
            }
        });

        jLabel2.setText("Tile Width:");

        tilewidth.setText("32");
        tilewidth.setMaximumSize(new java.awt.Dimension(36, 20));
        tilewidth.setMinimumSize(new java.awt.Dimension(36, 20));

        jLabel3.setText("Tile Height:");

        tileheight.setText("32");
        tileheight.setMaximumSize(new java.awt.Dimension(36, 20));
        tileheight.setMinimumSize(new java.awt.Dimension(36, 20));

        jLabel4.setText("Horizontal Offset:");

        tilexoff.setText("0");
        tilexoff.setMaximumSize(new java.awt.Dimension(36, 20));
        tilexoff.setMinimumSize(new java.awt.Dimension(36, 20));

        jLabel5.setText("Vertical Offset:");

        tileyoff.setText("0");
        tileyoff.setMaximumSize(new java.awt.Dimension(36, 20));
        tileyoff.setMinimumSize(new java.awt.Dimension(36, 20));

        jLabel6.setText("Horizontal Sep:");

        tilehsep.setText("0");
        tilehsep.setMaximumSize(new java.awt.Dimension(36, 20));
        tilehsep.setMinimumSize(new java.awt.Dimension(36, 20));

        jLabel7.setText("Vertical Sep:");

        tilevsep.setText("0");
        tilevsep.setMaximumSize(new java.awt.Dimension(36, 20));
        tilevsep.setMinimumSize(new java.awt.Dimension(36, 20));

        accept.setText("Accept");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        loadButton.setText("Load Background Image");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tilewidth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tileheight, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(istileset, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tileyoff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tilevsep, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tilehsep, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tilexoff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(accept)
                        .addGap(18, 18, 18)
                        .addComponent(cancel))
                    .addComponent(loadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(istileset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tilewidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tileheight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tilexoff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tileyoff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tilehsep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tilevsep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accept)
                    .addComponent(cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        if (image != null){//(!imageURI.equals("")){
            xml.projectAssets.backgrounds.Background background;
            if (newBackground){
                background = new xml.projectAssets.backgrounds.Background();
                xml.Project.assets.backgrounds.add(background);
            }
            else{
                background = xml.Project.assets.backgrounds.get(number);
            }

            background.name = name.getText();
            background.data = "images\\" + background.name + ".png";
            background.istileset = istileset.isSelected();
            
            background.tilewidth = Integer.valueOf(tilewidth.getText());
            background.tileheight = Integer.valueOf(tileheight.getText());
            background.tilexoff = Integer.valueOf(tilexoff.getText());
            background.tileyoff = Integer.valueOf(tileyoff.getText());
            background.tilehsep = Integer.valueOf(tilehsep.getText());
            background.tilevsep = Integer.valueOf(tilevsep.getText());
            
            background.width = 960;
            background.height = 544;
            
            if (!imageURI.equals("")){
                try {
                    File source = new File(imageURI);
                    File dest   = new File(xml.Project.projectFolder + "background\\" + background.data);
                    FileUtils.copyFile(source, dest);

                    background.image = ImageIO.read(new File(xml.Project.projectFolder + "background\\" + background.data));
                }
                catch (IOException ex) {
                    Logger.getLogger(BackgroundWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (newBackground && background.istileset){
                mainWindow.currentBackground = new BackgroundTile(xml.Project.assets.backgrounds.get(number));
                mainWindow.currentBackground.drawBackgroundTile(mainWindow.tiles);
                mainWindow.currentBackground.setSelection(new Point(0,0), new Point(0,0));

                DefaultComboBoxModel dcbm = new DefaultComboBoxModel();

                number = 0;
                for(xml.projectAssets.backgrounds.Background bb :xml.Project.assets.backgrounds){
                    if(bb.istileset){
                        dcbm.addElement(bb.name);
                        number++;
                    }
                }
                
                mainWindow.tilesCombo.setModel(dcbm);
                mainWindow.tilesCombo.setEnabled(true);
                mainWindow.tilesCombo.setSelectedIndex(number - 1);
                
                xml.Project.assets.backgroundT.add(new BackgroundTile(background));
                
            }
            dispose();
        }
    }//GEN-LAST:event_acceptActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        /*FileNameExtensionFilter filter = new FileNameExtensionFilter("GameMaker: Studio Project Files", "gmx");
        fileChooser.setFileFilter(filter);*/
        int returnVal = fileChooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            
            imageURI = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println(imageURI);
            try {
                image = ImageIO.read(new File(imageURI));
                backgroundImage.setIcon(new ImageIcon(image));
            }
            catch (IOException ex) {
                Logger.getLogger(BackgroundWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_loadButtonActionPerformed

    private void istilesetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_istilesetActionPerformed
        // TODO add your handling code here:
        tileOptions(istileset.isSelected());
    }//GEN-LAST:event_istilesetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JButton cancel;
    private javax.swing.JCheckBox istileset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadButton;
    private javax.swing.JTextField name;
    private javax.swing.JTextField tileheight;
    private javax.swing.JTextField tilehsep;
    private javax.swing.JTextField tilevsep;
    private javax.swing.JTextField tilewidth;
    private javax.swing.JTextField tilexoff;
    private javax.swing.JTextField tileyoff;
    // End of variables declaration//GEN-END:variables
}
