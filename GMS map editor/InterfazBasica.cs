using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Xml;
using System.IO;
using GMSMapEditor.Classes;
using GMSMapEditor.ProjectAssets;
using GMSMapEditor.ProjectAssets.Grafico;

namespace GMSMapEditor{
    public partial class InterfazBasica : Form{

        Object bt;
        Object sr;

        public InterfazBasica(){
            InitializeComponent();
        }

        private void InterfazBasica_Load(object sender, EventArgs e){

        }

        private void InterfazBasica_SizeChanged(object sender, EventArgs e){
            //MessageBox.Show("Error Message", "Error Title", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            div_left.Width = int.Parse(Math.Floor(this.Width * 0.25) + "");
            div_left.Dock = DockStyle.Left;
            div_left.SetAutoScrollMargin(12, div_left.Height);

            div_center.Width = int.Parse(Math.Floor(this.Width * 0.5) + "");
            div_center.Dock = DockStyle.Left;
            div_center.Location = new Point(div_left.Height,0);
            div_center.SetAutoScrollMargin(12, div_left.Height);

            div_right.Width = int.Parse(Math.Floor(this.Width * 0.25) + "");
            div_right.Dock = DockStyle.Left;
            div_right.Location = new Point(div_center.Height, 0);
            div_right.SetAutoScrollMargin(12, div_left.Height);
            barra2.Width = this.Width;
        }

        private void noseToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
        }

        private void deleteDelToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void queEsEstoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog projectFile = new OpenFileDialog();
            projectFile.Filter = "GameMaker: Studio Project Files|*.project.gmx";

            if (projectFile.ShowDialog() == DialogResult.OK)
            {
                Project.assets = new ProjectAssets.Assets();
                Project.projectFolder = Path.GetDirectoryName(projectFile.FileName) + @"\";
                Project.projectName = Path.GetFileName(projectFile.FileName);

                XmlRead(Project.projectFolder + Project.projectName, "background");
                XmlRead(Project.projectFolder + Project.projectName, "room");
            }
        }

        private void XmlRead(string xmlFile, string section)
        {
            String xmlString = File.ReadAllText(xmlFile).ToString();
            using (XmlReader reader = XmlReader.Create(new StringReader(xmlString)))
            {
                while (reader.ReadToFollowing(section))
                {
                    if (section == "background")
                    {
                        Project.assets.backgrounds.Add(new ProjectAssets.Backgrounds.Background());
                        BackgroundRead(Project.projectFolder + reader.ReadElementContentAsString() + "." + section + ".gmx");
                    }
                    else if (section == "room")
                    {
                        Project.assets.rooms.Add(new ProjectAssets.Rooms.Room());
                        RoomRead(Project.projectFolder + reader.ReadElementContentAsString() + "." + section + ".gmx");
                    }
                }
            }
        }

        private void RoomRead(string xmlFile)
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
                Project.assets.rooms[num].persistent =  Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("colour");
                Project.assets.rooms[num].colour = reader.ReadElementContentAsInt();
                reader.ReadToFollowing("showcolour");
                Project.assets.rooms[num].showcolour =  Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("code");
                Project.assets.rooms[num].code = reader.ReadElementContentAsString();
                reader.ReadToFollowing("enableViews");
                Project.assets.rooms[num].enableViews =  Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("clearViewBackground");
                Project.assets.rooms[num].clearViewBackground =  Convert.ToBoolean(reader.ReadElementContentAsInt());
                reader.ReadToFollowing("clearDisplayBuffer");
                Project.assets.rooms[num].clearDisplayBuffer =  Convert.ToBoolean(reader.ReadElementContentAsInt());

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

                reader.ReadToFollowing("background");
                do
                {
                    //MessageBox.Show(reader.GetAttribute("name"));
                    Project.assets.rooms[num].backgrounds.Add(new ProjectAssets.Rooms.Background());
                } while (reader.ReadToNextSibling("background"));

                reader.ReadToFollowing("view");
                do
                {
                    //MessageBox.Show(reader.GetAttribute("wview"));
                    Project.assets.rooms[num].views.Add(new ProjectAssets.Rooms.View());
                } while (reader.ReadToNextSibling("view")) ;

                reader.ReadToFollowing("instances");
                if (!reader.IsEmptyElement)
                {
                    reader.ReadToFollowing("instance");
                    do
                    {
                        //MessageBox.Show(reader.GetAttribute("objName"));
                        Project.assets.rooms[num].instances.Add(new ProjectAssets.Rooms.Instance());
                    } while (reader.ReadToNextSibling("instance"));
                }

                reader.ReadToFollowing("tiles");
                if (!reader.IsEmptyElement)
                {
                    reader.ReadToFollowing("tile");
                    do
                    {
                        //MessageBox.Show(reader.GetAttribute("bgName"));
                        Project.assets.rooms[num].tiles.Add(new ProjectAssets.Rooms.Tile());
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

                MessageBox.Show(Project.assets.rooms[num].ToString());
            }
        }

        private void BackgroundRead(string xmlFile)
        {
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

        private void contentsToolStripMenuItem_Click(object sender, EventArgs e){
            int gridus = int.Parse(info.Text);
            int gridus2 = int.Parse(info2.Text);
            div_left.Controls.Clear();
            // Create an instance of the open file dialog box.
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            openFileDialog1.ShowDialog();

            bt = new BackgroundTile(openFileDialog1.FileName, gridus, gridus);
            ((BackgroundTile)bt).drawBackgroundTile(div_left);

            sr = new SimpleRoom(gridus2, gridus2, gridus, gridus);
            ((SimpleRoom)sr).drawSimpleRoom(div_center);
            //bt.drawBackgroundTile(div_right);
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e){
            TestForm f = new TestForm();
            f.Show();
        }

    }
}
