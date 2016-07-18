/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamapeditor;


import graficos.*;
import java.awt.Point;
import java.awt.event.InputEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author MarcoM
 */
public class Interfaz extends javax.swing.JFrame {
    private int mousePosX,mousePosFinX;
    private int mousePosY,mousePosFinY;

    private int mouseMapPosX,mouseMapPosFinX;
    private int mouseMapPosY,mouseMapPosFinY;
    
    private SimpleRoom currentSimpleRoom;
    private BackgroundTile currentBackground;
    
    //private JLabel seleccion;
    
    public Interfaz() {
        initComponents();
        layersComboBox.requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jSplitPane3 = new javax.swing.JSplitPane();
        jSplitPane4 = new javax.swing.JSplitPane();
        mapScrollPane = new javax.swing.JScrollPane();
        mapPanel = new javax.swing.JPanel();
        backgroundLayer = new javax.swing.JLabel();
        bottomLayers = new javax.swing.JLabel();
        topLayers = new javax.swing.JLabel();
        selection = new javax.swing.JLabel();
        currentLayer = new javax.swing.JLabel();
        leftTabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        tilesCombo = new javax.swing.JComboBox<>();
        tilesScrollPane = new javax.swing.JScrollPane();
        tiles = new javax.swing.JLabel();
        objectsScrollPane = new javax.swing.JScrollPane();
        objectsList = new javax.swing.JList<>();
        mapListScrollPane = new javax.swing.JScrollPane();
        mapList = new javax.swing.JList<>();
        toolBar = new javax.swing.JToolBar();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        jLabel1 = new javax.swing.JLabel();
        tw = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        jLabel2 = new javax.swing.JLabel();
        th = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        showGridButton = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        previewButton = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        layersComboBox = new javax.swing.JComboBox<>();
        layerChangeButton = new javax.swing.JButton();
        layerDeleteButton = new javax.swing.JButton();
        newLayerButton = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newProjectMenu = new javax.swing.JMenuItem();
        openMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        saveAsMenu = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        undoSubMenu = new javax.swing.JMenuItem();
        redoSubMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        resourcesMenu = new javax.swing.JMenu();
        createBackgroundSubMenu = new javax.swing.JMenuItem();
        createRoomSubMenu = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane3.setDividerLocation(700);
        jSplitPane3.setDividerSize(4);
        jSplitPane3.setToolTipText("");
        jSplitPane3.setResizeWeight(1.0f);

        jSplitPane4.setDividerLocation(260);
        jSplitPane4.setDividerSize(4);

        mapScrollPane.setBackground(new java.awt.Color(0, 0, 0));
        mapScrollPane.setBorder(null);

        mapPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mapPanelMouseMoved(evt);
            }
        });

        backgroundLayer.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        backgroundLayer.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        bottomLayers.setBackground(new java.awt.Color(0, 0, 0));
        bottomLayers.setToolTipText("");
        bottomLayers.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bottomLayers.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        bottomLayers.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bottomLayersMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bottomLayersMouseMoved(evt);
            }
        });
        bottomLayers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bottomLayersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bottomLayersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bottomLayersMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bottomLayersMousePressed(evt);
            }
        });

        topLayers.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        topLayers.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        selection.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        selection.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        currentLayer.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        currentLayer.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottomLayers, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
            .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(selection, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
            .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(topLayers, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
            .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mapPanelLayout.createSequentialGroup()
                    .addComponent(backgroundLayer, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mapPanelLayout.createSequentialGroup()
                    .addComponent(currentLayer, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapPanelLayout.createSequentialGroup()
                .addComponent(bottomLayers, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mapPanelLayout.createSequentialGroup()
                    .addComponent(selection, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mapPanelLayout.createSequentialGroup()
                    .addComponent(topLayers, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(backgroundLayer, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
            .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mapPanelLayout.createSequentialGroup()
                    .addComponent(currentLayer, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        mapScrollPane.setViewportView(mapPanel);

        jSplitPane4.setRightComponent(mapScrollPane);

        leftTabs.setBackground(new java.awt.Color(255, 255, 255));

        tilesCombo.setMaximumRowCount(32);
        tilesCombo.setEnabled(false);
        tilesCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tilesComboItemStateChanged(evt);
            }
        });

        tilesScrollPane.setBorder(null);

        tiles.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        tiles.setAlignmentY(0.0F);
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
        tilesScrollPane.setViewportView(tiles);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tilesCombo, 0, 48, Short.MAX_VALUE)
            .addComponent(tilesScrollPane)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(tilesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tilesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
        );

        leftTabs.addTab("Tiles", jPanel2);

        objectsScrollPane.setBorder(null);

        objectsScrollPane.setViewportView(objectsList);

        leftTabs.addTab("Objects", objectsScrollPane);

        jSplitPane4.setLeftComponent(leftTabs);

        jSplitPane3.setLeftComponent(jSplitPane4);

        mapList.setEnabled(false);
        mapList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapListMouseClicked(evt);
            }
        });
        mapListScrollPane.setViewportView(mapList);

        jSplitPane3.setRightComponent(mapListScrollPane);

        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.add(filler2);

        jLabel1.setText("Width:");
        toolBar.add(jLabel1);

        tw.setMaximumSize(new java.awt.Dimension(25, 20));
        tw.setMinimumSize(new java.awt.Dimension(25, 20));
        tw.setPreferredSize(new java.awt.Dimension(25, 20));
        tw.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                twFocusGained(evt);
            }
        });
        toolBar.add(tw);
        tw.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                if (!tw.getText().equals("") && Integer.parseInt(tw.getText())<=0){
                    JOptionPane.showMessageDialog(null,
                        "Error: Please enter number bigger than 0", "Error Massage",
                        JOptionPane.ERROR_MESSAGE);
                }
                else{
                    try{
                        currentSimpleRoom.changeGrid(Integer.parseInt(tw.getText()),Integer.parseInt(th.getText()));
                        currentSimpleRoom.update(bottomLayers, currentLayer,topLayers);
                    }
                    catch(Exception ex){

                    }
                }
            }
        });
        toolBar.add(filler1);

        jLabel2.setText("Height:");
        toolBar.add(jLabel2);

        th.setMaximumSize(new java.awt.Dimension(25, 20));
        th.setMinimumSize(new java.awt.Dimension(25, 20));
        th.setPreferredSize(new java.awt.Dimension(25, 20));
        th.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                thFocusGained(evt);
            }
        });
        toolBar.add(th);
        th.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                if (!th.getText().equals("") && Integer.parseInt(th.getText())<=0){
                    JOptionPane.showMessageDialog(null,
                        "Error: Please enter number bigger than 0", "Error Massage",
                        JOptionPane.ERROR_MESSAGE);
                }
                else{
                    try{
                        currentSimpleRoom.changeGrid(Integer.parseInt(tw.getText()),Integer.parseInt(th.getText()));
                        currentSimpleRoom.update(bottomLayers, currentLayer,topLayers);
                    }
                    catch(Exception ex){

                    }
                }
            }
        });
        toolBar.add(jSeparator3);

        showGridButton.setText("Show Grid");
        showGridButton.setFocusable(false);
        showGridButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        showGridButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        showGridButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGridButtonActionPerformed(evt);
            }
        });
        toolBar.add(showGridButton);
        toolBar.add(jSeparator1);

        previewButton.setText("Preview");
        previewButton.setFocusable(false);
        previewButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewButtonActionPerformed(evt);
            }
        });
        toolBar.add(previewButton);
        toolBar.add(jSeparator2);

        jLabel3.setText("Layer:");
        toolBar.add(jLabel3);

        layersComboBox.setMaximumSize(new java.awt.Dimension(56, 20));
        layersComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                layersComboBoxItemStateChanged(evt);
            }
        });
        toolBar.add(layersComboBox);

        layerChangeButton.setText(" Change");
        layerChangeButton.setFocusable(false);
        layerChangeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        layerChangeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        layerChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layerChangeButtonActionPerformed(evt);
            }
        });
        toolBar.add(layerChangeButton);

        layerDeleteButton.setText("Delete");
        layerDeleteButton.setFocusable(false);
        layerDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        layerDeleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        layerDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layerDeleteButtonActionPerformed(evt);
            }
        });
        toolBar.add(layerDeleteButton);

        newLayerButton.setText("New Layer");
        newLayerButton.setFocusable(false);
        newLayerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newLayerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newLayerButtonActionPerformed(evt);
            }
        });
        toolBar.add(newLayerButton);
        toolBar.add(jSeparator5);

        menuBar.setBackground(new java.awt.Color(255, 255, 255));
        menuBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        menuBar.setDoubleBuffered(true);

        fileMenu.setText("File");

        newProjectMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newProjectMenu.setText("New Project...");
        newProjectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectMenuActionPerformed(evt);
            }
        });
        fileMenu.add(newProjectMenu);

        openMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenu.setText("Open...");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        fileMenu.add(openMenu);

        saveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenu.setText("Save");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenu);

        saveAsMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenu.setText("Save As...");
        saveAsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenu);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        undoSubMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undoSubMenu.setText("Undo");
        undoSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoSubMenuActionPerformed(evt);
            }
        });
        editMenu.add(undoSubMenu);

        redoSubMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        redoSubMenu.setText("Redo");
        redoSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoSubMenuActionPerformed(evt);
            }
        });
        editMenu.add(redoSubMenu);

        menuBar.add(editMenu);

        jMenu2.setText("Temp");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("tempBorrar");
        jMenu2.add(jMenuItem2);

        menuBar.add(jMenu2);

        resourcesMenu.setText("Resources");

        createBackgroundSubMenu.setText("Create Background");
        resourcesMenu.add(createBackgroundSubMenu);

        createRoomSubMenu.setText("Create Room");
        resourcesMenu.add(createRoomSubMenu);

        menuBar.add(resourcesMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveAsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuActionPerformed
        xml.Project.saveProjectAs();
    }//GEN-LAST:event_saveAsMenuActionPerformed

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        currentSimpleRoom.save();
        xml.Project.saveProject();
    }//GEN-LAST:event_saveMenuActionPerformed

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed
        xml.Project.openProject();
        
        int number = 0;
        for (int i = 0; i < xml.Project.assets.backgrounds.size(); i++) {
            if (xml.Project.assets.backgrounds.get(i).istileset){
                number = i;
                break;
            }
        }
        
        currentBackground = new BackgroundTile(xml.Project.assets.backgrounds.get(number));
        currentBackground.drawBackgroundTile(tiles);
        currentBackground.setSelection(new Point(0,0), new Point(0,0));
        
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        
        for(xml.projectAssets.backgrounds.Background bb :xml.Project.assets.backgrounds){
            if(bb.istileset){
                dcbm.addElement(bb.name);
            }
        }
        
        tilesCombo.setModel(dcbm);
        tilesCombo.setEnabled(true);
        
        for(xml.projectAssets.backgrounds.Background bb : xml.Project.assets.backgrounds){
            xml.Project.assets.backgroundT.add(new BackgroundTile(bb));
        }
        
        currentSimpleRoom = new SimpleRoom(xml.Project.assets.rooms.get(0));
        currentSimpleRoom.update(bottomLayers, currentLayer,topLayers);
        
        String[] i = new String[xml.Project.assets.rooms.size()];
        for(xml.projectAssets.rooms.Room r : xml.Project.assets.rooms){
            i[xml.Project.assets.rooms.indexOf(r)] = r.name;
        }
        
        mapList.setListData(i);
        mapList.setEnabled(true);
        
        dcbm = new DefaultComboBoxModel();
        
        for(String s : currentSimpleRoom.getDephts())
            dcbm.addElement(s);
        
        layersComboBox.setModel(dcbm);
        
        tw.setText(String.valueOf(currentBackground.getTW()));
        th.setText(String.valueOf(currentBackground.getTH()));
        
        mapPanel.setComponentZOrder(backgroundLayer, 4);
        mapPanel.setComponentZOrder(bottomLayers, 3);
        mapPanel.setComponentZOrder(currentLayer, 2);
        mapPanel.setComponentZOrder(selection, 1);
        
        currentSimpleRoom.drawBackground(backgroundLayer);
    }//GEN-LAST:event_openMenuActionPerformed

    private void newProjectMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectMenuActionPerformed
        xml.Project.newProject();
    }//GEN-LAST:event_newProjectMenuActionPerformed

    private void bottomLayersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bottomLayersMousePressed
        mouseMapPosX = evt.getX();
        mouseMapPosY = evt.getY();
    }//GEN-LAST:event_bottomLayersMousePressed

    private void bottomLayersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bottomLayersMouseClicked
        if(evt.getButton() == 3){
            if((evt.getModifiers() & InputEvent.CTRL_MASK) == InputEvent.CTRL_MASK)
                currentSimpleRoom.eraseTile(evt.getX(), evt.getY());
            else
                currentSimpleRoom.setSelection(new Point(evt.getX(),evt.getY()), new Point(evt.getX(),evt.getY()));
            currentSimpleRoom.updateCurrent(currentLayer);
        }
        else
            currentSimpleRoom.click(currentLayer, evt.getX(), evt.getY());
    }//GEN-LAST:event_bottomLayersMouseClicked

    private void bottomLayersMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bottomLayersMouseMoved
        if(currentSimpleRoom != null)
            currentSimpleRoom.updateSelection(selection,evt.getX(),evt.getY());
    }//GEN-LAST:event_bottomLayersMouseMoved

    private void bottomLayersMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bottomLayersMouseDragged
        if(SwingUtilities.isRightMouseButton(evt)){
            if((evt.getModifiers() & InputEvent.CTRL_MASK) == InputEvent.CTRL_MASK){
                currentSimpleRoom.eraseTile(evt.getX(), evt.getY());
            }
            else{
                mouseMapPosFinX = evt.getX();
                mouseMapPosFinY = evt.getY();
                currentSimpleRoom.setSelection(new Point(mouseMapPosX,mouseMapPosY), new Point(mouseMapPosFinX,mouseMapPosFinY));
            }
            currentSimpleRoom.updateCurrent(currentLayer);
        }
        else{
            currentSimpleRoom.click(currentLayer, evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_bottomLayersMouseDragged

    private void mapListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapListMouseClicked
        if(evt.getClickCount()==2){
            currentSimpleRoom = new SimpleRoom(xml.Project.assets.rooms.get(mapList.getSelectedIndex()));
            currentSimpleRoom.update(bottomLayers, currentLayer, topLayers);
            currentSimpleRoom.changeGrid(currentBackground.getTW(), currentBackground.getTH());
            
            DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        
            for(String s : currentSimpleRoom.getDephts())
                dcbm.addElement(s);

            layersComboBox.setModel(dcbm);
            showGridButton.setSelected(false);
            previewButton.setSelected(false);
            currentSimpleRoom.drawBackground(backgroundLayer);
        }
    }//GEN-LAST:event_mapListMouseClicked

    private void tilesComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tilesComboItemStateChanged
        String name = String.valueOf(tilesCombo.getSelectedItem());
        int number = 0;
        for (int i = 0; i < xml.Project.assets.backgrounds.size(); i++) {
            if (xml.Project.assets.backgrounds.get(i).name.equals(name)){
                number = i;
            }
        }
        
        currentBackground = new BackgroundTile(xml.Project.assets.backgrounds.get(number));
        currentBackground.setSelection(new Point(0,0), new Point(0,0));
        currentSimpleRoom.changeGrid(currentBackground.getTW(), currentBackground.getTH());
        currentBackground.drawBackgroundTile(tiles);
        currentSimpleRoom.update(bottomLayers, currentLayer, topLayers);
        
        tw.setText(String.valueOf(currentBackground.getTW()));
        th.setText(String.valueOf(currentBackground.getTH()));
    }//GEN-LAST:event_tilesComboItemStateChanged

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
    }//GEN-LAST:event_tilesMouseDragged

    private void previewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewButtonActionPerformed
        currentSimpleRoom.topLayer();
        currentSimpleRoom.update(bottomLayers,currentLayer ,topLayers);
    }//GEN-LAST:event_previewButtonActionPerformed

    private void layersComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_layersComboBoxItemStateChanged
        try{
            currentSimpleRoom.changeLayer(Integer.parseInt(layersComboBox.getSelectedItem().toString()));
            currentSimpleRoom.update(bottomLayers,currentLayer, topLayers);
        }
        catch(Exception ex){
            System.out.println("layersComboBoxStarteChanged.exeption: "+ex);
        }
    }//GEN-LAST:event_layersComboBoxItemStateChanged

    private void showGridButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGridButtonActionPerformed
        currentSimpleRoom.grid();
        currentSimpleRoom.update(bottomLayers, currentLayer,topLayers);
    }//GEN-LAST:event_showGridButtonActionPerformed

    private void twFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_twFocusGained
        // TODO add your handling code here:
        tw.setText("");
    }//GEN-LAST:event_twFocusGained

    private void thFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_thFocusGained
        // TODO add your handling code here:
        th.setText("");
    }//GEN-LAST:event_thFocusGained

    private void newLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newLayerButtonActionPerformed
        try{
            Integer depth = Integer.valueOf(JOptionPane.showInputDialog("Enter a depth value for the new layer: "));
            currentSimpleRoom.changeLayer(depth);
            DefaultComboBoxModel dcbm = new DefaultComboBoxModel();

            for(String s : currentSimpleRoom.getDephts())
            dcbm.addElement(s);

            layersComboBox.setModel(dcbm);
            layersComboBox.setSelectedItem(depth.toString());
            currentSimpleRoom.update(bottomLayers, currentLayer,topLayers);
        }
        catch(Exception ex){
            System.out.println("newLayerActionPerformed.exeption: "+ex);
        }
    }//GEN-LAST:event_newLayerButtonActionPerformed

    private void layerDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layerDeleteButtonActionPerformed
        // TODO add your handling code here:
        currentSimpleRoom.removeLayer(Integer.valueOf((String)layersComboBox.getSelectedItem()));
        
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for(String s : currentSimpleRoom.getDephts())
            dcbm.addElement(s);
        
        layersComboBox.setModel(dcbm);
        currentSimpleRoom.update(bottomLayers, currentLayer,topLayers);
    }//GEN-LAST:event_layerDeleteButtonActionPerformed

    private void undoSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoSubMenuActionPerformed
        currentSimpleRoom.undo();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for(String s : currentSimpleRoom.getDephts())
            dcbm.addElement(s);
        
        layersComboBox.setModel(dcbm);
        currentSimpleRoom.update(bottomLayers, currentLayer,topLayers);
    }//GEN-LAST:event_undoSubMenuActionPerformed

    private void redoSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoSubMenuActionPerformed
        currentSimpleRoom.redo();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for(String s : currentSimpleRoom.getDephts())
            dcbm.addElement(s);
        
        layersComboBox.setModel(dcbm);
        currentSimpleRoom.update(bottomLayers, currentLayer,topLayers);
    }//GEN-LAST:event_redoSubMenuActionPerformed

    private void bottomLayersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bottomLayersMouseEntered
        if(currentSimpleRoom !=null)
            currentSimpleRoom.showSelection(true);
    }//GEN-LAST:event_bottomLayersMouseEntered

    private void bottomLayersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bottomLayersMouseExited
        if(currentSimpleRoom !=null)
            currentSimpleRoom.showSelection(false);
    }//GEN-LAST:event_bottomLayersMouseExited

    private void mapPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapPanelMouseMoved

    }//GEN-LAST:event_mapPanelMouseMoved

    private void layerChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        try{
            Integer newDepth = Integer.valueOf(JOptionPane.showInputDialog("Enter a depth value to move the layer to: "));
            Integer curDepth = Integer.valueOf((String)layersComboBox.getSelectedItem());
            
            System.out.println(curDepth + " " + newDepth);
            
            currentSimpleRoom.changeLayer(curDepth, newDepth);

            DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
            for(String s : currentSimpleRoom.getDephts())
            dcbm.addElement(s);

            layersComboBox.setModel(dcbm);
            layersComboBox.setSelectedItem(newDepth.toString());
            currentSimpleRoom.update(bottomLayers, currentLayer,topLayers);
        }
        catch(Exception e){
            System.out.println("Exception: "+e);
        }
    }                                                  
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
    private javax.swing.JLabel backgroundLayer;
    private javax.swing.JLabel bottomLayers;
    private javax.swing.JMenuItem createBackgroundSubMenu;
    private javax.swing.JMenuItem createRoomSubMenu;
    private javax.swing.JLabel currentLayer;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JButton layerChangeButton;
    private javax.swing.JButton layerDeleteButton;
    private javax.swing.JComboBox<String> layersComboBox;
    private javax.swing.JTabbedPane leftTabs;
    private javax.swing.JList<String> mapList;
    private javax.swing.JScrollPane mapListScrollPane;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JScrollPane mapScrollPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton newLayerButton;
    private javax.swing.JMenuItem newProjectMenu;
    private javax.swing.JList<String> objectsList;
    private javax.swing.JScrollPane objectsScrollPane;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JToggleButton previewButton;
    private javax.swing.JMenuItem redoSubMenu;
    private javax.swing.JMenu resourcesMenu;
    private javax.swing.JMenuItem saveAsMenu;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JLabel selection;
    private javax.swing.JToggleButton showGridButton;
    private javax.swing.JTextField th;
    private javax.swing.JLabel tiles;
    private javax.swing.JComboBox<String> tilesCombo;
    private javax.swing.JScrollPane tilesScrollPane;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JLabel topLayers;
    private javax.swing.JTextField tw;
    private javax.swing.JMenuItem undoSubMenu;
    // End of variables declaration//GEN-END:variables
}
