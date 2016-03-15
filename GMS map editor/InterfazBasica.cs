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
using System.Drawing.Drawing2D;

namespace GMSMapEditor{
    public partial class InterfazBasica : Form{

        int tilePositionXO,tilePositionYO,tilePositionXF, tilePositionYF;
        int mapPositionX, mapPositionY;
        int gridus;
        int dimsX, dimsY;

        Object bt;
        Object sr;
        bool clicked;
        bool clickedV2;

        public InterfazBasica(){
            InitializeComponent();
            clicked = false;
            clickedV2 = false;
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
                } while (reader.ReadToNextSibling("view")) ;

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
            gridus = 32;
            int gridus2 = 32;
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.Multiselect = false;
            openFileDialog1.ShowDialog();
            
            bt = new BackgroundTile(openFileDialog1.FileName, gridus, gridus);
            ((BackgroundTile)bt).drawBackgroundTile(pb);

            sr = new SimpleRoom(gridus2, gridus2);
            pb2.Location = new Point(0,0);
            pb2.Height = gridus2 * gridus;
            pb2.Width = gridus2 * gridus;
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e){
            TestForm f = new TestForm();
            f.Show();
        }
        private void div_left_MouseClick(object sender, MouseEventArgs e){
            if (clicked){
                clicked = false;
            }
            else{
                tilePositionXO = ((BackgroundTile)bt).positionX(e.Location.X);
                tilePositionYO = ((BackgroundTile)bt).positionY(e.Location.Y);
                clicked = true;
            }
        }
        private void pb_MouseMove(object sender, MouseEventArgs e){
            if (e.Button == System.Windows.Forms.MouseButtons.Left){
                Control control = (Control) sender;
                if (control.Capture){
                    control.Capture = false;
                }
                if (control.ClientRectangle.Contains (e.Location)){
                    if(tilePositionXF!= (int)Math.Floor((Decimal)e.Location.X/32) ){
                        pb.Image = ((BackgroundTile)bt).getClonedImage();
                    }
                    if (tilePositionYF != (int)Math.Floor((Decimal)e.Location.Y / 32)){
                        pb.Image = ((BackgroundTile)bt).getClonedImage();
                    }
                    tilePositionXF = ((BackgroundTile)bt).positionX(e.Location.X);
                    tilePositionYF = ((BackgroundTile)bt).positionY(e.Location.Y);

                    coords.Text="Donde esta el origen?\n"+tilePositionXO+tilePositionYO;

                    ((BackgroundTile)bt).setSelection(new Point(tilePositionXO,tilePositionYO),new Point(tilePositionXF,tilePositionYF));

                    pb.Image = ((BackgroundTile)bt).drawRectangle();
                }
            }
        }

        private void pb2_MouseMove(object sender, MouseEventArgs e){
            int tamY = dimsY+1;
            int tamX = dimsX+1;
            if (mapPositionX != ((int)Math.Floor((Decimal)e.Location.X / gridus) * gridus)+gridus){
                pb2.Image = (Image)((SimpleRoom)sr).i.Clone();
            }
            if (mapPositionY != ((int)Math.Floor((Decimal)e.Location.Y / gridus) * gridus)+gridus){
                pb2.Image = (Image)((SimpleRoom)sr).i.Clone();
            }
            
            mapPositionX = ((int)Math.Floor((Decimal)e.Location.X / gridus) * gridus)+gridus;
            mapPositionY = ((int)Math.Floor((Decimal)e.Location.Y / gridus) * gridus)+gridus;

            otro.Text = "Dif:" + dimsX +","+dimsY+ "\nCOX" + mapPositionX + "," + "COY" + mapPositionY + "\n" + "CFX" + Math.Floor((Decimal)e.Location.X / gridus) + "," + "CFY" + Math.Floor((Decimal)e.Location.Y / gridus);

            Graphics mapArea = pb2.CreateGraphics();
            Image i = ((BackgroundTile)bt).getTruncateImage(
                    tilePositionXO,
                    tilePositionYO,
                    tamX,
                    tamY
                );
            if (i != null){
                mapArea.DrawImage(
                    i,
                    new Point(mapPositionX-(tamX*gridus),mapPositionY-(tamY*gridus))
                );
            }
            if (e.Button == System.Windows.Forms.MouseButtons.Left)
            {
                Control control = (Control)sender;
                if (control.Capture)
                {
                    control.Capture = false;
                }
                if (control.ClientRectangle.Contains(e.Location))
                {
                    for(int x=0;x<dimsX;x++){
                        for(int y=0;y<dimsY;y++){
                            ((SimpleRoom)sr).setImage(((int)Math.Floor((Decimal)e.Location.X / gridus)),((int)Math.Floor((Decimal)e.Location.Y / gridus)),new Point(tilePositionXO+x,tilePositionXF+y));
                        }
                    }
                    pb2.Image = ((SimpleRoom)sr).getSimpleRoomImage((BackgroundTile)bt);
                }
            }
        }

        private void pb2_MouseClick(object sender, MouseEventArgs e){
            for (int x = 0; x < dimsX; x++)
            {
                for (int y = 0; y < dimsY; y++)
                {
                    ((SimpleRoom)sr).setImage(((int)Math.Floor((Decimal)e.Location.X / gridus)), ((int)Math.Floor((Decimal)e.Location.Y / gridus)), new Point(tilePositionXO + x, tilePositionXF + y));
                }
            }
            pb2.Image = ((SimpleRoom)sr).getSimpleRoomImage((BackgroundTile)bt);
        }
        
    }
}
