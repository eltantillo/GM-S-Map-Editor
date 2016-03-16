using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using GMSMapEditor.Classes;

namespace GMSMapEditor
{
    public partial class MainWindow : Form
    {
        public MainWindow()
        {
            InitializeComponent();
            splitContainer1.SplitterWidth = 3;
            splitContainer2.SplitterWidth = 3;
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            //splitContainer1.Panel2Collapsed = !splitContainer1.Panel2Collapsed;
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
    }
}
