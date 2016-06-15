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
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.lang3.StringEscapeUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Room {
    public boolean hasChanges = true;
    public boolean isNew = true;
    public String name = "room" + String.valueOf(xml.Project.assets.rooms.size());
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
    public ArrayList<Background> backgrounds = new ArrayList<>();
    public ArrayList<View> views = new ArrayList<>();
    public ArrayList<Instance> instances = new ArrayList<>();
    public ArrayList<Tile> tiles = new ArrayList<>();

    public void RoomRead(String xmlFile)
    {
        name = xmlFile.split("\\\\")[1];
        hasChanges = false;
        isNew = false;
        xmlFile = xml.Project.projectFolder + xmlFile + ".room.gmx";
        int num = xml.Project.assets.rooms.size() - 1;
        File fXmlFile = new File(xmlFile);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            
            xml.Project.assets.rooms.get(num).caption = doc.getElementsByTagName("caption").item(0).getTextContent();
            xml.Project.assets.rooms.get(num).width = Integer.valueOf(doc.getElementsByTagName("width").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).height = Integer.valueOf(doc.getElementsByTagName("height").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).vsnap = Integer.valueOf(doc.getElementsByTagName("vsnap").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).hsnap = Integer.valueOf(doc.getElementsByTagName("hsnap").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).isometric = Integer.valueOf(doc.getElementsByTagName("isometric").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).speed = Integer.valueOf(doc.getElementsByTagName("speed").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).persistent = doc.getElementsByTagName("persistent").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).colour = Integer.valueOf(doc.getElementsByTagName("colour").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).showcolour = doc.getElementsByTagName("showcolour").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).code = doc.getElementsByTagName("code").item(0).getTextContent();
            xml.Project.assets.rooms.get(num).enableViews = doc.getElementsByTagName("enableViews").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).clearViewBackground = doc.getElementsByTagName("clearViewBackground").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).clearDisplayBuffer = doc.getElementsByTagName("clearDisplayBuffer").item(0).getTextContent().equals("-1");
            
            //Maker Settings
            xml.Project.assets.rooms.get(num).makerSettings.isSet = doc.getElementsByTagName("isSet").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).makerSettings.w = Integer.valueOf(doc.getElementsByTagName("w").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).makerSettings.h = Integer.valueOf(doc.getElementsByTagName("h").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).makerSettings.showGrid = doc.getElementsByTagName("showGrid").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).makerSettings.showObjects = doc.getElementsByTagName("showObjects").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).makerSettings.showTiles = doc.getElementsByTagName("showTiles").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).makerSettings.showBackgrounds = doc.getElementsByTagName("showBackgrounds").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).makerSettings.showForegrounds = doc.getElementsByTagName("showForegrounds").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).makerSettings.showViews = doc.getElementsByTagName("showViews").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).makerSettings.deleteUnderlyingObj = doc.getElementsByTagName("deleteUnderlyingObj").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).makerSettings.deleteUnderlyingTiles = doc.getElementsByTagName("deleteUnderlyingTiles").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).makerSettings.page = Integer.valueOf(doc.getElementsByTagName("page").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).makerSettings.xoffset = Integer.valueOf(doc.getElementsByTagName("xoffset").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).makerSettings.yoffset = Integer.valueOf(doc.getElementsByTagName("yoffset").item(0).getTextContent());
            
            //Backgrounds
            NodeList backgrounds = doc.getElementsByTagName("background");
            for(int i = 0; i < backgrounds.getLength(); i++){
                Element background = (Element)backgrounds.item(i);
                xml.Project.assets.rooms.get(num).backgrounds.add(new xml.projectAssets.rooms.Background());
                xml.Project.assets.rooms.get(num).backgrounds.get(i).visible = background.getAttribute("visible").equals("-1");
                xml.Project.assets.rooms.get(num).backgrounds.get(i).foreground = background.getAttribute("foreground").equals("-1");
                xml.Project.assets.rooms.get(num).backgrounds.get(i).name = background.getAttribute("name");
                xml.Project.assets.rooms.get(num).backgrounds.get(i).x = Integer.valueOf(background.getAttribute("x"));
                xml.Project.assets.rooms.get(num).backgrounds.get(i).y = Integer.valueOf(background.getAttribute("y"));
                xml.Project.assets.rooms.get(num).backgrounds.get(i).htiled = background.getAttribute("htiled").equals("-1");
                xml.Project.assets.rooms.get(num).backgrounds.get(i).vtiled = background.getAttribute("vtiled").equals("-1");
                xml.Project.assets.rooms.get(num).backgrounds.get(i).hspeed = Integer.valueOf(background.getAttribute("hspeed"));
                xml.Project.assets.rooms.get(num).backgrounds.get(i).vspeed = Integer.valueOf(background.getAttribute("vspeed"));
                xml.Project.assets.rooms.get(num).backgrounds.get(i).stretch = background.getAttribute("stretch").equals("-1");
            }
            
            //Views
            NodeList views = doc.getElementsByTagName("view");
            for(int i = 0; i < views.getLength(); i++){
                Element view = (Element)views.item(i);
                xml.Project.assets.rooms.get(num).views.add(new xml.projectAssets.rooms.View());
                xml.Project.assets.rooms.get(num).views.get(i).visible = view.getAttribute("visible").equals("-1");
                xml.Project.assets.rooms.get(num).views.get(i).objName = view.getAttribute("objName");
                xml.Project.assets.rooms.get(num).views.get(i).xview = Integer.valueOf(view.getAttribute("xview"));
                xml.Project.assets.rooms.get(num).views.get(i).yview = Integer.valueOf(view.getAttribute("yview"));
                xml.Project.assets.rooms.get(num).views.get(i).wview = Integer.valueOf(view.getAttribute("wview"));
                xml.Project.assets.rooms.get(num).views.get(i).hview = Integer.valueOf(view.getAttribute("hview"));
                xml.Project.assets.rooms.get(num).views.get(i).xport = Integer.valueOf(view.getAttribute("xport"));
                xml.Project.assets.rooms.get(num).views.get(i).yport = Integer.valueOf(view.getAttribute("yport"));
                xml.Project.assets.rooms.get(num).views.get(i).wport = Integer.valueOf(view.getAttribute("wport"));
                xml.Project.assets.rooms.get(num).views.get(i).hport = Integer.valueOf(view.getAttribute("hport"));
                xml.Project.assets.rooms.get(num).views.get(i).hborder = Integer.valueOf(view.getAttribute("hborder"));
                xml.Project.assets.rooms.get(num).views.get(i).vborder = Integer.valueOf(view.getAttribute("vborder"));
                xml.Project.assets.rooms.get(num).views.get(i).hspeed = Integer.valueOf(view.getAttribute("hspeed"));
                xml.Project.assets.rooms.get(num).views.get(i).vspeed = Integer.valueOf(view.getAttribute("vspeed"));
            }
            
            //Instances
            NodeList instances = doc.getElementsByTagName("instance");
            for(int i = 0; i < instances.getLength(); i++){
                Element instance = (Element)instances.item(i);
                xml.Project.assets.rooms.get(num).instances.add(new xml.projectAssets.rooms.Instance());
                xml.Project.assets.rooms.get(num).instances.get(i).objName = instance.getAttribute("objName");
                xml.Project.assets.rooms.get(num).instances.get(i).x = Integer.valueOf(instance.getAttribute("x"));
                xml.Project.assets.rooms.get(num).instances.get(i).y = Integer.valueOf(instance.getAttribute("y"));
                xml.Project.assets.rooms.get(num).instances.get(i).name = instance.getAttribute("name");
                xml.Project.assets.rooms.get(num).instances.get(i).locked = instance.getAttribute("locked").equals("-1");
                xml.Project.assets.rooms.get(num).instances.get(i).code = instance.getAttribute("code");
                xml.Project.assets.rooms.get(num).instances.get(i).scaleX = Integer.valueOf(instance.getAttribute("scaleX"));
                xml.Project.assets.rooms.get(num).instances.get(i).scaleY = Integer.valueOf(instance.getAttribute("scaleY"));
                xml.Project.assets.rooms.get(num).instances.get(i).colour = instance.getAttribute("colour");
                xml.Project.assets.rooms.get(num).instances.get(i).rotation = Integer.valueOf(instance.getAttribute("rotation"));
            }
            
            //Tiles
            NodeList tiles = doc.getElementsByTagName("tile");
            for(int i = 0; i < tiles.getLength(); i++){
                Element tile = (Element)tiles.item(i);
                xml.Project.assets.rooms.get(num).tiles.add(new xml.projectAssets.rooms.Tile());
                xml.Project.assets.rooms.get(num).tiles.get(i).bgName = tile.getAttribute("bgName");
                xml.Project.assets.rooms.get(num).tiles.get(i).x = Integer.valueOf(tile.getAttribute("x"));
                xml.Project.assets.rooms.get(num).tiles.get(i).y = Integer.valueOf(tile.getAttribute("y"));
                xml.Project.assets.rooms.get(num).tiles.get(i).w = Integer.valueOf(tile.getAttribute("w"));
                xml.Project.assets.rooms.get(num).tiles.get(i).h = Integer.valueOf(tile.getAttribute("h"));
                xml.Project.assets.rooms.get(num).tiles.get(i).xo = Integer.valueOf(tile.getAttribute("xo"));
                xml.Project.assets.rooms.get(num).tiles.get(i).yo = Integer.valueOf(tile.getAttribute("yo"));
                xml.Project.assets.rooms.get(num).tiles.get(i).id = Integer.valueOf(tile.getAttribute("id"));
                xml.Project.assets.rooms.get(num).tiles.get(i).name = tile.getAttribute("name");
                xml.Project.assets.rooms.get(num).tiles.get(i).depth = Integer.valueOf(tile.getAttribute("depth"));
                xml.Project.assets.rooms.get(num).tiles.get(i).locked = tile.getAttribute("locked").equals("-1");
                xml.Project.assets.rooms.get(num).tiles.get(i).colour = tile.getAttribute("colour");
                xml.Project.assets.rooms.get(num).tiles.get(i).scaleX = Double.valueOf(tile.getAttribute("scaleX"));
                xml.Project.assets.rooms.get(num).tiles.get(i).scaleY = Double.valueOf(tile.getAttribute("scaleY"));
            }
            
            xml.Project.assets.rooms.get(num).PhysicsWorld = doc.getElementsByTagName("PhysicsWorld").item(0).getTextContent().equals("-1");
            xml.Project.assets.rooms.get(num).PhysicsWorldTop = Integer.valueOf(doc.getElementsByTagName("PhysicsWorldTop").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).PhysicsWorldLeft = Integer.valueOf(doc.getElementsByTagName("PhysicsWorldLeft").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).PhysicsWorldRight = Integer.valueOf(doc.getElementsByTagName("PhysicsWorldRight").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).PhysicsWorldBottom = Integer.valueOf(doc.getElementsByTagName("PhysicsWorldBottom").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).PhysicsWorldGravityX = Integer.valueOf(doc.getElementsByTagName("PhysicsWorldGravityX").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).PhysicsWorldGravityY = Integer.valueOf(doc.getElementsByTagName("PhysicsWorldGravityY").item(0).getTextContent());
            xml.Project.assets.rooms.get(num).PhysicsWorldPixToMeters = Double.valueOf(doc.getElementsByTagName("PhysicsWorldPixToMeters").item(0).getTextContent());
        }
            catch (Exception e) {
            e.printStackTrace();
        }
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
