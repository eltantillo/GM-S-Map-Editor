package graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.shape.Line;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import xml.*;


public class SimpleRoom {
    private int w, h,tw,th;
    private BufferedImage iperma;
    private int currentLayer;
    private ArrayList<ArrayList<Tile>> layerTile;
    private boolean grid;
  
// Constantes //
    private static final String NO_BACKGROUND = "NONE_BACKGROUND_FOUND";
    
    public void grid(){
        grid =! grid;
    }
    
    public int toGrid(int mouse, int type){
        return ((int)Math.floor(mouse / (type == 1 ? tw : th)) * (type == 1 ? tw : th));
    }
    
    public void changeGrid(int tw, int th){
        this.tw = tw;
        this.th = th;
    }
    /* :Final: Dibuja la seleccion en el mapa tras un click */
    public void click(JLabel p, int youClickedX, int youClickedY){
        System.out.println("You click Position: "+youClickedX+" " +youClickedY);
        ArrayList<Tile> selection = Selection.selection;
        if(Selection.isTileSet){
            int defaultX = selection.get(0).xo;
            int defaultY = selection.get(0).yo;
            for(Tile tile : selection){
                Tile temp = tile.clone();
                temp.x = youClickedX + (tile.xo-defaultX);
                temp.y = youClickedY + (tile.yo-defaultY);
                checkForTile(temp);
            }
        }
        else{
            int defaultX = selection.get(0).x;
            int defaultY = selection.get(0).y;
            for(Tile tile : selection){
                Tile temp = tile.clone();
                temp.x = youClickedX + (temp.x-defaultX);
                temp.y = youClickedY + (temp.y-defaultY);
                checkForTile(temp);
            }
        }
        update(p,youClickedX,youClickedY);
    }
    /* :Final: Permite cambiar de capa, Si la capa no existe crea capas hasta llegar a la capa */
    public void changeLayer(int x){
    	if(x<layerTile.size()){
            currentLayer = x;
        }
        else{
            layerTile.add(createEmptyTile());
            changeLayer(x);
        }
    }
    /* :Final: Actualiza el grafico */
    public void update(JLabel p, int x, int y){
        // Dibuja los tiles existentes //
        BufferedImage blank = ImageTools.clone(iperma);
        // por cada capa dibuja tus tiles //
        for(int tempX = 0; tempX<layerTile.size(); tempX++){
            blank = ImageTools.copyPaste(drawLayer(tempX), 0, 0, blank);
        }
        
        // Dibujando Grid //
        if(grid){
            for(int tempX = 0; tempX<w; tempX+=tw){
                for(int tempY =0; tempY<h; tempY+=th ){
                    Graphics g = blank.getGraphics();
                    g.setColor(Color.WHITE);
                    g.drawRect(tempX,tempY,tw,th);
                }
            }
        }
        
        // dibuja seleccion //
        blank = ImageTools.copyPaste(Selection.selectGraphic, x, y, blank);
        
        // dibuja cuadro de seleccion si esta seleccionado en mapa //
        if(!Selection.isTileSet){
            Graphics g = blank.getGraphics();
            int difx = Selection.fin.x - Selection.ini.x;
            int dify = Selection.fin.y - Selection.ini.y;
            if(difx != 0 && dify != 0){
                g.setColor(Color.BLACK);
                g.drawRect(Selection.ini.x-1,Selection.ini.y-1,difx+2,dify+2);
                g.setColor(Color.WHITE);
                g.drawRect(Selection.ini.x,Selection.ini.y,difx,dify);
                g.setColor(Color.BLACK);
                g.drawRect(Selection.ini.x+1,Selection.ini.y+1,difx-2,dify-2);
            }
        }
        
        // Actualiza grafico //
        p.setMinimumSize(new Dimension(blank.getWidth(), blank.getHeight()));
    	p.setPreferredSize(new Dimension(blank.getWidth(), blank.getHeight()));
    	p.setMaximumSize(new Dimension(blank.getWidth(), blank.getHeight()));
        p.setIcon(new ImageIcon(blank));
    }
    /* :Final: Crear un Room con sus multicapas. */
    public SimpleRoom(int _w,int _h, int _tw, int _th){
        w = _w* _tw;
        h = _h* _th;
        tw = _tw;
        th = _th;
        iperma = new BufferedImage( w + 1 , h + 1  , BufferedImage.TYPE_INT_ARGB);
        currentLayer = 0;
        
        layerTile = new ArrayList<>();
        
        // Agregando 5 capas //
        layerTile.add(createEmptyTile());
        layerTile.add(createEmptyTile());
        layerTile.add(createEmptyTile());
        layerTile.add(createEmptyTile());
        layerTile.add(createEmptyTile());
    }
    /* :Final: Este metodo es para agregar la selccion del rectangulo */
    public void setSelection(Point inicio,Point fin) {
        Selection.ini = new Point(
            (inicio.x > fin.x ? fin.x : inicio.x),
            (inicio.y > fin.y ? fin.y : inicio.y)
        );
        Selection.fin = new Point(
            (inicio.x < fin.x ? fin.x : inicio.x) + tw,
            (inicio.y < fin.y ? fin.y : inicio.y) + th
        );
        
        Selection.selection = new ArrayList();
        Selection.isTileSet = false;
        Selection.selectGraphic = ImageTools.cut(drawLayer(currentLayer),Selection.fin.x - Selection.ini.x, Selection.fin.y - Selection.ini.y, Selection.ini.x, Selection.ini.y);
        for(int y = Selection.ini.y; y<Selection.fin.y; y+=th){
            for(int x = Selection.ini.x; x<Selection.fin.x; x+=tw){
                try{
                    Selection.selection.add(layerTile.get(currentLayer).get(searchTile(new Point(x,y))).clone());
                }
                catch(Exception ex){
                    System.out.println("FileNotfound");
                }
            }
        }
        
    }
/* Metodos pribados */
    /* :Final: para funciones especificas del sistema */
    private ArrayList<Tile> createEmptyTile(){
        ArrayList<Tile> t = new ArrayList<>();
        return t;
    }
    
    private boolean isInside(Rectangle or, Rectangle in) {
        return or.intersects(in) && in.intersects(or);
    }
    
    /* :Final: Busca si existe tile en la posion vista */
    private void checkForTile(Tile t){
        System.out.println("T: "+t.x+","+t.y+" "+t.w+","+t.h);
        ArrayList<Tile> tt = new ArrayList<>();
        boolean checked = false;
        for(Tile c: layerTile.get(currentLayer)){
            System.out.print("C: "+c.x+","+c.y+" "+c.w+","+c.h);
            if(isInside(new Rectangle(c.x,c.y,c.w,c.h), new Rectangle(t.x,t.y,t.w,t.h))){
                System.out.println(" Pertenece:");
                if(!checked){
                    tt.add(t);
                    checked = true;
                }
            }
            else{
                System.out.println(" No pertenece:");
                tt.add(c);
            }
        }
        if(layerTile.get(currentLayer).isEmpty() || !checked){
            tt.add(t);
        }
        layerTile.remove(currentLayer);
        layerTile.add(currentLayer,tt);
    }
    /* Busca que tileset es el utilizado */
    private int checkForTileSet(String btString){
        int where = 0;
        for( BackgroundTile bt : container.Container.bts){
            if (bt.sameMap(btString)){
                return where;
            }
            where++;
        }
        return 0;
    }
    private int searchTile(Point p) throws FileNotFoundException{
        int pos = 0;
        for(Tile e : layerTile.get(currentLayer)){
            if(e.x == p.x && e.y == p.y){
                return pos;
            }
            pos++;
        }
        throw new FileNotFoundException();
    }
    private BufferedImage drawLayer(int layer){
        BufferedImage blank = ImageTools.clone(iperma);
        for(Tile t : layerTile.get(layer)){
            if(!t.bgName.equals(NO_BACKGROUND)){
                ImageTools.copyPaste(container.Container.bts.get(checkForTileSet(t.bgName)).getImageInPoint(new Point(t.xo,t.yo)), t.x, t.y, blank);
            }
        }
        return blank;
    }
    
}
