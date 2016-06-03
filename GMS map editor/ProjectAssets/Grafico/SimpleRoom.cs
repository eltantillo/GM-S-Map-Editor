using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Collections.Generic;

namespace GMSMapEditor.ProjectAssets.Grafico
{
    public class SimpleRoom{

        public int w, h;
        public int tw, th;
        public static int TO_X = 1;
        public static int TO_Y = 2;

        List<Image> iperma;
        int antX,antY;
        public int capa;
        Image temp;
        Image m;
        List<Rooms.Tile> tiles;
        //new room
        public SimpleRoom(int _w,int _h, int _tw, int _th){
            //i = new List<Image>();
            //i.Add(new Bitmap((_w * _tw) + 1, (_h * _th) + 1));
            iperma = new List<Image>();
            iperma.Add(new Bitmap((_w * _tw) + 1, (_h * _th) + 1));
            capa = 0;
            temp = iperma[0].Clone() as Image;
            w = _w;
            h = _h;
            tw = _tw;
            th = _th;
        }
        //load room
        public SimpleRoom(int _w, int _h,List<Rooms.Tile> tl){
            //i = new List<Image>();
            //i.Add(new Bitmap(_w, _h));
            iperma = new List<Image>();
            iperma.Add(new Bitmap(_w, _h));
            capa = 0;
            temp = iperma[0].Clone() as Image;
            w = _w;
            h = _h;
            tiles = tl;
            if(tl.Count>0){
                tw = tl[0].w;
                th = tl[0].h;
            }
        }

        public void updateSelected(Image i){
            m = i;
        }
        public void roomIni(List<BackgroundTile>bt){
            foreach(Rooms.Tile tile in tiles){
                foreach(BackgroundTile b in bt){
                    if (b.backgroundName.Equals(tile.bgName)){
                        m = b.getSelectedImage(new Point(tile.xo, tile.yo));
                        click(tile.x, tile.y);
                        break;
                    }
                }
            }
        }

        private Bitmap cropea() {
            Bitmap target = new Bitmap(1,1);
            if (m != null){
                Rectangle cropRect = new Rectangle(new Point(0, 0), new Size(m.Width, m.Height));
                target = new Bitmap(cropRect.Width, cropRect.Height);
                using (Graphics g = Graphics.FromImage(target))
                {
                    g.DrawImage(m, new Rectangle(0, 0, target.Width, target.Height),
                        cropRect,
                        GraphicsUnit.Pixel);
                }
            }
            return target;
        }
        private Bitmap borra(int x, int y) {
            Rectangle r = new Rectangle(x,y,m.Width,m.Height);
            Graphics e = Graphics.FromImage(iperma[capa]);
            e.CompositingMode = System.Drawing.Drawing2D.CompositingMode.SourceCopy;
            using (var br = new SolidBrush(Color.FromArgb(0, 255, 255, 255))){
                e.FillRectangle(br, r);
            }
            return iperma[capa] as Bitmap;
        }
        private Bitmap cropea2(int x, int y){
            Rectangle cropRect = new Rectangle(new Point(x, y), new Size(33, 44));
            Bitmap target = new Bitmap(cropRect.Width, cropRect.Height);
            using (Graphics g = Graphics.FromImage(target)){
                g.DrawImage(
                    iperma[capa], 
                    new Rectangle(0, 0, target.Width, target.Height),
                    cropRect,
                    GraphicsUnit.Pixel
                );
            }
            return target;
        }

        public void update(PictureBox p, int x, int y){
            antX = x; antY = y;
            temp.Dispose();
            temp = iperma[capa].Clone() as Image;
            for (int xdx = 0; xdx < iperma.Count; xdx++ )
                using (Graphics grfx = Graphics.FromImage(temp)){
                    grfx.SmoothingMode = SmoothingMode.None;
                    grfx.DrawImage(iperma[xdx] as Image, 0, 0);
                }
            p.Image = temp;
            using (Graphics grfx = Graphics.FromImage(p.Image)){
                grfx.DrawImage(cropea(), x, y);
            }
        }
        public void borra(PictureBox p, int x, int y){
            p.Image = iperma[capa];
            using (Graphics grfx = Graphics.FromImage(p.Image))
            {
                grfx.DrawImage(borra(x, y), 0, 0);
            }
        }
        public void click(PictureBox p, int x, int y) {
            using (Graphics grfx = Graphics.FromImage(iperma[capa]))
            {
                grfx.DrawImage(borra(x, y), 0, 0);
            }
            using (Graphics grfx = Graphics.FromImage(iperma[capa]))
            {
                grfx.DrawImage(cropea(), x, y);
            }
            update(p,x,y);
        }
        public void click(int x, int y){
            using (Graphics grfx = Graphics.FromImage(iperma[capa])){
                grfx.DrawImage(cropea(), x, y);
            }
        }

        public int toGrid(int mouse, int opc) {
            if(tw == 0 || th==0){
                return 0;
            }
            return ((int)Math.Floor((Decimal)mouse / (opc == 1 ? tw : th)) * (opc == 1 ? tw : th));
        }
    }
}
