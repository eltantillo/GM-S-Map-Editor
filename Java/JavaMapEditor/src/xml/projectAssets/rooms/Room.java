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
import java.util.ArrayList;
import org.apache.commons.lang3.StringEscapeUtils;

public class Room {
    public boolean hasChanges = false;
    public boolean isNew = false;
    public String name = "";
    public String caption = "";
    public int width = 1024;
    public int height = 768;
    public int vsnap = 16;
    public int hsnap = 16;
    public int isometric = 0; //??

    public int speed = 30;
    public boolean persistent = false;
    public int colour = 255;
    public boolean showcolour = true;
    public String code = "";
    public boolean enableViews = true;
    public boolean clearViewBackground = false;
    public boolean clearDisplayBuffer = true;
    public boolean PhysicsWorld = false;
    public int PhysicsWorldTop = 0;
    public int PhysicsWorldLeft = 0;
    public int PhysicsWorldRight = 1024;
    public int PhysicsWorldBottom = 768;
    public int PhysicsWorldGravityX = 0;
    public int PhysicsWorldGravityY = 10;
    public double PhysicsWorldPixToMeters = 0.100000001490116;
    public MakerSettings makerSettings = new MakerSettings();
    public ArrayList<Background> backgrounds = new ArrayList<Background>();
    public ArrayList<View> views = new ArrayList<View>();
    public ArrayList<Instance> instances = new ArrayList<Instance>();
    public ArrayList<Tile> tiles = new ArrayList<Tile>();

    public void RoomRead(String xmlFile)
    {
        /*name = xmlFile.Split('\\')[1];
        xmlFile = MapEditor.Project.projectFolder + xmlFile + ".room.gmx";
        String xmlString = File.ReadAllText(xmlFile).ToString();
        using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
        {
            int num = MapEditor.Project.assets.rooms.Count - 1;
            reader.ReadToFollowing("caption");
            MapEditor.Project.assets.rooms[num].caption = reader.ReadElementContentAsString();
            reader.ReadToFollowing("width");
            MapEditor.Project.assets.rooms[num].width = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("height");
            MapEditor.Project.assets.rooms[num].height = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("vsnap");
            MapEditor.Project.assets.rooms[num].vsnap = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("hsnap");
            MapEditor.Project.assets.rooms[num].hsnap = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("isometric");
            MapEditor.Project.assets.rooms[num].isometric = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("speed");
            MapEditor.Project.assets.rooms[num].speed = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("persistent");
            MapEditor.Project.assets.rooms[num].persistent = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("colour");
            MapEditor.Project.assets.rooms[num].colour = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("showcolour");
            MapEditor.Project.assets.rooms[num].showcolour = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("code");
            MapEditor.Project.assets.rooms[num].code = reader.ReadElementContentAsString();
            reader.ReadToFollowing("enableViews");
            MapEditor.Project.assets.rooms[num].enableViews = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("clearViewBackground");
            MapEditor.Project.assets.rooms[num].clearViewBackground = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("clearDisplayBuffer");
            MapEditor.Project.assets.rooms[num].clearDisplayBuffer = Convert.Tobooleanean(reader.ReadElementContentAsInt());

            reader.ReadToFollowing("makerSettings");
            reader.ReadToFollowing("isSet");
            MapEditor.Project.assets.rooms[num].makerSettings.isSet = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("w");
            MapEditor.Project.assets.rooms[num].makerSettings.w = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("h");
            MapEditor.Project.assets.rooms[num].makerSettings.h = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("showGrid");
            MapEditor.Project.assets.rooms[num].makerSettings.showGrid = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("showObjects");
            MapEditor.Project.assets.rooms[num].makerSettings.showObjects = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("showTiles");
            MapEditor.Project.assets.rooms[num].makerSettings.showTiles = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("showBackgrounds");
            MapEditor.Project.assets.rooms[num].makerSettings.showBackgrounds = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("showForegrounds");
            MapEditor.Project.assets.rooms[num].makerSettings.showForegrounds = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("showViews");
            MapEditor.Project.assets.rooms[num].makerSettings.showViews = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("deleteUnderlyingObj");
            MapEditor.Project.assets.rooms[num].makerSettings.deleteUnderlyingObj = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("deleteUnderlyingTiles");
            MapEditor.Project.assets.rooms[num].makerSettings.deleteUnderlyingTiles = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("page");
            MapEditor.Project.assets.rooms[num].makerSettings.page = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("xoffset");
            MapEditor.Project.assets.rooms[num].makerSettings.xoffset = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("yoffset");
            MapEditor.Project.assets.rooms[num].makerSettings.yoffset = reader.ReadElementContentAsInt();

            int i = 0;
            reader.ReadToFollowing("background");
            do
            {
                MapEditor.Project.assets.rooms[num].backgrounds.Add(new ProjectAssets.Rooms.Background());
                MapEditor.Project.assets.rooms[num].backgrounds[i].visible = Convert.Tobooleanean(Convert.ToInt32(reader.GetAttribute("visible")));
                MapEditor.Project.assets.rooms[num].backgrounds[i].foreground = Convert.Tobooleanean(Convert.ToInt32(reader.GetAttribute("foreground")));
                MapEditor.Project.assets.rooms[num].backgrounds[i].name = reader.GetAttribute("name");
                MapEditor.Project.assets.rooms[num].backgrounds[i].x = Convert.ToInt32(reader.GetAttribute("x"));
                MapEditor.Project.assets.rooms[num].backgrounds[i].y = Convert.ToInt32(reader.GetAttribute("y"));
                MapEditor.Project.assets.rooms[num].backgrounds[i].htiled = Convert.Tobooleanean(Convert.ToInt32(reader.GetAttribute("htiled")));
                MapEditor.Project.assets.rooms[num].backgrounds[i].vtiled = Convert.Tobooleanean(Convert.ToInt32(reader.GetAttribute("vtiled")));
                MapEditor.Project.assets.rooms[num].backgrounds[i].hspeed = Convert.ToInt32(reader.GetAttribute("hspeed"));
                MapEditor.Project.assets.rooms[num].backgrounds[i].vspeed = Convert.ToInt32(reader.GetAttribute("vspeed"));
                MapEditor.Project.assets.rooms[num].backgrounds[i].stretch = Convert.Tobooleanean(Convert.ToInt32(reader.GetAttribute("stretch")));
                i++;
            } while (reader.ReadToNextSibling("background"));

            i = 0;
            reader.ReadToFollowing("view");
            do
            {
                MapEditor.Project.assets.rooms[num].views.Add(new ProjectAssets.Rooms.View());
                MapEditor.Project.assets.rooms[num].views[i].visible = Convert.Tobooleanean(Convert.ToInt32(reader.GetAttribute("visible")));
                MapEditor.Project.assets.rooms[num].views[i].objName = reader.GetAttribute("objName");
                MapEditor.Project.assets.rooms[num].views[i].xview = Convert.ToInt32(reader.GetAttribute("xview"));
                MapEditor.Project.assets.rooms[num].views[i].yview = Convert.ToInt32(reader.GetAttribute("yview"));
                MapEditor.Project.assets.rooms[num].views[i].wview = Convert.ToInt32(reader.GetAttribute("wview"));
                MapEditor.Project.assets.rooms[num].views[i].hview = Convert.ToInt32(reader.GetAttribute("hview"));
                MapEditor.Project.assets.rooms[num].views[i].xport = Convert.ToInt32(reader.GetAttribute("xport"));
                MapEditor.Project.assets.rooms[num].views[i].yport = Convert.ToInt32(reader.GetAttribute("yport"));
                MapEditor.Project.assets.rooms[num].views[i].wport = Convert.ToInt32(reader.GetAttribute("wport"));
                MapEditor.Project.assets.rooms[num].views[i].hport = Convert.ToInt32(reader.GetAttribute("hport"));
                MapEditor.Project.assets.rooms[num].views[i].hborder = Convert.ToInt32(reader.GetAttribute("hborder"));
                MapEditor.Project.assets.rooms[num].views[i].vborder = Convert.ToInt32(reader.GetAttribute("vborder"));
                MapEditor.Project.assets.rooms[num].views[i].hspeed = Convert.ToInt32(reader.GetAttribute("hspeed"));
                MapEditor.Project.assets.rooms[num].views[i].vspeed = Convert.ToInt32(reader.GetAttribute("vspeed"));
                i++;
            } while (reader.ReadToNextSibling("view"));

            i = 0;
            reader.ReadToFollowing("instances");
            if (!reader.IsEmptyElement)
            {
                reader.ReadToFollowing("instance");
                do
                {
                    MapEditor.Project.assets.rooms[num].instances.Add(new ProjectAssets.Rooms.Instance());
                    MapEditor.Project.assets.rooms[num].instances[i].objName = reader.GetAttribute("objName");
                    MapEditor.Project.assets.rooms[num].instances[i].x = Convert.ToInt32(reader.GetAttribute("x"));
                    MapEditor.Project.assets.rooms[num].instances[i].y = Convert.ToInt32(reader.GetAttribute("y"));
                    MapEditor.Project.assets.rooms[num].instances[i].name = reader.GetAttribute("name");
                    MapEditor.Project.assets.rooms[num].instances[i].locked = Convert.Tobooleanean(Convert.ToInt32(reader.GetAttribute("locked")));
                    MapEditor.Project.assets.rooms[num].instances[i].code = reader.GetAttribute("code");
                    MapEditor.Project.assets.rooms[num].instances[i].scaleX = Convert.ToDouble(reader.GetAttribute("scaleX"));
                    MapEditor.Project.assets.rooms[num].instances[i].scaleY = Convert.ToDouble(reader.GetAttribute("scaleY"));
                    MapEditor.Project.assets.rooms[num].instances[i].colour = reader.GetAttribute("colour");
                    MapEditor.Project.assets.rooms[num].instances[i].rotation = Convert.ToDouble(reader.GetAttribute("rotation"));
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
                    MapEditor.Project.assets.rooms[num].tiles.Add(new ProjectAssets.Rooms.Tile());
                    MapEditor.Project.assets.rooms[num].tiles[i].bgName = reader.GetAttribute("bgName");
                    MapEditor.Project.assets.rooms[num].tiles[i].x = Convert.ToInt32(reader.GetAttribute("x"));
                    MapEditor.Project.assets.rooms[num].tiles[i].y = Convert.ToInt32(reader.GetAttribute("y"));
                    MapEditor.Project.assets.rooms[num].tiles[i].w = Convert.ToInt32(reader.GetAttribute("w"));
                    MapEditor.Project.assets.rooms[num].tiles[i].h = Convert.ToInt32(reader.GetAttribute("h"));
                    MapEditor.Project.assets.rooms[num].tiles[i].xo = Convert.ToInt32(reader.GetAttribute("xo"));
                    MapEditor.Project.assets.rooms[num].tiles[i].yo = Convert.ToInt32(reader.GetAttribute("yo"));
                    MapEditor.Project.assets.rooms[num].tiles[i].id = Convert.ToInt32(reader.GetAttribute("id"));
                    MapEditor.Project.assets.rooms[num].tiles[i].name = reader.GetAttribute("name");
                    MapEditor.Project.assets.rooms[num].tiles[i].depth = Convert.ToInt32(reader.GetAttribute("depth"));
                    MapEditor.Project.assets.rooms[num].tiles[i].locked = Convert.Tobooleanean(Convert.ToInt32(reader.GetAttribute("locked")));
                    MapEditor.Project.assets.rooms[num].tiles[i].colour = reader.GetAttribute("colour");
                    MapEditor.Project.assets.rooms[num].tiles[i].scaleX = Convert.ToDouble(reader.GetAttribute("scaleX"));
                    MapEditor.Project.assets.rooms[num].tiles[i].scaleY = Convert.ToDouble(reader.GetAttribute("scaleY"));
                    i++;
                } while (reader.ReadToNextSibling("tile"));
            }

            reader.ReadToFollowing("PhysicsWorld");
            MapEditor.Project.assets.rooms[num].PhysicsWorld = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("PhysicsWorldTop");
            MapEditor.Project.assets.rooms[num].PhysicsWorldTop = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("PhysicsWorldLeft");
            MapEditor.Project.assets.rooms[num].PhysicsWorldLeft = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("PhysicsWorldRight");
            MapEditor.Project.assets.rooms[num].PhysicsWorldRight = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("PhysicsWorldBottom");
            MapEditor.Project.assets.rooms[num].PhysicsWorldBottom = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("PhysicsWorldGravityX");
            MapEditor.Project.assets.rooms[num].PhysicsWorldGravityX = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("PhysicsWorldGravityY");
            MapEditor.Project.assets.rooms[num].PhysicsWorldGravityY = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("PhysicsWorldPixToMeters");
            MapEditor.Project.assets.rooms[num].PhysicsWorldPixToMeters = reader.ReadElementContentAsDouble();
            reader.ReadToFollowing("caption");
        }*/
    }

    public String toString()
    {
        String backgroundsTag = "";
        String viewsTag = "";
        String instancesTag = "  <instances/>\n";
        String tilesTag = "  <tiles/>\n";

        if (instances.size() > 0)
        {
            instancesTag = "  <instances>\n";
            for(Instance instance : instances)
            {
                instancesTag += "    <instance objName=\"" + instance.objName + "\" x=\"" + instance.x + "\" y=\"" + instance.y + "\" name=\"" + instance.name + "\" locked=\"" + (instance.locked ? 1 : 0) * -1 + "\" code=\"" + instance.code + "\" scaleX=\"" + instance.scaleX + "\" scaleY=\"" + instance.scaleY + "\" colour=\"" + instance.colour + "\" rotation=\"" + instance.rotation + "\"/>\n";
            }
            instancesTag += "  </instances>\n";
        }

        if (tiles.size() > 0)
        {
            tilesTag = "  <tiles>\n";
            for(Tile tile : tiles)
            {
                tilesTag += "    <tile bgName=\"" + tile.bgName + "\" x=\"" + tile.x + "\" y=\"" + tile.y + "\" w=\"" + tile.w + "\" h=\"" + tile.h + "\" xo=\"" + tile.xo + "\" yo=\"" + tile.yo + "\" id=\"" + tile.id + "\" name=\"" + tile.name + "\" depth=\"" + tile.depth + "\" locked=\"" + (tile.locked ? 1 : 0) * -1 + "\" colour=\"" + tile.colour + "\" scaleX=\"" + tile.scaleX + "\" scaleY=\"" + tile.scaleY + "\"/>\n";
            }
            tilesTag += "  </tiles>\n";
        }

        backgroundsTag += "  <backgrounds>\n";
        for(Background background : backgrounds)
        {
            backgroundsTag += "    <background visible=\"" + (background.visible ? 1 : 0) * -1 + "\" foreground=\"" + (background.foreground ? 1 : 0) * -1 + "\" name=\"" + background.name + "\" x=\"" + background.x + "\" y=\"" + background.y + "\" htiled=\"" + (background.htiled ? 1 : 0) * -1 + "\" vtiled=\"" + (background.vtiled ? 1 : 0) * -1 + "\" hspeed=\"" + background.hspeed + "\" vspeed=\"" + background.vspeed + "\" stretch=\"" + (background.stretch ? 1 : 0) * -1 + "\"/>\n";
        }
        backgroundsTag += "  </backgrounds>\n";

        viewsTag += "  <views>\n";
        for (View view : views)
        {
            viewsTag += "    <view visible=\"" + (view.visible ? 1 : 0) * -1 + "\" objName=\"" + StringEscapeUtils.escapeHtml3(view.objName) + "\" xview=\"" + view.xview + "\" yview=\"" + view.yview + "\" wview=\"" + view.wview + "\" hview=\"" + view.hview + "\" xport=\"" + view.xport + "\" yport=\"" + view.yport + "\" wport=\"" + view.wport + "\" hport=\"" + view.hport + "\" hborder=\"" + view.hborder + "\" vborder=\"" + view.vborder + "\" hspeed=\"" + view.hspeed + "\" vspeed=\"" + view.vspeed + "\"/>\n";
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
                "  <persistent>" + (persistent ? 1 : 0) * -1 + "</persistent>\n" +
                "  <colour>" + colour + "</colour>\n" +
                "  <showcolour>" + (showcolour ? 1 : 0) * -1 + "</showcolour>\n" +
                "  <code>" + code + "</code>\n" +
                "  <enableViews>" + (enableViews ? 1 : 0) * -1 + "</enableViews>\n" +
                "  <clearViewBackground>" + (clearViewBackground ? 1 : 0) * -1 + "</clearViewBackground>\n" +
                "  <clearDisplayBuffer>" + (clearDisplayBuffer ? 1 : 0) * -1 + "</clearDisplayBuffer>\n" +
                "  <makerSettings>\n" +
                "    <isSet>" + (makerSettings.isSet ? 1 : 0) * -1 + "</isSet>\n" +
                "    <w>" + makerSettings.w + "</w>\n" +
                "    <h>" + makerSettings.h + "</h>\n" +
                "    <showGrid>" + (makerSettings.showGrid ? 1 : 0) * -1 + "</showGrid>\n" +
                "    <showObjects>" + (makerSettings.showObjects ? 1 : 0) * -1 + "</showObjects>\n" +
                "    <showTiles>" + (makerSettings.showTiles ? 1 : 0) * -1 + "</showTiles>\n" +
                "    <showBackgrounds>" + (makerSettings.showBackgrounds ? 1 : 0) * -1 + "</showBackgrounds>\n" +
                "    <showForegrounds>" + (makerSettings.showForegrounds ? 1 : 0) * -1 + "</showForegrounds>\n" +
                "    <showViews>" + (makerSettings.showViews ? 1 : 0) * -1 + "</showViews>\n" +
                "    <deleteUnderlyingObj>" + (makerSettings.deleteUnderlyingObj ? 1 : 0) * -1 + "</deleteUnderlyingObj>\n" +
                "    <deleteUnderlyingTiles>" + (makerSettings.deleteUnderlyingTiles ? 1 : 0) * -1 + "</deleteUnderlyingTiles>\n" +
                "    <page>" + makerSettings.page + "</page>\n" +
                "    <xoffset>" + makerSettings.xoffset + "</xoffset>\n" +
                "    <yoffset>" + makerSettings.yoffset + "</yoffset>\n" +
                "  </makerSettings>\n" +
                backgroundsTag +
                viewsTag +
                instancesTag +
                tilesTag +
                "  <PhysicsWorld>" + (PhysicsWorld ? 1 : 0) * -1 + "</PhysicsWorld>\n" +
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
