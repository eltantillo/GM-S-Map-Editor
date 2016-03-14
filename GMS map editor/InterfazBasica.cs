using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Xml;
using System.IO;
using GMSMapEditor.Classes;
using GMSMapEditor.ProjectAssets;
using GMSMapEditor.ProjectAssets.Grafico;

namespace GMSMapEditor{
    public partial class InterfazBasica : Form{

        Object bt;
        Object sr;

        public InterfazBasica(){
            InitializeComponent();
        }

        private void InterfazBasica_Load(object sender, EventArgs e){

        }

        private void InterfazBasica_SizeChanged(object sender, EventArgs e){
            //MessageBox.Show("Error Message", "Error Title", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
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

                XmlRead(Project.projectFolder + Project.projectName, "background");
                XmlRead(Project.projectFolder + Project.projectName, "room");
            }
        }

        private void XmlRead(string xmlFile, string section)
        {
            String xmlString = File.ReadAllText(xmlFile).ToString();
            using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
            {
                while (reader.ReadToFollowing(section))
                {
                    if (section == "background")
                    {
                        Project.assets.backgrounds.Add(new ProjectAssets.Backgrounds.Background());
                        int num = Project.assets.backgrounds.Count - 1;
                        Project.assets.backgrounds[num].BackgroundRead(Project.projectFolder + reader.ReadElementContentAsString() + "." + section + ".gmx");
                        MessageBox.Show(Project.assets.backgrounds[num].ToString());
                    }
                    else if (section == "room")
                    {
                        Project.assets.rooms.Add(new ProjectAssets.Rooms.Room());
                        int num = Project.assets.rooms.Count - 1;
                        Project.assets.rooms[num].RoomRead(Project.projectFolder + reader.ReadElementContentAsString() + "." + section + ".gmx");
                        MessageBox.Show(Project.assets.rooms[num].ToString());
                    }
                }
            }
        }

        private void contentsToolStripMenuItem_Click(object sender, EventArgs e){
            int gridus = int.Parse(info.Text);
            int gridus2 = int.Parse(info2.Text);
            div_left.Controls.Clear();
            // Create an instance of the open file dialog box.
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            openFileDialog1.ShowDialog();

            bt = new BackgroundTile(openFileDialog1.FileName, gridus, gridus);
            ((BackgroundTile)bt).drawBackgroundTile(div_left);

            sr = new SimpleRoom(gridus2, gridus2, gridus, gridus);
            ((SimpleRoom)sr).drawSimpleRoom(div_center);
            //bt.drawBackgroundTile(div_right);
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e){
            TestForm f = new TestForm();
            f.Show();
        }

    }
}
