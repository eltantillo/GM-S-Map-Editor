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
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

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
    
    public static void openProject(){
    	JFileChooser fileChooser = new JFileChooser();
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

    public static void newProject(){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("GameMaker: Studio Project Files", "gmx");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            projectName = fileChooser.getSelectedFile().getName() + ".project.gmx";
            projectFolder = fileChooser.getCurrentDirectory().getAbsolutePath() + "\\" + projectName.split("\\.")[0] + ".gmx\\";
            
            File folder = new File(projectFolder);
            if (folder.exists()) {
                showMessageDialog(null, "Ya existe un proyecto con el mismo nombre, elija uno distinto.");
                newProject();
            }
            else{
                File mainFile    = new File(projectFolder + projectName);
                File bgFolder    = new File(projectFolder + "background");
                File bgImgFolder = new File(projectFolder + "background\\images");
                File roomFolder  = new File(projectFolder + "rooms");
                File objFolder   = new File(projectFolder + "objects");
                folder.mkdir();
                bgFolder.mkdir();
                bgImgFolder.mkdir();
                roomFolder.mkdir();
                objFolder.mkdir();
                
                File source = new File(Project.class.getResource("/newProjectFiles").getPath());
                File dest   = new File(projectFolder);
                try {
                    FileUtils.copyDirectory(source, dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                try {
                    mainFile.createNewFile();
                    FileWriter fw = new FileWriter(mainFile);
                    fw.write(
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
                    fw.flush();
                    fw.close();
                    assets = new xml.projectAssets.Assets();
                } catch (IOException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void saveProject(){
        try {
            File fXmlFile                    = new File(projectFolder + projectName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder         = dbFactory.newDocumentBuilder();
            Document doc                     = dBuilder.parse(fXmlFile);
            
            NodeList nodes = doc.getElementsByTagName("backgrounds");
            for (xml.projectAssets.backgrounds.Background background : assets.backgrounds)
            {
                if (background.isNew)
                {
                    Text a    = doc.createTextNode("background\\" + background.name); 
                    Element p = doc.createElement("background"); 
                    p.appendChild(a);
                    nodes.item(0).appendChild(p);
                }
                if (background.hasChanges)
                {
                    File bgFile = new File(projectFolder + "background\\" + background.name + ".background.gmx");
                    bgFile.delete();
                    bgFile.createNewFile();
                    FileWriter fw = new FileWriter(bgFile);
                    fw.write(background.toString());
                    fw.flush();
                    fw.close();
                }
            }
            
            nodes = doc.getElementsByTagName("rooms");
            for(xml.projectAssets.rooms.Room room : assets.rooms)
            {
                if (room.isNew)
                {
                    Text a    = doc.createTextNode("rooms\\" + room.name);
                    Element p = doc.createElement("room");
                    p.appendChild(a);
                    nodes.item(0).appendChild(p);
                }
                if (room.hasChanges)
                {
                    File bgFile = new File(projectFolder + "rooms\\" + room.name + ".room.gmx");
                    bgFile.delete();
                    bgFile.createNewFile();
                    FileWriter fw = new FileWriter(bgFile);
                    fw.write(room.toString());
                    fw.flush();
                    fw.close();
                }
            }
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            Source input  = new DOMSource(doc);
            Result output = new StreamResult(new File(projectFolder + projectName));

            transformer.transform(input, output);
            
            System.out.println();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Save As
    public static void saveProjectAs(){
        saveProject();
        
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("GameMaker: Studio Project Files", "gmx");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            String tempProjectName   = fileChooser.getSelectedFile().getName() + ".project.gmx";
            String tempProjectFolder = fileChooser.getCurrentDirectory().getAbsolutePath() + "\\" + tempProjectName.split("\\.")[0] + ".gmx\\";
            
            File source = new File(projectFolder);
            File dest   = new File(tempProjectFolder);
            try {
                FileUtils.copyDirectory(source, dest);
                File oldName = new File(tempProjectFolder + projectName);
                File newName = new File(tempProjectFolder + tempProjectName);
                oldName.renameTo(newName);
                projectFolder = tempProjectFolder;
                projectName   = tempProjectName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
