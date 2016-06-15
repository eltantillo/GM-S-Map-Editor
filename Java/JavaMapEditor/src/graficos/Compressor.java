/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.util.ArrayList;
import java.util.Stack;
import xml.projectAssets.rooms.Tile;

/**
 *
 * @author MarcoM
 */
public class Compressor {
    int w, h,tw,th;
    int currentLayer;
    ArrayList<ArrayList<Tile>> layerTile;
    ArrayList<Integer> layerDepth;
    boolean grid,preview,inMap;
    int prevX,prevY;
    
    public Compressor(){
    
    }
    
    public Compressor clone(){
        Compressor c = new Compressor();
        c.w = w;
        c.h = h;
        c.tw = tw;
        c.th = th;
        c.currentLayer = currentLayer;
        c.layerTile = (ArrayList) layerTile.clone();
        c.layerDepth = (ArrayList) layerDepth.clone();
        c.grid = grid;
        c.preview = preview;
        c.inMap = inMap;
        c.prevX = prevX;
        c.prevY = prevY;
        return c;
    }
}
