package graficos;

import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import xml.projectAssets.rooms.Tile;
import xml.projectAssets.backgrounds.Background;

public class BackgroundTile {
    private BufferedImage buffer;
    private BufferedImage backgroundTile;
    private final String backgroundName;
    private final int tileWidth, tileHeight, offsetX, offsetY,sepX,sepY;
    
    public BackgroundTile(Background b){
        tileWidth = b.tilewidth;
        tileHeight = b.tileheight;
        backgroundTile = b.image;
        backgroundName = b.name;
        offsetX = b.tilexoff;
        offsetY = b.tileyoff;
        sepX = b.tilevsep;
        sepY = b.tilehsep;
    }
    public int getTW(){
        return tileWidth;
    }
    public int getTH(){
        return tileHeight;
    }
    public BackgroundTile(BufferedImage source, String name, int tw, int th, int offX, int offY,int sepv,int seph){
        tileWidth = tw;
        tileHeight = th;
        backgroundTile = source;
        backgroundName = name;
        offsetX = offX;
        offsetY = offY;
        sepX = sepv;
        sepY = seph;
    }
    
    public void setImage(BufferedImage i){
        backgroundTile = i;
    }
    
    public BufferedImage getImageInPoint(Point punto){
        try{
            return backgroundTile.getSubimage(punto.x,punto.y,tileWidth,tileHeight);
        }
        catch (Exception ex){
            return backgroundTile.getSubimage(0,0,tileWidth,tileHeight);
        }
    }
    public void setSelection(Point inicio,Point fin) {
        inicio.x = toGrid(inicio.x, 1);
        inicio.y = toGrid(inicio.y, 2);
        fin.x = toGrid(fin.x, 1);
        fin.y = toGrid(fin.y, 2);
        Selection.ini = new Point(
            (inicio.x > fin.x ? fin.x : inicio.x),
            (inicio.y > fin.y ? fin.y : inicio.y)
        );
        Selection.fin = new Point(
            (inicio.x < fin.x ? fin.x : inicio.x) + tileWidth,
            (inicio.y < fin.y ? fin.y : inicio.y) + tileHeight
        );
        Selection.isTileSet = true;
        // creando grafico //
        int difx = Selection.fin.x - Selection.ini.x;
    	int dify = Selection.fin.y - Selection.ini.y;
        BufferedImage b = new BufferedImage(difx, dify, BufferedImage.TYPE_4BYTE_ABGR);
        
        // creando graficos de los tiles //
        int avanceX = tileWidth+sepX;
        int avanceY = tileHeight+sepY;
        for(int y = Selection.ini.y; y<Selection.fin.y; y+=avanceY){
            for(int x = Selection.ini.x; x<Selection.fin.x; x+=avanceX){
                BufferedImage cut = backgroundTile.getSubimage(x, y, tileWidth, tileHeight);
                int cutX = (x/avanceX) - Selection.ini.x/avanceX;
                int cutY = (y/avanceY) - Selection.ini.y/avanceY;
                b = ImageTools.copyPaste(cut, cutX*tileWidth, cutY*tileHeight, b);
            }
        }
        Selection.selectGraphic = b;
        Selection.selection = createSelectionTiles(Selection.ini, Selection.fin);
    }
    public boolean sameMap(String name){
    	return backgroundName.equals(name);
    }
    public void drawBackgroundTile(JLabel lb){
        buffer= ImageTools.clone(backgroundTile);
    	lb.setMinimumSize(new Dimension(buffer.getWidth(), buffer.getHeight()));
    	lb.setPreferredSize(new Dimension(buffer.getWidth(), buffer.getHeight()));
    	lb.setMaximumSize(new Dimension(buffer.getWidth(), buffer.getHeight()));
    	lb.setIcon(new ImageIcon(buffer));
        
        // Dibuja rectangulo de seleccion //
    	if(Selection.isTileSet){
            Graphics g = buffer.getGraphics();//lb.getGraphics();
            int difx = Selection.fin.x - Selection.ini.x;
            int dify = Selection.fin.y - Selection.ini.y;
            if(difx != 0 && dify != 0){
                g.setColor(Color.BLACK);
                g.drawRect(Selection.ini.x -1,Selection.ini.y-1,difx+2,dify+2);
                g.setColor(Color.WHITE);
                g.drawRect(Selection.ini.x,Selection.ini.y,difx,dify);
                g.setColor(Color.BLACK);
                g.drawRect(Selection.ini.x+1,Selection.ini.y+1,difx-2,dify-2);
                lb.paint(g);
            }
            else{
                g.setColor(Color.WHITE);
                g.drawRect(Selection.ini.x,Selection.ini.y,tileWidth,tileHeight);
                lb.paint(g);
            }
        }
    	ImageIcon icon = (ImageIcon)lb.getIcon();
    	buffer = (BufferedImage)((Image) icon.getImage());
    }
    private ArrayList<Tile> createSelectionTiles(Point i, Point f){
        ArrayList<Tile> tiles = new ArrayList();
        int avanceY = tileHeight+sepY;
        int avanceX = tileWidth+sepX;
        
        for(int y = i.y; y<f.y; y+=avanceY){
            for(int x = i.x; x<f.x; x+=avanceX){
                Tile t = new Tile();
                t.bgName = this.backgroundName;
                t.w = this.tileWidth;
                t.h = this.tileHeight;
                t.xo = x;
                t.yo = y;
                t.x = (x/avanceX) - i.x/avanceX;
                t.y = (y/avanceY) - i.y/avanceY;
                tiles.add(t);
            }
        }
        return tiles;
    }
    private int toGrid(int mouse, int opc){
        if(opc==1)
            return (int) Math.floor(mouse / (tileWidth+sepX)) * (tileWidth+sepX) + offsetX;
        return (int) Math.floor(mouse / (tileHeight+sepY)) * (tileHeight+sepY)+offsetY;
    }
}
