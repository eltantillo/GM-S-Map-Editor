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
        public Image i;
        public Point [][]p;

        public SimpleRoom(int _w,int _h) {
            w = _w;
            h = _h;
            i = new Bitmap(_w,_h);
            p = new Point[_h][];
            for (int x = 0; x < _w;x++ ){
                p[x] = new Point[_w];
            }
        }
        public void setImage(int x,int y,Point ps) {
            MessageBox.Show(x+","+y+" "+w+","+h);
            p[y][x] = ps;
        }
        public Bitmap getSimpleRoomImage(BackgroundTile bt){
            Bitmap bitmap = new Bitmap(1000, 1000);
            foreach (Point[] p1 in p){
                foreach (Point p2 in p1){
                    Image org = bt.getTruncateImage(p2.X,p2.Y,bt.tWidth,bt.tHeight);
                    using (Graphics g = Graphics.FromImage(bitmap)){
                        g.DrawImage(i, 0, 0);
                        
                        g.DrawImage(org, p2.X - org.Width, p2.Y - org.Height);
                    }
                }
            }
            return bitmap;
        }

    }
}
