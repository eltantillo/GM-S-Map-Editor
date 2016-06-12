/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.projectAssets.rooms;

/**
 *
 * @author eltan
 */
import java.util.concurrent.ThreadLocalRandom;

public class Tile {
    public String bgName = "";
    public String name;
    public String colour = "4294967295";
    public double scaleX = 1;
    public double scaleY = 1;
    public boolean locked = false;
    public int x = 0;//room
    public int y = 0;//room
    public int w = 0;
    public int h = 0;
    public int xo = 0;//tileset
    public int yo = 0;//tileset
    public int id = 10000000;
    public int depth = 1000000;

    public Tile()
    {
        this.name = "inst_" + Integer.toHexString(ThreadLocalRandom.current().nextInt(0, 999999999 + 1));
    }
    
    @Override
    public Tile clone(){
        Tile t = new Tile();
        t.bgName = bgName;
        t.name = name;
        t.colour = colour;
        t.scaleX = scaleX;
        t.scaleY = scaleY;
        t.locked = locked;
        t.x = x;//room
        t.y = y;//room
        t.w = w;
        t.h = h;
        t.xo = xo;//tileset
        t.yo = yo;//tileset
        t.id = id;
        return t;
    }
    
}