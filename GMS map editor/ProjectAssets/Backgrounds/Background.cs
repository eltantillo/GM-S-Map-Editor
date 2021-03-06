﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using System.IO;
using GMSMapEditor.Classes;
using System.Windows.Forms;
using System.Drawing;

namespace GMSMapEditor.ProjectAssets.Backgrounds
{
    public class Background
    {
        public bool hasChanges = false;
        public bool isNew = false;
        public string name = "";
        public bool istileset;
        public int tilewidth;
        public int tileheight;
        public int tilexoff;
        public int tileyoff;
        public int tilehsep;
        public int tilevsep;
        public bool HTile;
        public bool VTile;
        public List<int> TextureGroups = new List<int>();
        public bool For3D;
        public int width;
        public int height;
        public string data;
        public Image image;

        public void BackgroundRead(string xmlFile)
        {
            name = xmlFile.Split('\\')[1];
            xmlFile = Project.projectFolder + xmlFile + ".background.gmx";
            String xmlString = File.ReadAllText(xmlFile).ToString();
            using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
            {
                int num = Project.assets.backgrounds.Count - 1;
                reader.ReadToFollowing("istileset");
                Project.assets.backgrounds[num].istileset = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("tilewidth");
                Project.assets.backgrounds[num].tilewidth = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("tileheight");
                Project.assets.backgrounds[num].tileheight = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("tilexoff");
                Project.assets.backgrounds[num].tilexoff = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("tileyoff");
                Project.assets.backgrounds[num].tileyoff = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("tilehsep");
                Project.assets.backgrounds[num].tilehsep = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("tilevsep");
                Project.assets.backgrounds[num].tilevsep = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("HTile");
                Project.assets.backgrounds[num].HTile = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("VTile");
                Project.assets.backgrounds[num].VTile = Convert.ToBoolean(reader.ReadElementContentAsInt());

                reader.ReadToFollowing("TextureGroups");
                int i = 0;
                reader.ReadToFollowing("TextureGroup" + i);
                while (reader.ReadToNextSibling("TextureGroup" + i))
                {
                    Project.assets.backgrounds[num].TextureGroups.Add(reader.ReadElementContentAsInt());
                    i++;
                }

                reader.ReadToFollowing("For3D");
                Project.assets.backgrounds[num].For3D = Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("width");
                Project.assets.backgrounds[num].width = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("height");
                Project.assets.backgrounds[num].height = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("data");
                Project.assets.backgrounds[num].data = reader.ReadElementContentAsString();
            }
        }

        public override String ToString()
        {
            string textureGroup = "";
            int i = 0;
            foreach (int group in TextureGroups)
            {
                textureGroup += "    <TextureGroup" + i + ">" + group + "</TextureGroup" + i + ">\n";
                i++;
            }

            return  "<!--This Document is generated by GameMaker, if you edit it by hand then you do so at your own risk!-->\n" +
                    "<background>\n" +
                    "  <istileset>" + Convert.ToInt32(istileset) * -1 + "</istileset>\n" +
                    "  <tilewidth>" + tilewidth + "</tilewidth>\n" +
                    "  <tileheight>" + tileheight + "</tileheight>\n" +
                    "  <tilexoff>" + tilexoff + "</tilexoff>\n" +
                    "  <tileyoff>" + tileyoff + "</tileyoff>\n" +
                    "  <tilehsep>" + tilehsep + "</tilehsep>\n" +
                    "  <tilevsep>" + tilevsep + "</tilevsep>\n" +
                    "  <HTile>" + Convert.ToInt32(HTile) * -1 + "</HTile>\n" +
                    "  <VTile>" + Convert.ToInt32(VTile) * -1 + "</VTile>\n" +
                    "  <TextureGroups>\n" +
                        textureGroup +
                    "  </TextureGroups>\n" +
                    "  <For3D>" + Convert.ToInt32(For3D) * -1 + "</For3D>\n" +
                    "  <width>" + width + "</width>\n" +
                    "  <height>" + height + "</height>\n" +
                    "  <data>" + data + "</data>\n" +
                    "</background>";
        }
    }
}
