using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Xml;
using System.Xml.Linq;
using GMSMapEditor.ProjectAssets;

namespace GMSMapEditor.Classes
{
    public static class Project
    {
        public static string projectName;
        public static string projectFolder;
        public static Assets assets;

        public static void OpenProject()
        {
            String xmlString = File.ReadAllText(Project.projectFolder + Project.projectName).ToString();
            using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
            {
                while (reader.ReadToFollowing("background"))
                {
                    assets.backgrounds.Add(new ProjectAssets.Backgrounds.Background());
                    int num = assets.backgrounds.Count - 1;
                    assets.backgrounds[num].BackgroundRead(reader.ReadElementContentAsString());
                }
                while (reader.ReadToFollowing("room"))
                {
                    assets.rooms.Add(new ProjectAssets.Rooms.Room());
                    int num = assets.rooms.Count - 1;
                    assets.rooms[num].RoomRead(reader.ReadElementContentAsString());
                }
            }
        }

        public static void SaveProject()
        {
            var doc = XDocument.Parse(File.ReadAllText(projectFolder + projectName));

            foreach (ProjectAssets.Rooms.Room room in assets.rooms)
            {
                if (room.isNew)
                {
                    doc.Descendants("rooms").FirstOrDefault().Add(new XElement("room", "rooms\\" + room.name));
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
                    doc.Descendants("backgrounds").FirstOrDefault().Add(new XElement("background", "backgrounds\\" + background.name));
                }
            }

            doc.Save(projectFolder + projectName);
        }
    }
}
