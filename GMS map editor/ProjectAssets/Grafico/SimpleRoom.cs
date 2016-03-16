using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Drawing;
using System.Drawing.Drawing2D;

namespace GMSMapEditor.ProjectAssets.Grafico
{
    class SimpleRoom{
        public int w,h;
        public int tw, th;
        public Bitmap original;
        public Bitmap tuneada;
        public Point [][]p;

        public SimpleRoom(int _w,int _h, int _tw, int _th) {
            w = _w;
            h = _h;
            tw = _tw;
            th = _th;
            original = new Bitmap((_w * _tw)+1 , (_h* _th)+1);
            tuneada = (Bitmap)original.Clone();
            p = new Point[_h][];
            for (int x = 0; x < _w;x++ ){
                p[x] = new Point[_w];
            }
        }
        public void setImage(int x,int y,Point ps) {
            MessageBox.Show(x+","+y+" "+ps.X+","+ps.Y);
            p[y][x] = ps;
        }
        public void echoMatrix() {
            String p3 = "";
            foreach (Point[] p1 in p){
                foreach (Point p2 in p1){
                    p3 += "{"+p2.X+","+p2.Y+"}";
                }
                p3 += "\n";
            }
            MessageBox.Show(p3);
        }

        public void setImage(Image i){
            Bitmap bp = tuneada as Bitmap;
            Graphics mapArea = Graphics.FromImage(bp);
            if (i != null)
            {
                mapArea.DrawImage(
                    i,
                    new Point(0, 0)
                );
            }
        }
        public Bitmap setImage(int mapPositionX, int mapPositionY, BackgroundTile bt){
            Graphics mapArea = Graphics.FromImage(tuneada);
            Image i = bt.getSelectedImage();
            if (i != null){
                mapArea.DrawImage(
                    i,
                    new Point(mapPositionX - (((BackgroundTile)bt).difx * tw), mapPositionY - (((BackgroundTile)bt).dify * th))
                );
            }
            //(sr as SimpleRoom).setImage(pb2.Image);
            return tuneada;
        }

    }
}
