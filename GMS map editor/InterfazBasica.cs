using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

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
            div_left.Height = this.Height;
            //div_left.SetAutoScrollMargin(12, this.Height);
            div_left.HorizontalScroll.Maximum = int.Parse(Math.Floor(this.Width * 0.25) + "");
            div_left.HorizontalScroll.Minimum = int.Parse(Math.Floor(this.Width * 0.25) + "");
            div_left.HorizontalScroll.Enabled = true;
            div_left.HorizontalScroll.Visible = true;


            testu.Height = 500; //
            testu.Width = 500; // 
        }
    }
}
