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
        bool clicked;
        int roomIndex;
        int backgroundIndex;

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
            //int mapSizeSimple = 32;
            /*foreach (ProjectAssets.Backgrounds.Background background in Project.assets.backgrounds)
            {
                if (background.istileset){
                    bt = new BackgroundTile(background.image, Project.assets.backgrounds[0].name, tileWH, tileWH);
                    ((BackgroundTile)bt).drawBackgroundTile(tileBox);
                    break;
                }
            }*/

            //sr = new SimpleRoom(mapSizeSimple, mapSizeSimple, tileWH, tileWH);
            Project.bts[0].drawBackgroundTile(tileBox);

            mapBox.Location = new Point(0, 0);
            mapBox.Height = Project.srs[roomIndex].h;
            mapBox.Width = Project.srs[roomIndex].w;
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
                    tilePositionXO = Project.bts[backgroundIndex].toGrid(e.Location.X, 1);
                    tilePositionYO = Project.bts[backgroundIndex].toGrid(e.Location.Y, 2);
                    clicked = true;
                    //pb_MouseMove(sender, e);
                    Project.bts[backgroundIndex].setSelection(new Point(tilePositionXO, tilePositionYO), new Point(tilePositionXO, tilePositionYO));
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
                    if (tilePositionXF != Project.bts[backgroundIndex].toGrid(e.Location.X, 1)){
                        tileBox.Image = Project.bts[backgroundIndex].getClonedImage();
                    }
                    if (tilePositionYF != Project.bts[backgroundIndex].toGrid(e.Location.Y, 2)){
                        tileBox.Image = Project.bts[backgroundIndex].getClonedImage();
                    }
                    tilePositionXF = Project.bts[backgroundIndex].toGrid(e.Location.X,1);
                    tilePositionYF = Project.bts[backgroundIndex].toGrid(e.Location.Y,2);

                    Project.bts[backgroundIndex].setSelection(new Point(tilePositionXO, tilePositionYO), new Point(tilePositionXF, tilePositionYF));

                    tileBox.Image = Project.bts[backgroundIndex].drawRectangle();
                    tileBox.Refresh();
                    Project.srs[roomIndex].updateSelected(Project.bts[backgroundIndex].getSelectedImage());
                }
            }
        }



        private void mapBox_Paint(object sender, PaintEventArgs e){
            Project.srs[roomIndex].update(mapBox, mapPositionX, mapPositionY);
        }

        private void mapBox_Click(object sender, EventArgs e){
            Project.srs[roomIndex].click(mapBox, mapPositionX, mapPositionY);
        }

        private void mapBox_MouseMove(object sender, MouseEventArgs e){
            mapPositionX = Project.srs[roomIndex].toGrid(e.Location.X, SimpleRoom.TO_X);
            mapPositionY = Project.srs[roomIndex].toGrid(e.Location.Y, SimpleRoom.TO_Y);
            if (e.Button == System.Windows.Forms.MouseButtons.Left && tileBox.Image != null)
            {
                Control control = (Control)sender;
                if (control.Capture)
                {
                    control.Capture = false;
                }
                if (control.ClientRectangle.Contains(e.Location)){
                    Project.srs[roomIndex].click(mapBox, mapPositionX, mapPositionY);
                }
            }
        }

        private void roomsList_MouseDoubleClick(object sender, MouseEventArgs e){
            roomIndex = roomsListBox.IndexFromPoint(e.Location);
            if (roomIndex != System.Windows.Forms.ListBox.NoMatches){
                //MessageBox.Show(Project.assets.rooms[index].ToString()); joto el que lo descomente.
                //sr = new SimpleRoom((Project.assets.rooms[index].width / Project.assets.rooms[index].tiles[0].w), (Project.assets.rooms[index].height / Project.assets.rooms[index].tiles[0].h), Project.assets.rooms[index].tiles[0].w, Project.assets.rooms[index].tiles[0].h);
                //sr.roomIni(Project.assets.rooms[index].tiles,Project.assets.backgrounds,mapBox);
                
            }
        }

        private void tilesListBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                backgroundIndex = tilesListBox.SelectedIndex;
                if (backgroundIndex < 0)
                {
                    backgroundIndex = 0;
                }
                Project.bts[backgroundIndex].drawBackgroundTile(tileBox);
            }
            catch (Exception ex) { }
            /* foreach (BackgroundTile background in Project.bts){
                if (background.backgroundName == tilesListBox.SelectedItem.ToString()){

                    /*
                    bt = new BackgroundTile(background.image, Project.assets.backgrounds[0].name, tileWH, tileWH);
                    ((BackgroundTile)bt).drawBackgroundTile(tileBox);

                    break;
                }
            }*/
        }
    }
}
