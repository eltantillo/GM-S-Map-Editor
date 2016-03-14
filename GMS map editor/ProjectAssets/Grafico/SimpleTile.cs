using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;
using System.Windows.Forms;

namespace GMSMapEditor.ProjectAssets.Grafico
{
    class SimpleTile{
        public int xo,yo;
        public int w, h;
        public Bitmap image;
        public CheckBox box;

        public CheckBox getCheckBox(){
            box = new CheckBox();
            box.Location = new Point(xo, yo);
            box.Width = w;
            box.Height = h;
            box.Image = image;
            box.Name = xo+","+yo;
            box.MouseClick += new MouseEventHandler((o, a) => MessageBox.Show("Click en :"+box.Name));
            return box;
        }
    }

}
