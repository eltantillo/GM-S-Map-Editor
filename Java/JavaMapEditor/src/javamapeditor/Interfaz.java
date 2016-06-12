/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamapeditor;


import graficos.*;
import java.awt.Point;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author MarcoM
 */
public class Interfaz extends javax.swing.JFrame {
    private int mousePosX,mousePosFinX;
    private int mousePosY,mousePosFinY;

    private int mouseMapPosX,mouseMapPosFinX;
    private int mouseMapPosY,mouseMapPosFinY;
    
    private boolean dragClick;
    private boolean rectangle;
    
    private SimpleRoom currentSimpleRoom;
    private BackgroundTile currentBackground;
    
    private boolean mouseEnter;
    
    //private JLabel seleccion;
    
    public Interfaz() {
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

        jMenu4 = new javax.swing.JMenu();
        jSplitPane3 = new javax.swing.JSplitPane();
        jSplitPane4 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tiles = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        map = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        maps = new javax.swing.JList<>();
        jToolBar2 = new javax.swing.JToolBar();
        tw = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        th = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        showGrid = new javax.swing.JToggleButton();
        tilesCombo = new javax.swing.JComboBox<>();
        dephs = new javax.swing.JComboBox<>();
        button1 = new java.awt.Button();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newProjectMenu = new javax.swing.JMenuItem();
        openMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        saveAsMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        tileset1 = new javax.swing.JMenuItem();
        tileset2 = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane3.setDividerLocation(250);
        jSplitPane3.setDividerSize(4);
        jSplitPane3.setToolTipText("");

        jSplitPane4.setDividerLocation(200);
        jSplitPane4.setDividerSize(4);

        tiles.setText("tiles");
        tiles.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        tiles.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tilesMouseDragged(evt);
            }
        });
        tiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tilesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tilesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tiles);

        jSplitPane4.setLeftComponent(jScrollPane1);

        map.setText("map");
        map.setToolTipText("");
        map.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        map.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mapMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mapMouseMoved(evt);
            }
        });
        map.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mapMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(map);

        jSplitPane4.setRightComponent(jScrollPane2);

        jSplitPane3.setLeftComponent(jSplitPane4);

        maps.setEnabled(false);
        maps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(maps);

        jSplitPane3.setRightComponent(jScrollPane3);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        tw.setText("width");
        tw.setMaximumSize(new java.awt.Dimension(10, 20));
        tw.setMinimumSize(new java.awt.Dimension(10, 20));
        jToolBar2.add(tw);
        jToolBar2.add(jSeparator2);

        th.setText("height");
        th.setMaximumSize(new java.awt.Dimension(10, 20));
        th.setMinimumSize(new java.awt.Dimension(10, 20));
        jToolBar2.add(th);
        jToolBar2.add(jSeparator1);

        jButton1.setText("Go");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton1);
        jToolBar2.add(jSeparator3);

        showGrid.setText("Grid: ON");
        showGrid.setFocusable(false);
        showGrid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        showGrid.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        showGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGridActionPerformed(evt);
            }
        });
        jToolBar2.add(showGrid);

        tilesCombo.setEnabled(false);
        tilesCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tilesComboItemStateChanged(evt);
            }
        });
        jToolBar2.add(tilesCombo);

        dephs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dephs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dephsItemStateChanged(evt);
            }
        });
        jToolBar2.add(dephs);

        button1.setLabel("Layer");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jToolBar2.add(button1);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuBar1.setDoubleBuffered(true);

        fileMenu.setText("File");

        newProjectMenu.setText("New Project...");
        newProjectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectMenuActionPerformed(evt);
            }
        });
        fileMenu.add(newProjectMenu);

        openMenu.setText("Open...");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        fileMenu.add(openMenu);

        saveMenu.setText("Save");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenu);

        saveAsMenu.setText("Save As...");
        saveAsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenu);

        jMenuBar1.add(fileMenu);

        jMenu3.setText("TileSet");

        tileset1.setText("TileSet1");
        tileset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileset1ActionPerformed(evt);
            }
        });
        jMenu3.add(tileset1);

        tileset2.setText("TileSet2");
        tileset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileset2ActionPerformed(evt);
            }
        });
        jMenu3.add(tileset2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tileset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tileset1ActionPerformed
        // nada xD
    }//GEN-LAST:event_tileset1ActionPerformed

    private void tileset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tileset2ActionPerformed
        // nada xD
    }//GEN-LAST:event_tileset2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            currentSimpleRoom.changeGrid(Integer.parseInt(tw.getText()),Integer.parseInt(th.getText()));
        }
        catch(Exception ex){
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void showGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGridActionPerformed
        currentSimpleRoom.grid();
    }//GEN-LAST:event_showGridActionPerformed

    private void saveAsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuActionPerformed
        xml.Project.saveProjectAs();
    }//GEN-LAST:event_saveAsMenuActionPerformed

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        xml.Project.saveProject();
    }//GEN-LAST:event_saveMenuActionPerformed

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed
        xml.Project.openProject();
        currentBackground = new BackgroundTile(xml.Project.assets.backgrounds.get(0));
        currentBackground.drawBackgroundTile(tiles);
        currentBackground.setSelection(new Point(0,0), new Point(0,0));
        
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        
        for(xml.projectAssets.backgrounds.Background bb :xml.Project.assets.backgrounds){
            dcbm.addElement(bb.name);
        }
        tilesCombo.setModel(dcbm);
        
        tilesCombo.setEnabled(true);
        
        for(xml.projectAssets.backgrounds.Background bb : xml.Project.assets.backgrounds){
            xml.Project.assets.backgroundT.add(new BackgroundTile(bb));
        }
        
        currentSimpleRoom = new SimpleRoom(xml.Project.assets.rooms.get(0));
        currentSimpleRoom.update(map, 0, 0);
        
        String[] i = new String[xml.Project.assets.rooms.size()];
        for(xml.projectAssets.rooms.Room r : xml.Project.assets.rooms){
            i[xml.Project.assets.rooms.indexOf(r)] = r.name;
        }
        
        maps.setListData(i);
        maps.setEnabled(true);
        
        dcbm = new DefaultComboBoxModel();
        
        for(String s : currentSimpleRoom.getDephts())
            dcbm.addElement(s);
        
        dephs.setModel(dcbm);
        
    }//GEN-LAST:event_openMenuActionPerformed

    private void newProjectMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectMenuActionPerformed
        xml.Project.newProject();
    }//GEN-LAST:event_newProjectMenuActionPerformed

    private void tilesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilesMouseReleased
        mousePosFinX = evt.getX();
        mousePosFinY = evt.getY();
        currentBackground.setSelection(new Point(mousePosX,mousePosY), new Point(mousePosFinX,mousePosFinY));
        currentBackground.drawBackgroundTile(tiles);
    }//GEN-LAST:event_tilesMouseReleased

    private void tilesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilesMousePressed
        mousePosX = evt.getX();
        mousePosY = evt.getY();
    }//GEN-LAST:event_tilesMousePressed

    private void tilesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tilesMouseDragged
        mousePosFinX = evt.getX();
        mousePosFinY = evt.getY();
        currentBackground.setSelection(new Point(mousePosX,mousePosY), new Point(mousePosFinX,mousePosFinY));
        currentBackground.drawBackgroundTile(tiles);
        currentSimpleRoom.update(map, 0, 0);
    }//GEN-LAST:event_tilesMouseDragged

    private void mapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapMousePressed
        mouseMapPosX = evt.getX();
        mouseMapPosY = evt.getY();
    }//GEN-LAST:event_mapMousePressed

    private void mapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapMouseClicked
        if(evt.getButton() == 3){
            currentSimpleRoom.setSelection(new Point(evt.getX(),evt.getY()), new Point(evt.getX(),evt.getY()));
            currentSimpleRoom.update(map, evt.getX(), evt.getY());
        }
        else
        currentSimpleRoom.click(map, evt.getX(), evt.getY());
    }//GEN-LAST:event_mapMouseClicked

    private void mapMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapMouseMoved
        if(currentSimpleRoom !=null)
            currentSimpleRoom.update(map, evt.getX(), evt.getY());
    }//GEN-LAST:event_mapMouseMoved

    private void mapMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapMouseDragged
        if(SwingUtilities.isRightMouseButton(evt)){
            mouseMapPosFinX = evt.getX();
            mouseMapPosFinY = evt.getY();
            currentSimpleRoom.setSelection(new Point(mouseMapPosX,mouseMapPosY), new Point(mouseMapPosFinX,mouseMapPosFinY));
            currentSimpleRoom.update(map, evt.getX(), evt.getY());
        }
        else{
            currentSimpleRoom.click(map, evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_mapMouseDragged

    private void mapsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapsMouseClicked
        if(evt.getClickCount()==2){
            currentSimpleRoom = new SimpleRoom(xml.Project.assets.rooms.get(maps.getSelectedIndex()));
            currentSimpleRoom.update(map, 0, 0);
            currentSimpleRoom.changeGrid(currentBackground.getTW(), currentBackground.getTH());
        }
    }//GEN-LAST:event_mapsMouseClicked

    private void tilesComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tilesComboItemStateChanged
        currentBackground = new BackgroundTile(xml.Project.assets.backgrounds.get(tilesCombo.getSelectedIndex()));
        currentBackground.setSelection(new Point(0,0), new Point(0,0));
        currentSimpleRoom.changeGrid(currentBackground.getTW(), currentBackground.getTH());
        currentBackground.drawBackgroundTile(tiles);
        currentSimpleRoom.update(map, 0, 0);
    }//GEN-LAST:event_tilesComboItemStateChanged

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        try{
            currentSimpleRoom.changeLayer(Integer.parseInt(tw.getText()));
        }
        catch(Exception ex){

        }
    }//GEN-LAST:event_button1ActionPerformed

    private void dephsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dephsItemStateChanged
        try{
            currentSimpleRoom.changeLayer(Integer.parseInt(dephs.getSelectedItem().toString()));
        }
        catch(Exception ex){
            
        }
    }//GEN-LAST:event_dephsItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try { 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Interfaz frame = new Interfaz();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JComboBox<String> dephs;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel map;
    private javax.swing.JList<String> maps;
    private javax.swing.JMenuItem newProjectMenu;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JMenuItem saveAsMenu;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JToggleButton showGrid;
    private javax.swing.JTextField th;
    private javax.swing.JLabel tiles;
    private javax.swing.JComboBox<String> tilesCombo;
    private javax.swing.JMenuItem tileset1;
    private javax.swing.JMenuItem tileset2;
    private javax.swing.JTextField tw;
    // End of variables declaration//GEN-END:variables
}
