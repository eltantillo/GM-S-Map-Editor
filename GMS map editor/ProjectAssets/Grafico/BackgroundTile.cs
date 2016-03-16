using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;
using System.Drawing;
using System.Windows.Forms;

namespace GMSMapEditor.ProjectAssets.Grafico{
    class BackgroundTile{
        public int width, height;
        public int tWidth, tHeight;
        public Point inicio, final;
        public Image img;
        public int difx, dify;

        public BackgroundTile(String url, int tw, int th) {
            tWidth = tw;
            tHeight = th;
            img = Image.FromFile(url);
            width = img.Width;
            height = img.Height;
        }
        public void drawBackgroundTile(PictureBox ib){
            ib.Image = (Image)img.Clone();
            ib.Height = height;
            ib.Width = width;
            ib.Location = new Point(0,0);
        }
        public Image getClonedImage(){
            return (Image)img.Clone();
        }
        public Image getSelectedImage() {
            Bitmap testu = img as Bitmap;
            if(difx>0&&difx>0){
                try
                {
                    return testu.Clone(
                        new Rectangle(new Point(inicio.X * tWidth, inicio.Y * tHeight),
                        new Size(tWidth * difx, tHeight * dify)),
                        testu.PixelFormat
                    );
                }
                catch (Exception ex) {
                    MessageBox.Show("drawable: \n" + inicio.X + "," + inicio.Y + " " + difx + "," + dify);
                }
            }
            return testu.Clone(
                new Rectangle(new Point(inicio.X * tWidth, inicio.Y * tHeight),
                new Size(tWidth, tHeight)),
                testu.PixelFormat
            );
        }

        public Image getSelectedImage(Point a){
            Bitmap testu = img as Bitmap;
            try{
                MessageBox.Show("drawable: \n" + a.X + "," + a.Y);
                return testu.Clone(
                    new Rectangle(new Point(a.X, a.Y),
                    new Size(tWidth, tHeight)),
                    testu.PixelFormat
                );
            }
            catch (Exception ex){
                MessageBox.Show("drawable: \n" + inicio.X + "," + inicio.Y + " " + difx + "," + dify);
                return testu.Clone(
                    new Rectangle(new Point(0, 0),
                    new Size(tWidth, tHeight)),
                    testu.PixelFormat
                );
            }
            
        }

        public void setSelection(Point inicio,Point final) {
            this.inicio = new Point(
                (inicio.X > final.X ? final.X : inicio.X),
                (inicio.Y > final.Y ? final.Y : inicio.Y)
            );
            this.final = new Point(
                (inicio.X < final.X ? final.X+1 : inicio.X+1),
                (inicio.Y < final.Y ? final.Y+1 : inicio.Y+1)
            );
        }
        public Bitmap drawRectangle() {
            Bitmap bp = img.Clone() as Bitmap;
            Graphics drawArea = Graphics.FromImage(bp);
            Pen blackpen = new Pen(Color.White);
            blackpen.Width = 5;

            // ------>
            drawArea.DrawLine(blackpen,
                new Point(inicio.X * tWidth, inicio.Y * tHeight),
                new Point(final.X * tWidth, inicio.Y * tHeight)
            );
            // |
            // v
            drawArea.DrawLine(blackpen,
                new Point(final.X * tWidth, inicio.Y * tHeight),
                new Point(final.X * tWidth, final.Y * tHeight)
            );
            // <-------
            drawArea.DrawLine(blackpen,
                new Point(final.X * tWidth, final.Y * tHeight),
                new Point(inicio.X * tWidth, final.Y * tHeight)
            );
            //  ^
            //  |
            drawArea.DrawLine(blackpen,
                new Point(inicio.X * tWidth, final.Y * tHeight),
                new Point(inicio.X * tWidth, inicio.Y * tHeight)
            );
            difx = (final.X > inicio.X ? final.X - inicio.X : inicio.X - final.X);
            dify = (final.Y > inicio.Y ? final.Y - inicio.Y : inicio.Y - final.Y);
            return bp;
        }

        // simplificador //
        public int positionX(int mouseX) {
            return (int)Math.Floor((Decimal)mouseX / tWidth);
        }
        public int positionY(int mouseY){
            return (int)Math.Floor((Decimal)mouseY / tHeight);
        }
    }
}
