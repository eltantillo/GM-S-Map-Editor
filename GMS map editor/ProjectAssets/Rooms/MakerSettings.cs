using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GMSMapEditor.ProjectAssets.Rooms
{
    public class MakerSettings
    {
        public bool isSet = false;
        public int w = 0;
        public int h = 0;
        public bool showGrid = true;
        public bool showObjects = false;
        public bool showTiles = false;
        public bool showBackgrounds = false;
        public bool showForegrounds = false;
        public bool showViews = false;
        public bool deleteUnderlyingObj = false;
        public bool deleteUnderlyingTiles = false;
        public int page = 0;
        public int xoffset = 0;
        public int yoffset = 0;
    }
}
