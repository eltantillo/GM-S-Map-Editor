using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace GMSMapEditor
{
    public partial class MainWindow : Form
    {
        public MainWindow()
        {
            InitializeComponent();
            //splitContainer1.Panel2Collapsed = !splitContainer1.Panel2Collapsed;
            splitContainer1.SplitterWidth = 3;
            splitContainer2.SplitterWidth = 3;
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            splitContainer1.Panel2Collapsed = !splitContainer1.Panel2Collapsed;
        }
    }
}
