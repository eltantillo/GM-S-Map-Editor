/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.projectAssets.backgrounds;

/**
 *
 * @author eltan
 */
import java.util.ArrayList;

public class Background {
    public boolean hasChanges = false;
    public boolean isNew = false;
    public String name = "";
    public boolean istileset;
    public int tilewidth;
    public int tileheight;
    public int tilexoff;
    public int tileyoff;
    public int tilehsep;
    public int tilevsep;
    public boolean HTile;
    public boolean VTile;
    public ArrayList<Integer> TextureGroups = new ArrayList<>();
    public boolean For3D;
    public int width;
    public int height;
    public String data;
    //public Image image;

    public void BackgroundRead(String xmlFile)
    {
        /*name = xmlFile.Split('\\')[1];
        xmlFile = MapEditor.Project.projectFolder + xmlFile + ".background.gmx";
        String xmlString = File.ReadAllText(xmlFile).ToString();
        using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
        {
            int num = MapEditor.Project.assets.backgrounds.Count - 1;
            reader.ReadToFollowing("istileset");
            MapEditor.Project.assets.backgrounds[num].istileset = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("tilewidth");
            MapEditor.Project.assets.backgrounds[num].tilewidth = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("tileheight");
            MapEditor.Project.assets.backgrounds[num].tileheight = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("tilexoff");
            MapEditor.Project.assets.backgrounds[num].tilexoff = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("tileyoff");
            MapEditor.Project.assets.backgrounds[num].tileyoff = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("tilehsep");
            MapEditor.Project.assets.backgrounds[num].tilehsep = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("tilevsep");
            MapEditor.Project.assets.backgrounds[num].tilevsep = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("HTile");
            MapEditor.Project.assets.backgrounds[num].HTile = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("VTile");
            MapEditor.Project.assets.backgrounds[num].VTile = Convert.Tobooleanean(reader.ReadElementContentAsInt());

            reader.ReadToFollowing("TextureGroups");
            int i = 0;
            reader.ReadToFollowing("TextureGroup" + i);
            while (reader.ReadToNextSibling("TextureGroup" + i))
            {
                MapEditor.Project.assets.backgrounds[num].TextureGroups.Add(reader.ReadElementContentAsInt());
                i++;
            }

            reader.ReadToFollowing("For3D");
            MapEditor.Project.assets.backgrounds[num].For3D = Convert.Tobooleanean(reader.ReadElementContentAsInt());
            reader.ReadToFollowing("width");
            MapEditor.Project.assets.backgrounds[num].width = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("height");
            MapEditor.Project.assets.backgrounds[num].height = reader.ReadElementContentAsInt();
            reader.ReadToFollowing("data");
            MapEditor.Project.assets.backgrounds[num].data = reader.ReadElementContentAsString();
        }*/
    }
    
    @Override
    public String toString()
    {
        String textureGroup = "";
        int i = 0;
        for (int group : TextureGroups)
        {
            textureGroup += "    <TextureGroup" + i + ">" + group + "</TextureGroup" + i + ">\n";
            i++;
        }

        return  "<!--This Document is generated by GameMaker, if you edit it by hand then you do so at your own risk!-->\n" +
                "<background>\n" +
                "  <istileset>" + (istileset ? 1 : 0) * -1 + "</istileset>\n" +
                "  <tilewidth>" + tilewidth + "</tilewidth>\n" +
                "  <tileheight>" + tileheight + "</tileheight>\n" +
                "  <tilexoff>" + tilexoff + "</tilexoff>\n" +
                "  <tileyoff>" + tileyoff + "</tileyoff>\n" +
                "  <tilehsep>" + tilehsep + "</tilehsep>\n" +
                "  <tilevsep>" + tilevsep + "</tilevsep>\n" +
                "  <HTile>" + (HTile ? 1 : 0) * -1 + "</HTile>\n" +
                "  <VTile>" + (VTile ? 1 : 0) * -1 + "</VTile>\n" +
                "  <TextureGroups>\n" +
                    textureGroup +
                "  </TextureGroups>\n" +
                "  <For3D>" + (For3D ? 1 : 0) * -1 + "</For3D>\n" +
                "  <width>" + width + "</width>\n" +
                "  <height>" + height + "</height>\n" +
                "  <data>" + data + "</data>\n" +
                "</background>";
    }
}
