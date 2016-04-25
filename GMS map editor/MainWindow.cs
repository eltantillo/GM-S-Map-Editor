using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using GMSMapEditor.Classes;
using GMSMapEditor.ProjectAssets;
using GMSMapEditor.ProjectAssets.Grafico;
using System.Drawing.Drawing2D;

namespace GMSMapEditor
{
    public partial class MainWindow : Form
    {
        int tilePositionXO, tilePositionYO, tilePositionXF, tilePositionYF;
        int mapPositionX, mapPositionY;
        int tileWH;

        private BackgroundTile bt;
        private SimpleRoom sr;
        bool clicked;

        public MainWindow(){
            InitializeComponent();
            splitContainer1.SplitterWidth = 3;
            splitContainer2.SplitterWidth = 3;
            clicked    = false;
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            Project.NewProject();
        }

        private void newProjectToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Project.NewProject();
        }

        private void openProjectToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Project.OpenProject(roomsListBox, tilesListBox);
            tileWH = 32;
            int mapSizeSimple = 32;

            foreach (ProjectAssets.Backgrounds.Background background in Project.assets.backgrounds)
            {
                if (background.istileset){
                    bt = new BackgroundTile(background.image, Project.assets.backgrounds[0].name, tileWH, tileWH);
                    ((BackgroundTile)bt).drawBackgroundTile(tileBox);
                    break;
                }
            }

            sr = new SimpleRoom(mapSizeSimple, mapSizeSimple, tileWH, tileWH);

            mapBox.Location = new Point(0, 0);
            mapBox.Height = mapSizeSimple * tileWH;
            mapBox.Width = mapSizeSimple * tileWH;
        }

        private void saveProjectToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Project.SaveProject();
        }

        private void exitMapEditorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            Project.OpenProject(roomsListBox, tilesListBox);
        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            Project.SaveProject();
        }

        private void toggleProjectFiles_Click(object sender, EventArgs e){
            splitContainer1.Panel2Collapsed = !splitContainer1.Panel2Collapsed;
        }

        private void closeProjectToolStripMenuItem_Click(object sender, EventArgs e){
            /**/
        }

        private void div_left_MouseClick(object sender, MouseEventArgs e){
            if (tileBox.Image != null){
                if (clicked){
                    clicked = false;
                }
                else{
                    // set new start position //
                    tilePositionXO = bt.simplificacion(e.Location.X);
                    tilePositionYO = bt.simplificacion(e.Location.Y);
                    clicked = true;
                    //pb_MouseMove(sender, e);
                    bt.setSelection(new Point(tilePositionXO, tilePositionYO), new Point(tilePositionXO, tilePositionYO));
                }
            }
        }

        private void pb_MouseMove(object sender, MouseEventArgs e){
            if (e.Button == System.Windows.Forms.MouseButtons.Left && tileBox.Image != null){
                Control control = (Control)sender;
                if (control.Capture){
                    control.Capture = false;
                }
                if (control.ClientRectangle.Contains(e.Location)){
                    if (tilePositionXF != (int)Math.Floor((Decimal)e.Location.X / 32)){
                        tileBox.Image = bt.getClonedImage();
                    }
                    if (tilePositionYF != (int)Math.Floor((Decimal)e.Location.Y / 32)){
                        tileBox.Image = bt.getClonedImage();
                    }
                    
                    tilePositionXF = bt.simplificacion(e.Location.X);
                    tilePositionYF = bt.simplificacion(e.Location.Y);

                    bt.setSelection(new Point(tilePositionXO, tilePositionYO), new Point(tilePositionXF, tilePositionYF));

                    tileBox.Image = bt.drawRectangle();
                    tileBox.Refresh();
                    sr.updateSelected(bt.getSelectedImage());
                }
            }
        }



        private void mapBox_Paint(object sender, PaintEventArgs e){
            sr.update(mapBox, mapPositionX, mapPositionY);
        }

        private void mapBox_Click(object sender, EventArgs e){
            sr.click(mapBox, mapPositionX, mapPositionY);
        }

        private void mapBox_MouseMove(object sender, MouseEventArgs e){
            mapPositionX = sr.toGrid(e.Location.X, SimpleRoom.TO_X);
            mapPositionY = sr.toGrid(e.Location.Y, SimpleRoom.TO_Y);
            //roomsList.
        }

        private void roomsList_MouseDoubleClick(object sender, MouseEventArgs e){
            int index = roomsListBox.IndexFromPoint(e.Location);
            if (index != System.Windows.Forms.ListBox.NoMatches){
                MessageBox.Show(Project.assets.rooms[index].ToString());
            }
        }

        private void tilesListBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            foreach (ProjectAssets.Backgrounds.Background background in Project.assets.backgrounds)
            {
                if (background.name == tilesListBox.SelectedItem.ToString())
                {
                    bt = new BackgroundTile(background.image, Project.assets.backgrounds[0].name, tileWH, tileWH);
                    ((BackgroundTile)bt).drawBackgroundTile(tileBox);
                    break;
                }
            }
        }
    }
}
