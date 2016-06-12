package graficos;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import xml.projectAssets.rooms.Tile;

public class Selection {
    public static Point ini = new Point(0,0), fin = new Point(0,0);
    public static ArrayList<Tile> selection;
    public static BufferedImage selectGraphic;
    public static boolean isTileSet = true;
    
}
