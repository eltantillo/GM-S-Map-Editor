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
        int dimsX, dimsY;

        Object bt;
        Object sr;
        bool clicked;
        bool clickedV2;

        public InterfazBasica(){
            InitializeComponent();
            clicked = false;
            clickedV2 = false;
        }

        private void InterfazBasica_Load(object sender, EventArgs e){

        }

        private void InterfazBasica_SizeChanged(object sender, EventArgs e){
            div_left.Width = int.Parse(Math.Floor(this.Width * 0.25) + "");
            div_left.Dock = DockStyle.Left;
            div_left.SetAutoScrollMargin(12, div_left.Height);

            div_center.Width = int.Parse(Math.Floor(this.Width * 0.5) + "");
            div_center.Dock = DockStyle.Left;
            div_center.Location = new Point(div_left.Height,0);
            div_center.SetAutoScrollMargin(12, div_left.Height);

            div_right.Width = int.Parse(Math.Floor(this.Width * 0.25) + "");
            div_right.Dock = DockStyle.Left;
            div_right.Location = new Point(div_center.Height, 0);
            div_right.SetAutoScrollMargin(12, div_left.Height);
            barra2.Width = this.Width;
        }

        private void noseToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
        }

        private void deleteDelToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void queEsEstoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog projectFile = new OpenFileDialog();
            projectFile.Filter = "GameMaker: Studio Project Files|*.project.gmx";

            if (projectFile.ShowDialog() == DialogResult.OK)
            {
                Project.assets = new ProjectAssets.Assets();
                Project.projectFolder = Path.GetDirectoryName(projectFile.FileName) + @"\";
                Project.projectName = Path.GetFileName(projectFile.FileName);
                Project.OpenProject();
            }
        }

        private void contentsToolStripMenuItem_Click(object sender, EventArgs e){
            gridus = 32;
            int gridus2 = 32;
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            openFileDialog1.ShowDialog();
            
            bt = new BackgroundTile(openFileDialog1.FileName, gridus, gridus);
            ((BackgroundTile)bt).drawBackgroundTile(pb);

            sr = new SimpleRoom(gridus2, gridus2);
            pb2.Location = new Point(0,0);
            pb2.Height = gridus2 * gridus;
            pb2.Width = gridus2 * gridus;
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e){
            TestForm f = new TestForm();
            f.Show();
        }
        private void div_left_MouseClick(object sender, MouseEventArgs e){
            if (clicked){
                clicked = false;
            }
            else{
                tilePositionXO = ((BackgroundTile)bt).positionX(e.Location.X);
                tilePositionYO = ((BackgroundTile)bt).positionY(e.Location.Y);
                clicked = true;
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

                    coords.Text="Donde esta el origen?\n"+tilePositionXO+tilePositionYO;

                    ((BackgroundTile)bt).setSelection(new Point(tilePositionXO,tilePositionYO),new Point(tilePositionXF,tilePositionYF));

                    pb.Image = ((BackgroundTile)bt).drawRectangle();
                }
            }
        }

        private void pb2_MouseMove(object sender, MouseEventArgs e){
            int tamY = dimsY+1;
            int tamX = dimsX+1;
            if (mapPositionX != ((int)Math.Floor((Decimal)e.Location.X / gridus) * gridus)+gridus){
                pb2.Image = (Image)((SimpleRoom)sr).i.Clone();
            }
            if (mapPositionY != ((int)Math.Floor((Decimal)e.Location.Y / gridus) * gridus)+gridus){
                pb2.Image = (Image)((SimpleRoom)sr).i.Clone();
            }
            
            mapPositionX = ((int)Math.Floor((Decimal)e.Location.X / gridus) * gridus)+gridus;
            mapPositionY = ((int)Math.Floor((Decimal)e.Location.Y / gridus) * gridus)+gridus;

            otro.Text = "Dif:" + dimsX +","+dimsY+ "\nCOX" + mapPositionX + "," + "COY" + mapPositionY + "\n" + "CFX" + Math.Floor((Decimal)e.Location.X / gridus) + "," + "CFY" + Math.Floor((Decimal)e.Location.Y / gridus);

            Graphics mapArea = pb2.CreateGraphics();
            Image i = ((BackgroundTile)bt).getTruncateImage(
                    tilePositionXO,
                    tilePositionYO,
                    tamX,
                    tamY
                );
            if (i != null){
                mapArea.DrawImage(
                    i,
                    new Point(mapPositionX-(tamX*gridus),mapPositionY-(tamY*gridus))
                );
            }
            if (e.Button == System.Windows.Forms.MouseButtons.Left)
            {
                Control control = (Control)sender;
                if (control.Capture)
                {
                    control.Capture = false;
                }
                if (control.ClientRectangle.Contains(e.Location))
                {
                    for(int x=0;x<dimsX;x++){
                        for(int y=0;y<dimsY;y++){
                            ((SimpleRoom)sr).setImage(((int)Math.Floor((Decimal)e.Location.X / gridus)),((int)Math.Floor((Decimal)e.Location.Y / gridus)),new Point(tilePositionXO+x,tilePositionXF+y));
                        }
                    }
                    pb2.Image = ((SimpleRoom)sr).getSimpleRoomImage((BackgroundTile)bt);
                }
            }
        }

        private void pb2_MouseClick(object sender, MouseEventArgs e){
            for (int x = 0; x < dimsX; x++)
            {
                for (int y = 0; y < dimsY; y++)
                {
                    ((SimpleRoom)sr).setImage(((int)Math.Floor((Decimal)e.Location.X / gridus)), ((int)Math.Floor((Decimal)e.Location.Y / gridus)), new Point(tilePositionXO + x, tilePositionXF + y));
                }
            }
            pb2.Image = ((SimpleRoom)sr).getSimpleRoomImage((BackgroundTile)bt);
        }

        private void saveProjectToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                Project.SaveProject();
                MessageBox.Show("El proyecto se ha guardado.");
            }
            catch
            {
                MessageBox.Show("Ocurrió un error al guardar el proyecto.");
            }
        }
    }
}
