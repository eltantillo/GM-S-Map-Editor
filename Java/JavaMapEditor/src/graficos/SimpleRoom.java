package graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import xml.projectAssets.rooms.Room;
import xml.projectAssets.backgrounds.Background;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import xml.projectAssets.rooms.Tile;


public class SimpleRoom {
    private int w, h,tw,th;
    private int currentLayer;
    private ArrayList<ArrayList<Tile>> layerTile;
    
    private Stack<ArrayList<ArrayList<Tile>>> undo;
    private Stack<ArrayList<ArrayList<Tile>>> redo;
    
    private ArrayList<Integer> layerDepth;
    private boolean grid,preview,inMap;
    int prevX,prevY;
    
  
// Constantes //
    private static final String NO_BACKGROUND = "NONE_BACKGROUND_FOUND";
    
    /**
     * Este es el constructor que inicializa a partir de un room
     * @param r
     */
    public SimpleRoom(Room r){
        layerDepth = new ArrayList<>();
        // Cargando los Tiles //
        layerTile = new ArrayList<>();
        
        Collections.sort(r.tiles, new Comparator<Tile>() {
            @Override
            public int compare(Tile o1, Tile o2) {
                return new Integer(o2.depth).compareTo(new Integer(o1.depth));
            }
        });
        
        for(Tile t : r.tiles){
            setTile(t);
        }
        
        currentLayer = 0;
        w = r.width;
        h = r.height;
        
        tw = 32;
        th = 32;
        undo = new Stack();
        redo = new Stack();
    }
    /**
     * Este metodo activa o desactiva el grid visual en el Map Area
     * @param 
     */
    public void grid(){
        grid =! grid;
    }
    /**
     * Este metodo activa o desactiva las capas superiores
     * @param 
     */
    public void topLayer(){
        preview =! preview;
    }
    
    /**
     * cambia la grid por la nueva. Requiere width y height del cuadro nuevo en
     * el grid
     * @param tw
     * @param th 
     */
    public void changeGrid(int tw, int th){
        this.tw = tw;
        this.th = th;
    }
    /**
     * Metodo que guarda los cambios al dar click en el mapa.
     * @param p 
     * @param youClickedX
     * @param youClickedY 
     */
    public void click(JLabel inf,JLabel top,int youClickedX, int youClickedY){
        youClickedX = toGrid(youClickedX, 1);
        youClickedY = toGrid(youClickedY, 2);
        if(prevX != youClickedX || prevY !=youClickedY){
            undo.add((ArrayList)layerTile.clone());
            ArrayList<Tile> selection = Selection.selection;
            if(Selection.isTileSet){
                for(Tile tile : selection){
                    Tile temp = tile.clone();
                    temp.x = youClickedX + tile.x*tile.w;
                    temp.y = youClickedY + tile.y*tile.h;
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
            update(inf,top);
            prevX = youClickedX;
            prevY = youClickedY;
        }
    }
    /**
     * Permite cambiar de capa, Si la capa no existe crea la capa nueva
     * @param x 
     */
    public void changeLayer(int x){
        for(Integer d : layerDepth){
            if(d.equals(x)){
                currentLayer = layerDepth.indexOf(d);
                return;
            }
        }
        // no existe la capa //
        layerDepth.add(x);
        // agregamos la capa a la lista de capas //
        ArrayList<Tile> ts = new ArrayList();
        Tile t = new Tile();
        t.depth = x;
        ts.add(t);
        layerTile.add(ts);
        Collections.sort(layerTile, new Comparator<ArrayList<Tile>>() {
            @Override
            public int compare(ArrayList<Tile> t, ArrayList<Tile> t2) {
                return new Integer(t2.get(0).depth).compareTo(t.get(0).depth);
            }
        });
        layerTile.get(layerTile.indexOf(ts)).remove(t);
        Collections.sort(layerDepth, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            }
        );
        changeLayer(x);
    }
    /**
     * Actualiza interfaz grafica... 
     * @param p
     * @param x
     * @param y 
     */
    public void update(JLabel inf, JLabel sup){
        // Dibuja los tiles existentes //
        BufferedImage infBI = new BufferedImage( w + 1 , h + 1  , BufferedImage.TYPE_INT_ARGB);
        BufferedImage topBI = new BufferedImage( w + 1 , h + 1  , BufferedImage.TYPE_INT_ARGB);
        
        // Actualiza grafico //
        inf.setLocation(new Point(0,0));
        inf.setMinimumSize(new Dimension(infBI.getWidth(), infBI.getHeight()));
    	inf.setPreferredSize(new Dimension(infBI.getWidth(), infBI.getHeight()));
    	inf.setMaximumSize(new Dimension(infBI.getWidth(), infBI.getHeight()));
        inf.setIcon(new ImageIcon(infBI));
        sup.setMinimumSize(new Dimension(topBI.getWidth(), topBI.getHeight()));
        sup.setPreferredSize(new Dimension(topBI.getWidth(), topBI.getHeight()));
        sup.setMaximumSize(new Dimension(topBI.getWidth(), topBI.getHeight()));
        sup.setIcon(new ImageIcon(topBI));
        
        // por cada capa dibuja tus tiles //
        for(int tempX = 0; tempX<layerTile.size(); tempX++){
            if(tempX<currentLayer){
                infBI = ImageTools.copyPaste(drawLayer(tempX), 0, 0, infBI);
            }
            else if(tempX==currentLayer){
                if(!preview)
                    ImageTools.setAlpha(infBI);
                infBI = ImageTools.copyPaste(drawLayer(tempX), 0, 0, infBI);
            }
            else if(preview){
                topBI = ImageTools.copyPaste(drawLayer(tempX), 0, 0, topBI);
            }
            else{
                topBI = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);
            }
        }
        
        // Dibujando Grid //
        if(grid){
            for(int tempX = 0; tempX<w; tempX+=tw){
                for(int tempY =0; tempY<h; tempY+=th ){
                    Graphics g = infBI.getGraphics();
                    g.setColor(Color.WHITE);
                    g.drawRect(tempX,tempY,tw,th);
                }
            }
        }
        
        // dibuja seleccion //
        if(!Selection.isTileSet){
            Graphics g = infBI.getGraphics();
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
        
        
    }
    /**
     * Constructor basico para crear nuevo SimpleRoom a partir de datos nuevos.
     * Este metodo seria util a la hora de crear otro SimpleRoom nuevo.
     * @param _w
     * @param _h
     * @param _tw
     * @param _th 
     */
    public SimpleRoom(int _w,int _h, int _tw, int _th){
        w = _w* _tw;
        h = _h* _th;
        tw = _tw;
        th = _th;
        currentLayer = 0;
        
        layerTile = new ArrayList<>();
        
        // Agregando 5 capas //
        layerTile.add(new ArrayList<>());
        
        undo = new Stack();
        redo = new Stack();
    }
    /**
     * Este metodo es para agregar la selccion del rectangulo en el mapa
     * @param inicio
     * @param fin 
     */
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
                    System.out.println("SimpleRoom.setSelection.exeption: "+ex);
                }
            }
        }
    }
    public String[] getDephts(){
        String [] strs = new String[layerDepth.size()];
        for(int dep: layerDepth){
            strs[layerDepth.indexOf(dep)] = dep +"";
        }
        return strs;
    }
/* Metodos pribados La muerte le espera a quien se oponga a este mensaje*/
    private boolean isInside(Rectangle or, Rectangle in) {
        return or.intersects(in) && in.intersects(or);
    }
    /* :Final: Busca si existe tile en la posion vista */
    private void checkForTile(Tile t){
        ArrayList<Tile> tt = new ArrayList<>();
        boolean checked = false;
        try{
            for(Tile c: layerTile.get(currentLayer)){
                if(isInside(new Rectangle(c.x,c.y,c.w,c.h), new Rectangle(t.x,t.y,t.w,t.h))){
                    if(!checked){
                        tt.add(t);
                        checked = true;
                    }
                }
                else{
                    tt.add(c);
                }
            }
        }
        catch(IndexOutOfBoundsException ex){
            layerTile.add(new ArrayList());
            System.out.println("SimpleRoom.checkForTile: "+ex);
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
        for(Background bt: xml.Project.assets.backgrounds){
            if (btString.equals(bt.name)){
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
        BufferedImage blank = new BufferedImage( w + 1 , h + 1  , BufferedImage.TYPE_INT_ARGB);
        for(Tile t : layerTile.get(layer)){
            if(!t.bgName.equals(NO_BACKGROUND)){
                ImageTools.copyPaste(xml.Project.assets.backgroundT.get(checkForTileSet(t.bgName)).getImageInPoint(new Point(t.xo,t.yo)), t.x, t.y, blank);
            }
        }
        return blank;
    }
    private int toGrid(int mouse, int type){
        return ((int)Math.floor(mouse / (type == 1 ? tw : th)) * (type == 1 ? tw : th));
    }
    private void setTile(Tile t){
        for(ArrayList<Tile> layer : layerTile){
            for(Tile tt: layer){
                if(tt.depth == t.depth){
                    layer.add(t);
                    return;
                }
            }
        }
        ArrayList<Tile> tiles = new ArrayList();
        layerDepth.add(t.depth);
        tiles.add(t);
        layerTile.add(tiles);
    }
    public void undo(){
        if(!undo.isEmpty()){
            ArrayList l = undo.pop();
            redo.push((ArrayList)l.clone());
            layerTile = l;
        }
    }
    public void redo(){
        if(!redo.isEmpty()){
            ArrayList l = redo.pop();
            undo.push((ArrayList)l.clone());
            layerTile = l;
        }
    }
    public void showSelection(boolean show){
        inMap = show;
    }
    public void updateSelection(JLabel sel,int x,int y){
        if(Selection.selectGraphic!=null){
            BufferedImage blank = new BufferedImage(w+1, h+1, BufferedImage.TYPE_4BYTE_ABGR);
            x = toGrid(x, 1);
            y = toGrid(y, 0);
            sel.setMinimumSize(new Dimension(Selection.selectGraphic.getWidth(), Selection.selectGraphic.getHeight()));
            sel.setPreferredSize(new Dimension(Selection.selectGraphic.getWidth(), Selection.selectGraphic.getHeight()));
            sel.setMaximumSize(new Dimension(Selection.selectGraphic.getWidth(), Selection.selectGraphic.getHeight()));
            blank = ImageTools.copyPaste(Selection.selectGraphic, x, y, blank);
            
            sel.setIcon(new ImageIcon(blank));
            sel.setVisible(inMap);
        }
    }
    /**
     * Este metodo permite mover una capa entre depths, what: que capa quieres
     * to: a donde quieres mover la nueva capa.
     * Si "to" existe lo combina con la capa a mover.
     * Esta accion permite ctrl+z
     * @param what
     * @param to 
     */
    public void changeLayer(int what, int to){
        undo.push(layerTile);
        int existe = layerDepth.indexOf(to);
        if(existe>=0){ //fusiona capas //
            currentLayer = to;
            for(Tile t : layerTile.get(existe)){ // por cada tile en la capa
                t.depth = to; //cambia de depth//
                checkForTile(t); //fusionalo//
            }    
        }
        else{
            currentLayer = to;
            layerDepth.add(to); //agregamos capa//
            layerDepth.remove(what); //borramos capa anterior//
            
            for(Tile t: layerTile.get(what)){ //movemos la capa//
                t.depth = to;
            }
            Collections.sort(layerTile, new Comparator<ArrayList<Tile>>() { //reordenamos//
                @Override
                public int compare(ArrayList<Tile> t, ArrayList<Tile> t2) {
                    return new Integer(t2.get(0).depth).compareTo(t.get(0).depth);
                }
            });
            Collections.sort(layerDepth, new Comparator<Integer>() {//reordenamos//
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                }
            );
        }
    }
    /**
     * Este metodo permite borrar la capa seleccionada. what es el depth de la
     * capa seleccionada.
     * Esta accion permite ctrl+z
     * @param what 
     */
    public void removeLayer(int what){
        if(layerDepth.indexOf(what)>=0){
            undo.push(layerTile);
            layerTile.remove(layerDepth.indexOf(what));
            layerDepth.remove(what);
        }
    }
}
