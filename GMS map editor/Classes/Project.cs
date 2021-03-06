﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Xml;
using System.Xml.Linq;
using GMSMapEditor.ProjectAssets;
using System.Windows.Forms;
using System.Drawing;
using GMSMapEditor.ProjectAssets.Grafico;

namespace GMSMapEditor.Classes
{
    public static class Project
    {
        public static string projectName;
        public static string projectFolder;
        public static Assets assets;
        public static List<BackgroundTile> bts;
        public static List<SimpleRoom> srs;
        public static TimeSpan stop;

        static Project(){
            bts = new List<BackgroundTile>();
            srs = new List<SimpleRoom>();
        }

        public static void OpenProject(ListBox roomsList, ComboBox tilesList)
        {
            stop = new TimeSpan(DateTime.Now.Ticks);
            OpenFileDialog projectFile = new OpenFileDialog();
            projectFile.Filter = "GameMaker: Studio Project Files|*.project.gmx";

            if (projectFile.ShowDialog() == DialogResult.OK)
            {
                assets = new ProjectAssets.Assets();
                projectFolder = Path.GetDirectoryName(projectFile.FileName) + @"\";
                projectName = Path.GetFileName(projectFile.FileName);
                String xmlString = File.ReadAllText(projectFolder + projectName).ToString();
                using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
                {
                    while (reader.ReadToFollowing("background"))
                    {
                        assets.backgrounds.Add(new ProjectAssets.Backgrounds.Background());
                        int num = assets.backgrounds.Count - 1;
                        assets.backgrounds[num].BackgroundRead(reader.ReadElementContentAsString());
                        assets.backgrounds[num].image = Image.FromFile(projectFolder + "background\\" + assets.backgrounds[num].data);
                    }
                }
                using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
                {
                    while (reader.ReadToFollowing("room"))
                    {
                        assets.rooms.Add(new ProjectAssets.Rooms.Room());
                        int num = assets.rooms.Count - 1;
                        assets.rooms[num].RoomRead(reader.ReadElementContentAsString());
                    }
                }

                List<string> _rooms = new List<string>();
                foreach (ProjectAssets.Rooms.Room room in Project.assets.rooms)
                {
                    _rooms.Add(room.name);
                }
                roomsList.DataSource = null;
                roomsList.DataSource = _rooms;

                List<string> _tiles = new List<string>();
                foreach (ProjectAssets.Backgrounds.Background tile in Project.assets.backgrounds)
                {
                    if (tile.istileset)
                    {
                        _tiles.Add(tile.name);
                    }
                }
                tilesList.DataSource = null;
                tilesList.DataSource = _tiles;

                var acsc = new AutoCompleteStringCollection();
                foreach (string elem in _tiles)
                {
                    acsc.Add(elem);
                }

                tilesList.AutoCompleteCustomSource = acsc;
                tilesList.AutoCompleteMode = AutoCompleteMode.Suggest;
                tilesList.AutoCompleteSource = AutoCompleteSource.CustomSource;

                //backgrounds
                foreach (GMSMapEditor.ProjectAssets.Backgrounds.Background t in assets.backgrounds){
                    if (t.istileset){
                        bts.Add(new BackgroundTile(t.image, t.name, t.tilewidth, t.tileheight));
                    }
                }
                //rooms
                int x = 0;
                foreach(GMSMapEditor.ProjectAssets.Rooms.Room r in assets.rooms){
                    SimpleRoom sr = new SimpleRoom(r.width, r.height, r.tiles);
                    //sr.roomIni(bts);
                    srs.Add(sr);
                }
            }
        }

        public static void NewProject()
        {
            SaveFileDialog projectFile = new SaveFileDialog();
            projectFile.Filter = "GameMaker: Studio Project Files|*.project.gmx";

            if (projectFile.ShowDialog() == DialogResult.OK)
            {
                projectName = Path.GetFileName(projectFile.FileName);
                projectFolder = Path.GetDirectoryName(projectFile.FileName) + "\\" + projectName.Split('.')[0] + ".gmx\\";

                if (!Directory.Exists(projectFolder))
                {

                    Directory.CreateDirectory(projectFolder);
                    Directory.CreateDirectory(projectFolder + "background");
                    Directory.CreateDirectory(projectFolder + "rooms");
                    DeepCopy(new DirectoryInfo(System.IO.Path.GetDirectoryName(Application.ExecutablePath) + "\\files\\"), new DirectoryInfo(projectFolder));

                    File.WriteAllText(projectFolder + projectName,
                        "<!--This Document is generated by GameMaker, if you edit it by hand then you do so at your own risk!-->\n" +
                        "<assets>\n" +
                        "  <Configs name=\"configs\">\n" +
                        "    <Config>Configs\\Default</Config>\n" +
                        "  </Configs>\n" +
                        "  <NewExtensions/>\n" +
                        "  <sounds name=\"sound\"/>\n" +
                        "  <sprites name=\"sprites\"/>\n" +
                        "  <backgrounds name=\"background\"/>\n" +
                        "  <paths name=\"paths\"/>\n" +
                        "  <rooms name=\"rooms\"/>\n" +
                        "  <help>\n" +
                        "    <rtf>help.rtf</rtf>\n" +
                        "  </help>\n" +
                        "  <TutorialState>\n" +
                        "    <IsTutorial>0</IsTutorial>\n" +
                        "    <TutorialName></TutorialName>\n" +
                        "    <TutorialPage>0</TutorialPage>\n" +
                        "  </TutorialState>\n" +
                        "</assets>"
                        );

                    assets = new ProjectAssets.Assets();
                }
                else
                {
                    MessageBox.Show("Ya existe un proyecto con el mismo nombre, elija uno distinto.");
                    NewProject();
                }
            }
        }

        public static void SaveProject()
        {
            try
            {
                var doc = XDocument.Parse(File.ReadAllText(projectFolder + projectName));

                foreach (ProjectAssets.Rooms.Room room in assets.rooms)
                {
                    if (room.isNew)
                    {
                        doc.Descendants("rooms").FirstOrDefault().Add(new XElement("room", "rooms\\" + room.name));
                        File.WriteAllText(projectFolder + "rooms\\" + room.name + ".room.gmx", room.ToString());
                    }
                    if (room.hasChanges)
                    {
                        File.WriteAllText(projectFolder + "rooms\\" + room.name + ".room.gmx", room.ToString());
                    }
                }

                foreach (ProjectAssets.Backgrounds.Background background in assets.backgrounds)
                {
                    if (background.isNew)
                    {
                        doc.Descendants("backgrounds").FirstOrDefault().Add(new XElement("background", "background\\" + background.name));
                    }
                    if (background.hasChanges)
                    {
                        File.WriteAllText(projectFolder + "background\\" + background.name + ".background.gmx", background.ToString());
                    }
                }

                doc.Save(projectFolder + projectName);
            }
            catch
            {
                MessageBox.Show("Ocurrió un error al guardar el proyecto");
            }
        }

        public static void DeepCopy(DirectoryInfo source, DirectoryInfo target)
        {

            // Recursively call the DeepCopy Method for each Directory
            foreach (DirectoryInfo dir in source.GetDirectories())
                DeepCopy(dir, target.CreateSubdirectory(dir.Name));

            // Go ahead and copy each file in "source" to the "target" directory
            foreach (FileInfo file in source.GetFiles())
                file.CopyTo(Path.Combine(target.FullName, file.Name));

        }  
    }
}
