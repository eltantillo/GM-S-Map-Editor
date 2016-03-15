using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using GMSMapEditor.ProjectAssets.Grafico;

namespace GMSMapEditor
{
    public partial class TestForm : Form
    {
        public TestForm()
        {
            InitializeComponent();
        }

        private void InterfazBasica_SizeChanged(object sender, EventArgs e){
            //MessageBox.Show("Error Message", "Error Title", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            
            div_left.Width = int.Parse(Math.Floor(this.Width * 0.25) + "");
            div_left.Dock = DockStyle.Left;

            div_center.Width = int.Parse(Math.Floor(this.Width * 0.5) + "");
            div_center.Dock = DockStyle.Left;
            div_center.Location = new Point(div_left.Height, 0);
        }

        private void button1_Click(object sender, EventArgs e){
            int gridus = int.Parse(info.Text);
            int gridus2 = int.Parse(info2.Text);
            div_left.Controls.Clear();
            // Create an instance of the open file dialog box.
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            openFileDialog1.ShowDialog();

            BackgroundTile bt = new BackgroundTile(openFileDialog1.FileName, gridus, gridus);
            //bt.drawBackgroundTile(div_left);

            //SimpleRoom sr = new SimpleRoom(gridus2, gridus2, gridus, gridus);
            //sr.drawSimpleRoom(div_center);
            //bt.drawBackgroundTile(div_right);
        }
    }
}
