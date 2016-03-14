using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GMSMapEditor.ProjectAssets.Rooms
{
    public class View
    {
        public bool visible = false;
        public string objName = "";
        public int xview = 0;
        public int yview = 0;
        public int wview = 1024;
        public int hview = 768;
        public int xport = 0;
        public int yport = 0;
        public int wport = 1024;
        public int hport = 768;
        public int hborder = 32;
        public int vborder = 32;
        public int hspeed = -1;
        public int vspeed = -1;
    }
}
