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

namespace GMSMapEditor{
    public partial class InterfazBasica : Form{

        int clickOrgX,clickOrgY;
        int clickFinX, clickFinY;
        int gridus;

        Object bt;
        Object sr;

        public InterfazBasica(){
            InitializeComponent();
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
            gridus = int.Parse(info.Text);
            int gridus2 = int.Parse(info2.Text);
            //div_left.Controls.Clear();
            // Create an instance of the open file dialog box.
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            openFileDialog1.ShowDialog();

            bt = new BackgroundTile(openFileDialog1.FileName, gridus, gridus);
            ((BackgroundTile)bt).drawBackgroundTile(pb);

            sr = new SimpleRoom(gridus2, gridus2, gridus, gridus);
            ((SimpleRoom)sr).drawSimpleRoom(div_center);
            //bt.drawBackgroundTile(div_right);
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e){
            TestForm f = new TestForm();
            f.Show();
        }
        private void div_left_MouseClick(object sender, MouseEventArgs e){
            clickOrgX = (int)Math.Floor((Decimal)e.Location.X / gridus);
            clickOrgY = (int)Math.Floor((Decimal)e.Location.Y / gridus);
        }
        private void div_left_MouseDeClick(object sender, MouseEventArgs e){
            clickFinX = (int)Math.Floor((Decimal)e.Location.X / gridus); 
            clickFinY = (int)Math.Floor((Decimal)e.Location.Y / gridus);
        }
        private void pb_MouseMove(object sender, MouseEventArgs e){
            if (e.Button == System.Windows.Forms.MouseButtons.Left){
                Control control = (Control) sender;
                if (control.Capture){
                    control.Capture = false;
                }
                if (control.ClientRectangle.Contains (e.Location)){
                    if(MousePosition.X >0 & MousePosition.Y>0){
                        if(clickFinX!= (int)Math.Floor((Decimal)e.Location.X/32) ){
                            pb.Image = ((BackgroundTile)bt).getClonedImage();
                        }
                        if (clickFinY != (int)Math.Floor((Decimal)e.Location.Y / 32)){
                            pb.Image = ((BackgroundTile)bt).getClonedImage();
                        }

                        clickFinX = (int)Math.Floor((Decimal)e.Location.X / gridus);
                        clickFinY = (int)Math.Floor((Decimal)e.Location.Y / gridus);
                        coords.Text = clickOrgX + "," + clickOrgY + "\n" + Math.Floor((Decimal)e.Location.X / gridus) + "," + Math.Floor((Decimal)e.Location.Y / gridus);
                        Graphics drawArea = pb.CreateGraphics();
                        Pen blackpen = new Pen(Color.White);
                        blackpen.Width = 5;
                        drawArea.DrawLine(blackpen, 
                            new Point(clickOrgX * gridus, clickOrgY * gridus), 
                            new Point((clickFinX * gridus)+(clickOrgX<clickFinX?32:0) , clickOrgY * gridus)
                        );
                        drawArea.DrawLine(blackpen,
                            new Point((clickFinX * gridus) + (clickOrgX < clickFinX ? 32 : 0), clickOrgY * gridus),
                            new Point((clickFinX * gridus) + (clickOrgX < clickFinX ? 32 : 0), (clickFinY * gridus) + (clickOrgY < clickFinY ? 32 : 0))
                        );
                        drawArea.DrawLine(blackpen,
                            new Point(clickOrgX * gridus, (clickFinY * gridus) + (clickOrgY < clickFinY ? 32 : 0)),
                            new Point((clickFinX * gridus) + (clickOrgX < clickFinX ? 32 : 0), (clickFinY * gridus) + (clickOrgY < clickFinY ? 32 : 0))
                        );
                        drawArea.DrawLine(blackpen, 
                            new Point(clickOrgX * gridus, clickOrgY * gridus),
                            new Point(clickOrgX * gridus, (clickFinY * gridus) + (clickOrgY < clickFinY ? 32 : 0))
                        );
                        
                        

                    }
                }
            }
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
