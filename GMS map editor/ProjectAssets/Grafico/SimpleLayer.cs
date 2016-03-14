using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Drawing;

namespace WindowsFormsApplication1.ProjectAssets.Grafico
{
    class SimpleLayer{
        public int layer;
        public CheckBox[][] t;
        public int w, h;

        public SimpleLayer(int l,int w, int h, int tw, int th) {
            layer = l;
            this.w = w;
            this.h = h;
            t = new CheckBox[h][];
            for(int y = 0; y<h; y++) {
                t[y] = new CheckBox[w];
            }

            for (int y = 0; y < w; y++){
                for (int x = 0; x < w; x++){
                    //MessageBox.Show("x,y = " + x + "," + y + "SIS: W,H "+w+","+h);
                    CheckBox st = new CheckBox();
                    st.Height = th;
                    st.Width = tw;
                    st.Location = new Point(x * tw,y * th);
                    st.Image = WindowsFormsApplication1.Properties.Resources.test;
                    t[x][y] = st;
                }
            }
        }
        public void drawSimpleLayer(Panel p) {
            for (int y = 0; y < w; y++){
                for (int x = 0; x < w; x++){
                    p.Controls.Add(t[x][y]);
                }
            }
        }

        public void addTiles(ArrayList tiles) {
            foreach (CheckBox cb in tiles){
                for (int y = 0; y < w; y++){
                    for (int x = 0; x < w; x++){
                        
                    }
                }
            }
        }

    }
}
