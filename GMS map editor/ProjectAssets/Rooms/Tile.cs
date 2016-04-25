using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GMSMapEditor.ProjectAssets.Rooms
{
    public class Tile
    {
        public string bgName = "";
        public string name;
        public string colour = "4294967295";
        public double scaleX = 1;
        public double scaleY = 1;
        public bool locked = false;
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
            Random random = new Random();
            this.name = "inst_" + random.Next(0, 999999999);
        }
    }
}
