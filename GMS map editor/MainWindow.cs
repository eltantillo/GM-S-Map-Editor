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
        Bitmap canvas;

        public MainWindow()
        {
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
            Project.OpenProject();
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
            Project.OpenProject();
        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            Project.SaveProject();
        }

        private void toggleProjectFiles_Click(object sender, EventArgs e)
        {
            splitContainer1.Panel2Collapsed = !splitContainer1.Panel2Collapsed;
        }

        private void closeProjectToolStripMenuItem_Click(object sender, EventArgs e){
            tileWH = 32; // tileWH = width and height of tile in pixel //
            int mapSizeSimple = 100; // mapSizeSimple = size in pixel / tileWH //
            
            //Simple file chooser//
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            openFileDialog1.ShowDialog();

            //ini backgroundTile//
            // constructor = FILE(IMG), tile width in pixel, tile height in pixel;
            bt = new BackgroundTile(openFileDialog1.FileName, tileWH, tileWH);
            
            //draw background tile reference of PictureBox;
            ((BackgroundTile)bt).drawBackgroundTile(tileBox);

            //ini SimpleRoom
            // constructor = width in simple mode, height in simple mode, tile width in pixel,tile height in pixel
            sr = new SimpleRoom(mapSizeSimple, mapSizeSimple, tileWH, tileWH);

            // ini mapBox //
            mapBox.Location = new Point(0, 0);
            // set map size height //
            mapBox.Height = mapSizeSimple * tileWH;
            // set map size width //
            mapBox.Width = mapSizeSimple * tileWH;
            
            // Bitmap to draw all graphics //
            canvas = new Bitmap((mapSizeSimple * tileWH) + 1, (mapSizeSimple * tileWH) + 1);
        }

        private void div_left_MouseClick(object sender, MouseEventArgs e){
            // click event //
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
                // some stuff idk //
                Control control = (Control)sender;
                if (control.Capture){
                    control.Capture = false;
                }
                if (control.ClientRectangle.Contains(e.Location)){
                    // back to my code xD //
                    // if mouse position change //
                    if (tilePositionXF != (int)Math.Floor((Decimal)e.Location.X / 32)){
                        // redraw//
                        tileBox.Image = bt.getClonedImage();
                    }
                    if (tilePositionYF != (int)Math.Floor((Decimal)e.Location.Y / 32)){
                        tileBox.Image = bt.getClonedImage();
                    }
                    
                    // transform the real coords of mouse to grid position //
                    tilePositionXF = bt.simplificacion(e.Location.X);
                    tilePositionYF = bt.simplificacion(e.Location.Y);

                    // change selection //
                    bt.setSelection(new Point(tilePositionXO, tilePositionYO), new Point(tilePositionXF, tilePositionYF));

                    // redraw the rectangle //
                    tileBox.Image = bt.drawRectangle();
                    tileBox.Refresh();
                }
            }
        }
        private void pb2_MouseMove(object sender, MouseEventArgs e){
            // if move //
            if (mapPositionX != ((int)Math.Floor((Decimal)e.Location.X / tileWH) * tileWH) + tileWH){
                // change mapbox image //
                mapBox.Image = (Image) sr.tuneada.Clone();
                mapBox.Refresh();
            }
            if (mapPositionY != ((int)Math.Floor((Decimal)e.Location.Y / tileWH) * tileWH) + tileWH){
                mapBox.Image = (Image)sr.tuneada.Clone();
                mapBox.Refresh();
            }

            mapPositionX = ((int)Math.Floor((Decimal)e.Location.X / tileWH) * tileWH) + tileWH;
            mapPositionY = ((int)Math.Floor((Decimal)e.Location.Y / tileWH) * tileWH) + tileWH;

            // draw selected tileImage //
            Graphics mapArea = mapBox.CreateGraphics();
            Image i = bt.getSelectedImage();
            if (i != null){
                mapArea.DrawImage(
                    i,
                    new Point(mapPositionX - (bt.difx * tileWH), mapPositionY - (bt.dify * tileWH))
                );
            }

            if (e.Button == System.Windows.Forms.MouseButtons.Left){
                Control control = (Control)sender;
                if (control.Capture){
                    control.Capture = false;
                }
                if (control.ClientRectangle.Contains(e.Location)){
                    mapBox.Image = setImage();
                    sr.tuneada = mapBox.Image as Bitmap;
                    for (int x = bt.difx - 1; x >= 0; x--)
                    {
                        for (int y = bt.dify - 1; y >= 0; y--)
                        {
                            sr.setImage(
                                ((int)Math.Floor((Decimal)e.Location.X / tileWH)) - x,
                                ((int)Math.Floor((Decimal)e.Location.Y / tileWH)) - y,
                                new Point(tilePositionXO + bt.difx - 1 - x, tilePositionYO + bt.dify - 1 - y)
                            );
                        }
                    }
                    //sr.echoMatrix();
                }
            }
        }

        private void pb2_MouseClick(object sender, MouseEventArgs e){
            mapBox.Image = setImage();
            sr.tuneada = mapBox.Image as Bitmap;
            for (int x = bt.difx-1; x >=0 ; x--){
                for (int y = bt.dify-1; y >= 0; y--){
                    sr.setImage(
                        ((int)Math.Floor((Decimal)e.Location.X / tileWH))-x,
                        ((int)Math.Floor((Decimal)e.Location.Y / tileWH))-y,
                        new Point(tilePositionXO + bt.difx -1 - x, tilePositionYO + bt.dify -1 - y)
                    );
                }
            }
            //sr.echoMatrix();
        }

        public Bitmap setImage(){
            Graphics mapArea = Graphics.FromImage(canvas);
            Image i = bt.getSelectedImage();
            if (i != null)
            {
                mapArea.DrawImage(
                    i,
                    new Point(mapPositionX - (bt.difx * tileWH), mapPositionY - (bt.dify * tileWH))
                );
            }
            sr.setImage(mapBox.Image);
            return canvas;
        }
    }
}
