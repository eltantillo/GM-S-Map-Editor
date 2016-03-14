using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace GMSMapEditor.ProjectAssets.Grafico
{
    class SimpleLayer{
        public int layer;
        public SimpleTile[][] t;
        public int w, h;

        public SimpleLayer(int w, int h, int tw, int th) { 
            t= new SimpleTile[h][];
            this.w = w;
            this.h = h;
            for(int y = 0; y<w; y++) {
                t[y] = new SimpleTile[w];
            }

            for (int y = 0; y < w; y++){
                for (int x = 0; x < w; x++){
                    //MessageBox.Show("x,y = " + x + "," + y + "SIS: W,H "+w+","+h);
                    SimpleTile st = new SimpleTile();
                    st.h = th;
                    st.w = tw;
                    st.xo = x * tw;
                    st.yo = y * th;
                    st.image = GMSMapEditor.Properties.Resources.test;
                    t[x][y] = st;
                }
            }
        }
        public void drawSimpleLayer(Panel p) {
            for (int y = 0; y < w; y++){
                for (int x = 0; x < w; x++){
                    p.Controls.Add(t[x][y].getCheckBox());
                }
            }
        }
    }
}
