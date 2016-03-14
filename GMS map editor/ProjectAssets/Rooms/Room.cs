using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net;
using System.Xml;
using System.IO;
using GMSMapEditor.Classes;

namespace GMSMapEditor.ProjectAssets.Rooms
{
    public class Room
    {
        public string caption = "";
        public int width = 1024;
        public int height = 768;
        public int vsnap = 16;
        public int hsnap = 16;
        public int isometric = 0; //??
        public int speed = 30;
        public bool persistent = false;
        public int colour = 255;
        public bool showcolour = true;
        public string code = "";
        public bool enableViews = true;
        public bool clearViewBackground = false;
        public bool clearDisplayBuffer = true;
        public bool PhysicsWorld = false;
        public int PhysicsWorldTop = 0;
        public int PhysicsWorldLeft = 0;
        public int PhysicsWorldRight = 1024;
        public int PhysicsWorldBottom = 768;
        public int PhysicsWorldGravityX = 0;
        public int PhysicsWorldGravityY = 10;
        public double PhysicsWorldPixToMeters = 0.100000001490116;
        public MakerSettings makerSettings = new MakerSettings();
        public List<Background> backgrounds = new List<Background>();
        public List<View> views = new List<View>();
        public List<Instance> instances = new List<Instance>();
        public List<Tile> tiles = new List<Tile>();

        public void RoomRead(string xmlFile)
        {
            String xmlString = File.ReadAllText(xmlFile).ToString();
            using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
            {
                int num = Project.assets.rooms.Count - 1;
                reader.ReadToFollowing("caption");
                Project.assets.rooms[num].caption = reader.ReadElementContentAsString();
                reader.ReadToFollowing("width");
                Project.assets.rooms[num].width = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("height");
                Project.assets.rooms[num].height = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("vsnap");
                Project.assets.rooms[num].vsnap = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("hsnap");
                Project.assets.rooms[num].hsnap = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("isometric");
                Project.assets.rooms[num].isometric = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("speed");
                Project.assets.rooms[num].speed = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("persistent");
                Project.assets.rooms[num].persistent = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("colour");
                Project.assets.rooms[num].colour = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("showcolour");
                Project.assets.rooms[num].showcolour = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("code");
                Project.assets.rooms[num].code = reader.ReadElementContentAsString();
                reader.ReadToFollowing("enableViews");
                Project.assets.rooms[num].enableViews = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("clearViewBackground");
                Project.assets.rooms[num].clearViewBackground = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("clearDisplayBuffer");
                Project.assets.rooms[num].clearDisplayBuffer = Convert.ToBoolean(reader.ReadElementContentAsInt());

                reader.ReadToFollowing("makerSettings");
                reader.ReadToFollowing("isSet");
                Project.assets.rooms[num].makerSettings.isSet = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("w");
                Project.assets.rooms[num].makerSettings.w = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("h");
                Project.assets.rooms[num].makerSettings.h = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("showGrid");
                Project.assets.rooms[num].makerSettings.showGrid = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("showObjects");
                Project.assets.rooms[num].makerSettings.showObjects = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("showTiles");
                Project.assets.rooms[num].makerSettings.showTiles = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("showBackgrounds");
                Project.assets.rooms[num].makerSettings.showBackgrounds = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("showForegrounds");
                Project.assets.rooms[num].makerSettings.showForegrounds = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("showViews");
                Project.assets.rooms[num].makerSettings.showViews = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("deleteUnderlyingObj");
                Project.assets.rooms[num].makerSettings.deleteUnderlyingObj = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("deleteUnderlyingTiles");
                Project.assets.rooms[num].makerSettings.deleteUnderlyingTiles = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("page");
                Project.assets.rooms[num].makerSettings.page = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("xoffset");
                Project.assets.rooms[num].makerSettings.xoffset = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("yoffset");
                Project.assets.rooms[num].makerSettings.yoffset = reader.ReadElementContentAsInt();

                int i = 0;
                reader.ReadToFollowing("background");
                do
                {
                    Project.assets.rooms[num].backgrounds.Add(new ProjectAssets.Rooms.Background());
                    Project.assets.rooms[num].backgrounds[i].visible = Convert.ToBoolean(Convert.ToInt32(reader.GetAttribute("visible")));
                    Project.assets.rooms[num].backgrounds[i].foreground = Convert.ToBoolean(Convert.ToInt32(reader.GetAttribute("foreground")));
                    Project.assets.rooms[num].backgrounds[i].name = reader.GetAttribute("name");
                    Project.assets.rooms[num].backgrounds[i].x = Convert.ToInt32(reader.GetAttribute("x"));
                    Project.assets.rooms[num].backgrounds[i].y = Convert.ToInt32(reader.GetAttribute("y"));
                    Project.assets.rooms[num].backgrounds[i].htiled = Convert.ToBoolean(Convert.ToInt32(reader.GetAttribute("htiled")));
                    Project.assets.rooms[num].backgrounds[i].vtiled = Convert.ToBoolean(Convert.ToInt32(reader.GetAttribute("vtiled")));
                    Project.assets.rooms[num].backgrounds[i].hspeed = Convert.ToInt32(reader.GetAttribute("hspeed"));
                    Project.assets.rooms[num].backgrounds[i].vspeed = Convert.ToInt32(reader.GetAttribute("vspeed"));
                    Project.assets.rooms[num].backgrounds[i].stretch = Convert.ToBoolean(Convert.ToInt32(reader.GetAttribute("stretch")));
                    i++;
                } while (reader.ReadToNextSibling("background"));

                i = 0;
                reader.ReadToFollowing("view");
                do
                {
                    Project.assets.rooms[num].views.Add(new ProjectAssets.Rooms.View());
                    Project.assets.rooms[num].views[i].visible = Convert.ToBoolean(Convert.ToInt32(reader.GetAttribute("visible")));
                    Project.assets.rooms[num].views[i].objName = reader.GetAttribute("objName");
                    Project.assets.rooms[num].views[i].xview = Convert.ToInt32(reader.GetAttribute("xview"));
                    Project.assets.rooms[num].views[i].yview = Convert.ToInt32(reader.GetAttribute("yview"));
                    Project.assets.rooms[num].views[i].wview = Convert.ToInt32(reader.GetAttribute("wview"));
                    Project.assets.rooms[num].views[i].hview = Convert.ToInt32(reader.GetAttribute("hview"));
                    Project.assets.rooms[num].views[i].xport = Convert.ToInt32(reader.GetAttribute("xport"));
                    Project.assets.rooms[num].views[i].yport = Convert.ToInt32(reader.GetAttribute("yport"));
                    Project.assets.rooms[num].views[i].wport = Convert.ToInt32(reader.GetAttribute("wport"));
                    Project.assets.rooms[num].views[i].hport = Convert.ToInt32(reader.GetAttribute("hport"));
                    Project.assets.rooms[num].views[i].hborder = Convert.ToInt32(reader.GetAttribute("hborder"));
                    Project.assets.rooms[num].views[i].vborder = Convert.ToInt32(reader.GetAttribute("vborder"));
                    Project.assets.rooms[num].views[i].hspeed = Convert.ToInt32(reader.GetAttribute("hspeed"));
                    Project.assets.rooms[num].views[i].vspeed = Convert.ToInt32(reader.GetAttribute("vspeed"));
                    i++;
                } while (reader.ReadToNextSibling("view"));

                i = 0;
                reader.ReadToFollowing("instances");
                if (!reader.IsEmptyElement)
                {
                    reader.ReadToFollowing("instance");
                    do
                    {
                        Project.assets.rooms[num].instances.Add(new ProjectAssets.Rooms.Instance());
                        Project.assets.rooms[num].instances[i].objName = reader.GetAttribute("objName");
                        Project.assets.rooms[num].instances[i].x = Convert.ToInt32(reader.GetAttribute("x"));
                        Project.assets.rooms[num].instances[i].y = Convert.ToInt32(reader.GetAttribute("y"));
                        Project.assets.rooms[num].instances[i].name = reader.GetAttribute("name");
                        Project.assets.rooms[num].instances[i].locked = Convert.ToBoolean(Convert.ToInt32(reader.GetAttribute("locked")));
                        Project.assets.rooms[num].instances[i].code = reader.GetAttribute("code");
                        Project.assets.rooms[num].instances[i].scaleX = Convert.ToDouble(reader.GetAttribute("scaleX"));
                        Project.assets.rooms[num].instances[i].scaleY = Convert.ToDouble(reader.GetAttribute("scaleY"));
                        Project.assets.rooms[num].instances[i].colour = reader.GetAttribute("colour");
                        Project.assets.rooms[num].instances[i].rotation = Convert.ToDouble(reader.GetAttribute("rotation"));
                        i++;
                    } while (reader.ReadToNextSibling("instance"));
                }

                i = 0;
                reader.ReadToFollowing("tiles");
                if (!reader.IsEmptyElement)
                {
                    reader.ReadToFollowing("tile");
                    do
                    {
                        //MessageBox.Show(reader.GetAttribute("bgName"));
                        Project.assets.rooms[num].tiles.Add(new ProjectAssets.Rooms.Tile());
                        Project.assets.rooms[num].tiles[i].bgName = reader.GetAttribute("bgName");
                        Project.assets.rooms[num].tiles[i].x = Convert.ToInt32(reader.GetAttribute("x"));
                        Project.assets.rooms[num].tiles[i].y = Convert.ToInt32(reader.GetAttribute("y"));
                        Project.assets.rooms[num].tiles[i].w = Convert.ToInt32(reader.GetAttribute("w"));
                        Project.assets.rooms[num].tiles[i].h = Convert.ToInt32(reader.GetAttribute("h"));
                        Project.assets.rooms[num].tiles[i].xo = Convert.ToInt32(reader.GetAttribute("xo"));
                        Project.assets.rooms[num].tiles[i].yo = Convert.ToInt32(reader.GetAttribute("yo"));
                        Project.assets.rooms[num].tiles[i].id = Convert.ToInt32(reader.GetAttribute("id"));
                        Project.assets.rooms[num].tiles[i].name = reader.GetAttribute("name");
                        Project.assets.rooms[num].tiles[i].depth = Convert.ToInt32(reader.GetAttribute("depth"));
                        Project.assets.rooms[num].tiles[i].locked = Convert.ToBoolean(Convert.ToInt32(reader.GetAttribute("locked")));
                        Project.assets.rooms[num].tiles[i].colour = reader.GetAttribute("colour");
                        Project.assets.rooms[num].tiles[i].scaleX = Convert.ToDouble(reader.GetAttribute("scaleX"));
                        Project.assets.rooms[num].tiles[i].scaleY = Convert.ToDouble(reader.GetAttribute("scaleY"));
                        i++;
                    } while (reader.ReadToNextSibling("tile"));
                }

                reader.ReadToFollowing("PhysicsWorld");
                Project.assets.rooms[num].PhysicsWorld = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("PhysicsWorldTop");
                Project.assets.rooms[num].PhysicsWorldTop = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("PhysicsWorldLeft");
                Project.assets.rooms[num].PhysicsWorldLeft = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("PhysicsWorldRight");
                Project.assets.rooms[num].PhysicsWorldRight = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("PhysicsWorldBottom");
                Project.assets.rooms[num].PhysicsWorldBottom = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("PhysicsWorldGravityX");
                Project.assets.rooms[num].PhysicsWorldGravityX = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("PhysicsWorldGravityY");
                Project.assets.rooms[num].PhysicsWorldGravityY = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("PhysicsWorldPixToMeters");
                Project.assets.rooms[num].PhysicsWorldPixToMeters = reader.ReadElementContentAsDouble();
                reader.ReadToFollowing("caption");
            }
        }

        public override String ToString()
        {
            string backgroundsTag = "";
            string viewsTag = "";
            string instancesTag = "  <instances/>\n";
            string tilesTag = "  <tiles/>\n";

            if (instances.Count > 0)
            {
                instancesTag = "  <instances>\n";
                foreach (Instance instance in instances)
                {
                    instancesTag += "    <instance objName=\"" + instance.objName + "\" x=\"" + instance.x + "\" y=\"" + instance.y + "\" name=\"" + instance.name + "\" locked=\"" + Convert.ToInt32(instance.locked) * -1 + "\" code=\"" + instance.code + "\" scaleX=\"" + instance.scaleX + "\" scaleY=\"" + instance.scaleY + "\" colour=\"" + instance.colour + "\" rotation=\"" + instance.rotation + "\"/>\n";
                }
                instancesTag += "  </instances>\n";
            }

            if (tiles.Count > 0)
            {
                tilesTag = "  <tiles>\n";
                foreach (Tile tile in tiles)
                {
                    tilesTag += "    <tile bgName=\"" + tile.bgName + "\" x=\"" + tile.x + "\" y=\"" + tile.y + "\" w=\"" + tile.w + "\" h=\"" + tile.h + "\" xo=\"" + tile.xo + "\" yo=\"" + tile.yo + "\" id=\"" + tile.id + "\" name=\"" + tile.name + "\" depth=\"" + tile.depth + "\" locked=\"" + Convert.ToInt32(tile.locked) * -1 + "\" colour=\"" + tile.colour + "\" scaleX=\"" + tile.scaleX + "\" scaleY=\"" + tile.scaleY + "\"/>\n";
                }
                tilesTag += "  </tiles>\n";
            }

            backgroundsTag += "  <backgrounds>\n";
            foreach(Background background in backgrounds)
            {
                backgroundsTag += "    <background visible=\"" + Convert.ToInt32(background.visible) * -1 + "\" foreground=\"" + Convert.ToInt32(background.foreground) * -1 + "\" name=\"" + background.name + "\" x=\"" + background.x + "\" y=\"" + background.y + "\" htiled=\"" + Convert.ToInt32(background.htiled) * -1 + "\" vtiled=\"" + Convert.ToInt32(background.vtiled) * -1 + "\" hspeed=\"" + background.hspeed + "\" vspeed=\"" + background.vspeed + "\" stretch=\"" + Convert.ToInt32(background.stretch) * -1 + "\"/>\n";
            }
            backgroundsTag += "  </backgrounds>\n";

            viewsTag += "  <views>\n";
            foreach (View view in views)
            {
                viewsTag += "    <view visible=\"" + Convert.ToInt32(view.visible) * -1 + "\" objName=\"" + WebUtility.HtmlEncode(view.objName) + "\" xview=\"" + view.xview + "\" yview=\"" + view.yview + "\" wview=\"" + view.wview + "\" hview=\"" + view.hview + "\" xport=\"" + view.xport + "\" yport=\"" + view.yport + "\" wport=\"" + view.wport + "\" hport=\"" + view.hport + "\" hborder=\"" + view.hborder + "\" vborder=\"" + view.vborder + "\" hspeed=\"" + view.hspeed + "\" vspeed=\"" + view.vspeed + "\"/>\n";
            }
            viewsTag += "  </views>\n";

            return  "<!--This Document is generated by GameMaker, if you edit it by hand then you do so at your own risk!-->\n" +
                    "<room>\n" +
                    "  <caption>" + caption + "</caption>\n" +
                    "  <width>" + width + "</width>\n" +
                    "  <height>" + height + "</height>\n" +
                    "  <vsnap>" + vsnap + "</vsnap>\n" +
                    "  <hsnap>" + hsnap + "</hsnap>\n" +
                    "  <isometric>" + isometric + "</isometric>\n" +
                    "  <speed>" + speed + "</speed>\n" +
                    "  <persistent>" + Convert.ToInt32(persistent) * -1 + "</persistent>\n" +
                    "  <colour>" + colour + "</colour>\n" +
                    "  <showcolour>" + Convert.ToInt32(showcolour) * -1 + "</showcolour>\n" +
                    "  <code>" + code + "</code>\n" +
                    "  <enableViews>" + Convert.ToInt32(enableViews) * -1 + "</enableViews>\n" +
                    "  <clearViewBackground>" + Convert.ToInt32(clearViewBackground) * -1 + "</clearViewBackground>\n" +
                    "  <clearDisplayBuffer>" + Convert.ToInt32(clearDisplayBuffer) * -1 + "</clearDisplayBuffer>\n" +
                    "  <makerSettings>\n" +
                    "    <isSet>" + Convert.ToInt32(makerSettings.isSet) * -1 + "</isSet>\n" +
                    "    <w>" + makerSettings.w + "</w>\n" +
                    "    <h>" + makerSettings.h + "</h>\n" +
                    "    <showGrid>" + Convert.ToInt32(makerSettings.showGrid) * -1 + "</showGrid>\n" +
                    "    <showObjects>" + Convert.ToInt32(makerSettings.showObjects) * -1 + "</showObjects>\n" +
                    "    <showTiles>" + Convert.ToInt32(makerSettings.showTiles) * -1 + "</showTiles>\n" +
                    "    <showBackgrounds>" + Convert.ToInt32(makerSettings.showBackgrounds) * -1 + "</showBackgrounds>\n" +
                    "    <showForegrounds>" + Convert.ToInt32(makerSettings.showForegrounds) * -1 + "</showForegrounds>\n" +
                    "    <showViews>" + Convert.ToInt32(makerSettings.showViews) * -1 + "</showViews>\n" +
                    "    <deleteUnderlyingObj>" + Convert.ToInt32(makerSettings.deleteUnderlyingObj) * -1 + "</deleteUnderlyingObj>\n" +
                    "    <deleteUnderlyingTiles>" + Convert.ToInt32(makerSettings.deleteUnderlyingTiles) * -1 + "</deleteUnderlyingTiles>\n" +
                    "    <page>" + makerSettings.page + "</page>\n" +
                    "    <xoffset>" + makerSettings.xoffset + "</xoffset>\n" +
                    "    <yoffset>" + makerSettings.yoffset + "</yoffset>\n" +
                    "  </makerSettings>\n" +
                    backgroundsTag +
                    viewsTag +
                    instancesTag +
                    tilesTag +
                    "  <PhysicsWorld>" + Convert.ToInt32(PhysicsWorld) * -1 + "</PhysicsWorld>\n" +
                    "  <PhysicsWorldTop>" + PhysicsWorldTop + "</PhysicsWorldTop>\n" +
                    "  <PhysicsWorldLeft>" + PhysicsWorldLeft + "</PhysicsWorldLeft>\n" +
                    "  <PhysicsWorldRight>" + PhysicsWorldRight + "</PhysicsWorldRight>\n" +
                    "  <PhysicsWorldBottom>" + PhysicsWorldBottom + "</PhysicsWorldBottom>\n" +
                    "  <PhysicsWorldGravityX>" + PhysicsWorldGravityX + "</PhysicsWorldGravityX>\n" +
                    "  <PhysicsWorldGravityY>" + PhysicsWorldGravityY + "</PhysicsWorldGravityY>\n" +
                    "  <PhysicsWorldPixToMeters>" + PhysicsWorldPixToMeters + "</PhysicsWorldPixToMeters>\n" +
                    "</room>";
        }
    }
}
