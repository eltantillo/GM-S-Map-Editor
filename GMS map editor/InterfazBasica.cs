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

namespace GMSMapEditor{
    public partial class InterfazBasica : Form{

        int tilePositionXO,tilePositionYO,tilePositionXF, tilePositionYF;
        int mapPositionX, mapPositionY;
        int gridus;

        Object bt;
        Object sr;
        bool clicked;
        bool clickedV2;
        Bitmap bp;

        public InterfazBasica(){
            InitializeComponent();
            clicked = false;
            clickedV2 = false;
            
        }

        private void contentsToolStripMenuItem_Click(object sender, EventArgs e){
            gridus = 32;
            int gridus2 = 50;
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            openFileDialog1.ShowDialog();
            
            bt = new BackgroundTile(openFileDialog1.FileName, gridus, gridus);
            ((BackgroundTile)bt).drawBackgroundTile(pb);

            sr = new SimpleRoom(gridus2, gridus2,gridus,gridus);
            pb2.Location = new Point(0,0);
            pb2.Height = gridus2 * gridus;
            pb2.Width = gridus2 * gridus;
            bp = new Bitmap((gridus2 * gridus)+1, (gridus2 * gridus)+1);
        }

        private void div_left_MouseClick(object sender, MouseEventArgs e){
            if (clicked){
                clicked = false;
            }
            else{
                tilePositionXO = ((BackgroundTile)bt).positionX(e.Location.X);
                tilePositionYO = ((BackgroundTile)bt).positionY(e.Location.Y);
                clicked = true;
                ((BackgroundTile)bt).setSelection(new Point(tilePositionXO,tilePositionYO),new Point(tilePositionXO,tilePositionYO));
            }
        }
        private void pb_MouseMove(object sender, MouseEventArgs e){
            if (e.Button == System.Windows.Forms.MouseButtons.Left && pb.Image != null){
                Control control = (Control) sender;
                if (control.Capture){
                    control.Capture = false;
                }
                if (control.ClientRectangle.Contains (e.Location)){
                    if(tilePositionXF!= (int)Math.Floor((Decimal)e.Location.X/32) ){
                        pb.Image = ((BackgroundTile)bt).getClonedImage();
                    }
                    if (tilePositionYF != (int)Math.Floor((Decimal)e.Location.Y / 32)){
                        pb.Image = ((BackgroundTile)bt).getClonedImage();
                    }
                    tilePositionXF = ((BackgroundTile)bt).positionX(e.Location.X);
                    tilePositionYF = ((BackgroundTile)bt).positionY(e.Location.Y);

                    ((BackgroundTile)bt).setSelection(new Point(tilePositionXO,tilePositionYO),new Point(tilePositionXF,tilePositionYF));

                    pb.Image = ((BackgroundTile)bt).drawRectangle();
                }
            }
        }

        private void pb2_MouseMove(object sender, MouseEventArgs e){
            if (mapPositionX != ((int)Math.Floor((Decimal)e.Location.X / gridus) * gridus)+gridus){
                pb2.Image = (Image)((SimpleRoom)sr).tuneada.Clone();
            }
            if (mapPositionY != ((int)Math.Floor((Decimal)e.Location.Y / gridus) * gridus)+gridus){
                pb2.Image = (Image)((SimpleRoom)sr).tuneada.Clone();
            }
            
            mapPositionX = ((int)Math.Floor((Decimal)e.Location.X / gridus) * gridus)+gridus;
            mapPositionY = ((int)Math.Floor((Decimal)e.Location.Y / gridus) * gridus)+gridus;

            Graphics mapArea = pb2.CreateGraphics();
            Image i = ((BackgroundTile)bt).getSelectedImage();
            if (i != null){
                mapArea.DrawImage(
                    i,
                    new Point(mapPositionX - (((BackgroundTile)bt).difx * gridus), mapPositionY - (((BackgroundTile)bt).dify * gridus))
                );
            }
            if (e.Button == System.Windows.Forms.MouseButtons.Left){
                /*
                Control control = (Control)sender;
                if (control.Capture){
                    control.Capture = false;
                }
                if (control.ClientRectangle.Contains(e.Location)){
                    for(int x=0;x<((BackgroundTile)bt).difx;x++){
                        for(int y=0;y<((BackgroundTile)bt).dify;y++){
                            ((SimpleRoom)sr).setImage(
                                ((int)Math.Floor((Decimal)e.Location.X / gridus)),
                                ((int)Math.Floor((Decimal)e.Location.Y / gridus)),
                                new Point(tilePositionXO+x,tilePositionXF+y)
                            );
                        }
                    }
                    pb2.Image = ((SimpleRoom)sr).getSimpleRoomImage((BackgroundTile)bt);
                }*/
            }
        }

        private void pb2_MouseClick(object sender, MouseEventArgs e){
            pb2.Image = setImage();/*(sr as SimpleRoom).setImage(
                (int)Math.Floor((Decimal)e.Location.X / gridus), 
                (int)Math.Floor((Decimal)e.Location.Y / gridus), 
                (bt as BackgroundTile)
            );*/
            (sr as SimpleRoom).tuneada = pb2.Image as Bitmap;
            for (int x = 0; x < ((BackgroundTile)bt).difx; x++){
                for (int y = 0; y < ((BackgroundTile)bt).dify; y++){
                    ((SimpleRoom)sr).setImage(
                        ((int)Math.Floor((Decimal)e.Location.X / gridus)),
                        ((int)Math.Floor((Decimal)e.Location.Y / gridus)),
                        new Point(tilePositionXO + x, tilePositionXF + y)
                    );
                }
            }
        }

        public Bitmap setImage(){
            Graphics mapArea = Graphics.FromImage(bp);
            Image i = (bt as BackgroundTile).getSelectedImage();
            if (i != null)
            {
                mapArea.DrawImage(
                    i,
                    new Point(mapPositionX - (((BackgroundTile)bt).difx * gridus), mapPositionY - (((BackgroundTile)bt).dify * gridus))
                );
            }
            (sr as SimpleRoom).setImage(pb2.Image);
            return bp;
        }
    }
}
