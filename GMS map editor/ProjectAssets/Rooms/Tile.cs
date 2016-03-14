using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GMSMapEditor.ProjectAssets.Rooms
{
    public class Tile
    {
        public string bgName = "";
        public int x = 0;
        public int y = 0;
        public int w = 0;
        public int h = 0;
        public int xo = 0;
        public int yo = 0;
        public int id = 10000000;
        public string name = "inst_";
        public int depth = 1000000;
        public bool locked = false;
        public string colour = "4294967295";
        public double scaleX = 1;
        public double scaleY = 1;
    }
}
