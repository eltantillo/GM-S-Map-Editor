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
using WindowsFormsApplication1.ProjectAssets;

namespace WindowsFormsApplication1{
    public partial class InterfazBasica : Form{
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

            testu.Height = 500; //
            testu.Width = 500; // 
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
            projectFile.Filter = "GameMaker: Studio Files (*.gmx)|*.gmx";
            //projectFile.RestoreDirectory = true;

            String directory = "";

            if (projectFile.ShowDialog() == DialogResult.OK)
            {
                ProjectAssets.Project project = new ProjectAssets.Project();
                directory = Path.GetDirectoryName(projectFile.FileName) + @"\";
                xmlRead(projectFile.FileName, project, "background");
                MessageBox.Show(project.backgrounds[0].data);
            }
        }

        private void xmlRead(string xmlFile, ProjectAssets.Project project, string section)
        {
            string directory = Path.GetDirectoryName(xmlFile) + @"\";
            String xmlString = File.ReadAllText(xmlFile).ToString();
            using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
            {
                while (reader.Read())
                {
                    reader.ReadToFollowing(section);
                    if (reader.NodeType == XmlNodeType.Element)
                    {
                        project.backgrounds.Add(new ProjectAssets.Backgrounds.Background());
                        backgroundRead(directory + reader.ReadElementContentAsString() + "." + section + ".gmx", project);
                    }
                }
            }
        }

        private void backgroundRead(string xmlFile, ProjectAssets.Project project)
        {
            String xmlString = File.ReadAllText(xmlFile).ToString();
            using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
            {
                while (reader.Read())
                {
                    reader.ReadToFollowing("");
                    if (reader.NodeType == XmlNodeType.Element)
                    {

                    }
                }
            }
            project.backgrounds[0].data = xmlFile;
        }

    }
}
