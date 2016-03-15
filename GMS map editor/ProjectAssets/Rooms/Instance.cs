using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GMSMapEditor.ProjectAssets.Rooms
{
    public class Instance
    {
        public string objName = "";
        public string name;
        public string code = "";
        public string colour = "4294967295";
        public double scaleX = 1;
        public double scaleY = 1;
        public double rotation = 0;
        public bool locked = false;
        public int x = 0;
        public int y = 0;

        public Instance()
        {
            Random random = new Random();
            this.name = "inst_" + random.Next(0, 999999999);
        }
    }
}
