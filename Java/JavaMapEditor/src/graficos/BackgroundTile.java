package graficos;

import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import xml.Tile;

public class BackgroundTile {
    private BufferedImage buffer;
    private final BufferedImage backgroundTile;
    private final String backgroundName;
    private final int tileWidth;
    private final int tileHeight;
    private ArrayList<Tile> tiles;
    

    /*
     * Constructor basico del backgroundtile, pide lo necesario 
     * para inicializarse.
     */
    public BackgroundTile(BufferedImage source, String name, int tw, int th){
        tileWidth = tw;
        tileHeight = th;
        backgroundTile = source;
        buffer = ImageTools.clone(backgroundTile);
        backgroundName = name;
        tiles = new ArrayList();
        int id = 0;
        for(int y = 0; y<backgroundTile.getHeight(); y+=tileHeight){
            for(int x = 0; x<backgroundTile.getWidth(); x+=tileWidth){
                Tile t = new Tile();
                t.bgName = name;
                t.id = id++;
                t.xo = x;
                t.yo = y;
                t.h = tileHeight;
                t.w = tileWidth;
                tiles.add(t);
            }
        }
    }
    /*
     * Este metodo regresa una imagen perteneciente a una
     * seleccion de un cuadro iniciando en el punto dado
     * (x,y) con una dimension de tileWidth y tileHeight
     */
    public BufferedImage getImageInPoint(Point punto){
        try{
            return backgroundTile.getSubimage(punto.x,punto.y,tileWidth,tileHeight);
        }
        catch (Exception ex){
            return backgroundTile.getSubimage(0,0,tileWidth,tileHeight);
        }
    }
    
    /* :Final: Este metodo es para agregar la selccion del rectangulo */
    public void setSelection(Point inicio,Point fin) {
        Selection.ini = new Point(
            (inicio.x > fin.x ? fin.x : inicio.x),
            (inicio.y > fin.y ? fin.y : inicio.y)
        );
        Selection.fin = new Point(
            (inicio.x < fin.x ? fin.x : inicio.x) + tileWidth,
            (inicio.y < fin.y ? fin.y : inicio.y) + tileHeight
        );
        buffer = ImageTools.clone(backgroundTile);
        Selection.selection = new ArrayList();
        Selection.isTileSet = true;
        for(int y = inicio.y; y<=fin.y; y+=tileHeight){
            for(int x = inicio.x; x<=fin.x; x+=tileWidth){
                try{
                    Selection.selection.add( tiles.get(searchTile(new Point(x,y))).clone() );
                }
                catch(FileNotFoundException ex){
                    System.out.println("Seleccion Skiped");
                }
            }
        }
        int difx = Selection.fin.x - Selection.ini.x;
    	int dify = Selection.fin.y - Selection.ini.y;
    	if(difx!=0 && dify!=0){
            Selection.selectGraphic = backgroundTile.getSubimage(Selection.ini.x,Selection.ini.y,difx,dify);
    	}
        else{
            Selection.selectGraphic = backgroundTile.getSubimage(Selection.ini.x,Selection.ini.y,tileWidth,tileHeight);
        }
    }
    
    private int searchTile(Point p) throws FileNotFoundException{
        int pos = 0;
        for(Tile e : tiles){
            if(e.xo == p.x && e.yo == p.y){
                return pos;
            }
            pos++;
        }
        throw new FileNotFoundException();
    }
    /*
     * Regresa un entero con valor estandar en la Grid del TileWidth
     * y el TileHeight.
     */
    public int toGrid(int mouse, int opc){
        return ((int)Math.floor(mouse / (opc == 1 ? tileWidth : tileHeight)) * (opc == 1 ? tileWidth : tileHeight));
    }
    
    /*
     * Verifica si el nombre del background es el mismo al
     * cargado en esta clase.
     */
    public boolean sameMap(String name){
    	return backgroundName.equals(name);
    }
    /* Dibuja el Tile junto con su rectangulo de seleccion
     * Utiliza un JLabel
     * Las posiciones las regresa a 0,0 y su tama�o es igual
     * a la imagen del background.
    */
    public void drawBackgroundTile(JLabel lb, JLabel lb2){
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
                g.drawRect(Selection.ini.x-1,Selection.ini.y-1,difx+2,dify+2);

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
}
