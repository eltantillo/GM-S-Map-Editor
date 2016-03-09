﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Xml;
using System.IO;

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
        }

        private void noseToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //Load Existing Project

            StringBuilder output = new StringBuilder();

            String xmlString = File.ReadAllText(@"D:\Projects\GMLCoder\testProject.gmx\testProject.project.gmx").ToString();

            MessageBox.Show(xmlString);

            // Create an XmlReader
            using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
            {
                reader.ReadToFollowing("background");
                MessageBox.Show(reader.ReadElementContentAsString());



                //reader.ReadToFollowing("title");
                //output.AppendLine("Content of the title element: " + reader.ReadElementContentAsString());

                /*while (reader.Read())
                {
                    switch (reader.NodeType)
                    {
                        case XmlNodeType.Element:
                            output.AppendLine(reader.Name);
                            break;
                        case XmlNodeType.Text:
                            output.AppendLine(reader.Value);
                            break;
                        case XmlNodeType.XmlDeclaration:
                        case XmlNodeType.ProcessingInstruction:
                            //writer.WriteProcessingInstruction(reader.Name, reader.Value);
                            break;
                        case XmlNodeType.Comment:
                            output.AppendLine(reader.Value);
                            break;
                        case XmlNodeType.EndElement:
                            //writer.WriteFullEndElement();
                            break;
                    }
                }*/
            }
        }

        private void deleteDelToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void queEsEstoToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void contentsToolStripMenuItem_Click(object sender, EventArgs e){
            int gridus = int.Parse(info.Text);
            div_left.Controls.Clear();
            // Create an instance of the open file dialog box.
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            openFileDialog1.ShowDialog();
            Image i = Image.FromFile(openFileDialog1.FileName);

            //MessageBox.Show("Estado: IH=" + i.Height + " IW=" + i.Width + " FIH=" + (i.Height / gridus) + " FIW=" + (i.Width / gridus));

            for (int y = 0; y < (i.Height/gridus); y++){
                for (int x = 0; x < (i.Width/gridus); x++){
                    PictureBox p = new PictureBox();
                    p.Location = new Point(x*gridus, y*gridus);
                    Bitmap testu = i as Bitmap;
                    
                    p.Width = gridus;
                    p.Height = gridus;
                    p.Image = testu.Clone(
                        new Rectangle(new Point(x*gridus, y*gridus),
                        new Size(gridus, gridus)),
                        testu.PixelFormat
                    );
                    div_left.Controls.Add(p);
                    //MessageBox.Show("It: x=" + x + " y=" + y);
                    //MessageBox.Show("x < i.Width " + x + "<" + i.Width);
                }
                //MessageBox.Show("y < i.Height " + y + "<" + i.Height);
            }
        }

    }
}
