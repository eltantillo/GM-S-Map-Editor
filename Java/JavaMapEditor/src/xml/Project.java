/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

/**
 *
 * @author eltan
 */
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class Project {
    public static String projectName;
    public static String projectFolder;
    public static xml.projectAssets.Assets assets;

    public static NodeList xmlScan(Document doc, String assetTag, String folder){
        NodeList nList = doc.getElementsByTagName(assetTag + "s");
        NodeList objects = null;
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                if(eElement.getAttribute("name").equals(folder)){
                    objects = eElement.getElementsByTagName(assetTag);
                }
            }
        }
        return objects;
    }
    
    public static void OpenProject()
    {
    	JFileChooser fileChooser = new JFileChooser ();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("GameMaker: Studio Project Files", "gmx");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            assets = new xml.projectAssets.Assets();
            projectFolder = fileChooser.getCurrentDirectory().getAbsolutePath() + "\\";
            projectName = fileChooser.getSelectedFile().getName();
            
            System.out.println(projectFolder + projectName);
            
            File fXmlFile = new File(projectFolder + projectName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);
                NodeList objects = null;
                
                objects = xmlScan(doc, "background", "background");
                for(int i = 0; i < objects.getLength(); i++){
                    assets.backgrounds.add(new xml.projectAssets.backgrounds.Background());
                    int num = assets.backgrounds.size() - 1;
                    assets.backgrounds.get(num).BackgroundRead(objects.item(i).getTextContent());
                }
                
                objects = xmlScan(doc, "room", "rooms");
                for(int i = 0; i < objects.getLength(); i++){
                    assets.rooms.add(new xml.projectAssets.rooms.Room());
                    int num = assets.rooms.size() - 1;
                    assets.rooms.get(num).RoomRead(objects.item(i).getTextContent());
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    	
        /*    List<string> _rooms = new List<string>();
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

            foreach(GMSMapEditor.ProjectAssets.Rooms.Room r in assets.rooms){
                srs.Add(new SimpleRoom(r.width, r.height,r.tiles));
            }
            foreach(GMSMapEditor.ProjectAssets.Backgrounds.Background t in assets.backgrounds){
                if(t.istileset){
                    bts.Add(new BackgroundTile(t.image,t.name,t.tilewidth,t.tileheight));
                }
            }
            foreach(SimpleRoom sr in srs){
                sr.roomIni(bts);
            }
        }*/
    }

    public static void NewProject()
    {
        /*SaveFileDialog projectFile = new SaveFileDialog();
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
        }*/
    }

    public static void SaveProject()
    {
        /*try
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
        }*/
    }

    //Save As
    /*public static void DeepCopy(DirectoryInfo source, DirectoryInfo target)
    {

        // Recursively call the DeepCopy Method for each Directory
        foreach (DirectoryInfo dir in source.GetDirectories())
            DeepCopy(dir, target.CreateSubdirectory(dir.Name));

        // Go ahead and copy each file in "source" to the "target" directory
        foreach (FileInfo file in source.GetFiles())
            file.CopyTo(Path.Combine(target.FullName, file.Name));

    }*/
}
