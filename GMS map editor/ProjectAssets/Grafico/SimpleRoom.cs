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

        public int w, h;
        public int tw, th;
        public Point[][] p;
        public static int TO_X = 1;
        public static int TO_Y = 2;

        ArrayList i, iperma;
        int antX,antY;
        public int capa;
        Image temp;
        Image m;

        public SimpleRoom(int _w,int _h, int _tw, int _th){
            i = new ArrayList();
            i.Add(new Bitmap((_w * _tw) + 1, (_h * _th) + 1));
            iperma = new ArrayList();
            iperma.Add(new Bitmap((_w * _tw) + 1, (_h * _th) + 1));
            capa = 0;
            temp = (iperma[0] as Image).Clone() as Image;
            w = _w;
            h = _h;
            tw = _tw;
            th = _th;
            p = new Point[_h][];
            for (int x = 0; x < _w; x++){
                p[x] = new Point[_w];
            }
        }

        public void updateSelected(Image i){
            m = i;
        }

        private Bitmap cropea() {
            Bitmap target = new Bitmap(1,1);
            if (m != null){
                Rectangle cropRect = new Rectangle(new Point(0, 0), new Size(m.Width, m.Height));
                Bitmap src = m as Bitmap;
                target = new Bitmap(cropRect.Width, cropRect.Height);
                using (Graphics g = Graphics.FromImage(target))
                {
                    g.DrawImage(src, new Rectangle(0, 0, target.Width, target.Height),
                        cropRect,
                        GraphicsUnit.Pixel);
                }
            }
            return target;
        }
        private Bitmap borra(int x, int y) {
            Rectangle r = new Rectangle(x,y,m.Width,m.Height);
            Graphics e = Graphics.FromImage(iperma[capa] as Image);
            e.CompositingMode = System.Drawing.Drawing2D.CompositingMode.SourceCopy;
            using (var br = new SolidBrush(Color.FromArgb(0, 255, 255, 255))){
                e.FillRectangle(br, r);
            }
            return iperma[capa] as Bitmap;
        }
        private Bitmap cropea2(int x, int y){
            Rectangle cropRect = new Rectangle(new Point(x, y), new Size(33, 44));
            Bitmap src = i[capa] as Bitmap;
            Bitmap target = new Bitmap(cropRect.Width, cropRect.Height);

            using (Graphics g = Graphics.FromImage(target)){
                g.DrawImage(src, new Rectangle(0, 0, target.Width, target.Height),
                     cropRect,
                     GraphicsUnit.Pixel);
            }
            return target;
        }

        public void update(PictureBox p, int x, int y){
            if (antX != x || antY != y) {
                antX = x; antY = y;
                temp.Dispose();
                temp = (iperma[capa] as Image).Clone() as Image;
            }
            for (int xdx = 0; xdx < iperma.Count; xdx++ )
                using (Graphics grfx = Graphics.FromImage(temp)){
                    grfx.DrawImage(iperma[xdx] as Image, 0, 0);
                }
            p.Image = temp;
            using (Graphics grfx = Graphics.FromImage(p.Image))
            {
                grfx.DrawImage(cropea(), x, y);
            }
        }
        public void borra(PictureBox p, int x, int y){
            p.Image = iperma[capa] as Image;
            using (Graphics grfx = Graphics.FromImage(p.Image))
            {
                grfx.DrawImage(borra(x, y), 0, 0);
            }
        }
        public void click(PictureBox p, int x, int y) {
            p.Image = iperma[capa] as Image;
            using (Graphics grfx = Graphics.FromImage(p.Image))
            {
                grfx.DrawImage(borra(x, y), 0, 0);
            }
            using (Graphics grfx = Graphics.FromImage(p.Image))
            {
                grfx.DrawImage(cropea(), x, y);
            }
            update(p,x,y);
        }

        public int toGrid(int mouse, int opc) {
            return ((int)Math.Floor((Decimal)mouse / (opc == 1 ? tw : th)) * (opc == 1 ? tw : th));
        }
    }
}
