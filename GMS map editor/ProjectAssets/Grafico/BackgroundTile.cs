﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;
using System.Drawing;
using System.Windows.Forms;

namespace GMSMapEditor.ProjectAssets.Grafico{
    class BackgroundTile{
        String data;
        int width, height;
        int tWidth, tHeight;
        CheckBox[][] tiles;
        String origin;

        public BackgroundTile(String url, int tw, int th) {
            data = url;
            tWidth = tw;
            tHeight = th;
            createTiles();
            origin = "";
        }

        public String toString() {
            return "<!--This Document is generated by GameMaker, if you edit it by hand then you do so at your own risk!-->"+
                    "<background>"+
                        "<istileset>-1</istileset>"+
                        "<tilewidth>"+tWidth+"</tilewidth>"+
                        "<tileheight>"+tWidth+"</tileheight>"+
                        "<tilexoff>0</tilexoff>"+
                        "<tileyoff>0</tileyoff>"+
                        "<tilehsep>0</tilehsep>"+
                        "<tilevsep>0</tilevsep>"+
                        "<HTile>0</HTile>"+
                        "<VTile>-1</VTile>"+
                        "<TextureGroups>"+
                            "<TextureGroup0>0</TextureGroup0>"+
                        "</TextureGroups>"+
                        "<For3D>0</For3D>"+
                        "<width>"+width+"</width>"+
                        "<height>"+height+"</height>"+
                        "<data>"+data+"</data>" +
                    "</background>";
        }

        private void createTiles() {
            Image i = Image.FromFile(data);
            width = i.Width;
            height = i.Height;
            int id=0;
            int maxx = width / tWidth;
            int maxy = height / tHeight;

            tiles = new CheckBox[maxy][];
            for (int y = 0; y < maxy; y++){
                tiles[y] = new CheckBox[maxx];
            }
            for (int y = 0; y < (i.Height / tHeight); y++){
                for (int x = 0; x < (i.Width / tWidth); x++){
                    CheckBox p = new CheckBox();
                    p.Location = new Point(x * tWidth, y * tHeight);
                    p.Height = tHeight;
                    p.Width = tWidth;
                    Bitmap testu = i as Bitmap;
                    p.Image = testu.Clone(
                        new Rectangle(new Point(x * tWidth, y * tHeight),
                        new Size(tWidth, tHeight)),
                        testu.PixelFormat
                    );
                    p.Name = x + "," + y;
                    p.MouseClick += new MouseEventHandler((o, a) => selectOne(p.Name));
                    tiles[y][x] = p;
                }
            }
        }

        public void drawBackgroundTile(Panel p){
            for (int y = 0; y < (height / tHeight); y++){
                for (int x = 0; x < (width / tWidth); x++){
                    p.Controls.Add(tiles[y][x]);
                }
            }
        }

        public void selectOne(String id) {
            if (origin.Equals("")){
                origin = id;
                for (int y = 0; y < (height / tHeight); y++){
                    for (int x = 0; x < (width/ tWidth); x++){
                         if (!tiles[y][x].Name.Equals(id)){
                            tiles[y][x].Checked = false;
                        }
                    }
                }
            }
            else {
                int xf = int.Parse(id.Split(',')[0]);
                int yf = int.Parse(id.Split(',')[1]);
                for (int y = int.Parse(origin.Split(',')[1]); y <= yf; y++){
                    for (int x = int.Parse(origin.Split(',')[0]); x <= xf; x++){
                        if (tiles[y][x].Name.Equals(x+","+y)){
                            tiles[y][x].Checked = true;
                        }
                    }
                }
                origin = "";
            }
        }

    }
}
