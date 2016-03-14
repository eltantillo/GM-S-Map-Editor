using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace GMSMapEditor.ProjectAssets.Grafico
{
    class SimpleRoom{
        public ArrayList layers = new ArrayList();
        public int w,h;
        public int tw, th;

        public SimpleRoom(int _w,int _h, int tw, int th) {
            w = _w;
            h = _h;
            layers.Add(new SimpleLayer(10000,w,h,tw,th));
        }
        public void drawSimpleRoom(Panel p) {
            ((SimpleLayer)layers.ToArray()[0]).drawSimpleLayer(p);
        }

        public void addTiles(ArrayList tiles, int layer) { 
            foreach(SimpleLayer l in layers){
                if (l.layer == layer){
                    l.addTiles(tiles);
                }
            }
        }
    }
}
