package javamapeditor;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class VXtoXP {
    private File transfer;
    public VXtoXP(File i){
        transfer = i;
    }
    public void doStuff(){
        if(transfer.isDirectory()){
            for (File fileEntry : transfer.listFiles()) {
                if (!fileEntry.isDirectory() && (fileEntry.toString().contains(".PNG") || fileEntry.toString().contains(".png"))){
                    try{
                        BufferedImage originalImage = ImageIO.read(fileEntry);
                        int w = originalImage.getWidth();
                        int h = originalImage.getHeight();
                        int c = w/3;
                        int type = 6;
                        System.out.println("Type "+type);
                        BufferedImage fullPic = new BufferedImage( w + c, h, type);
                        Graphics2D g = fullPic.createGraphics();
                        g.drawImage(originalImage.getSubimage(c, 0, c, h),0,0,c,h,null);
                        g.drawImage(originalImage,c,0,w,h,null);
                        g.dispose();
                        ImageIO.write(fullPic, "png", new File(fileEntry.toString().replace("$", "Copy ")));
                    }
                    catch(IOException e){
                            System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
    public void iconSet(){
        int chunkWidth = 24;
        int chunkHeight = 24;
        int type = 6;
        if(transfer.exists()){
            try{
                BufferedImage originalImage = ImageIO.read(transfer);
                int w = originalImage.getWidth();
                int h = originalImage.getHeight();
                int fw = w/24;
                int fh = h/24;
                for(int x=0; x<fw;x++){
                    for(int y = 0; y<fh; y++){
                        BufferedImage fullPic = new BufferedImage(chunkWidth, chunkHeight, type);
                        Graphics2D gr = fullPic.createGraphics();  
                        gr.drawImage(originalImage, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);  
                        gr.dispose();
                        ImageIO.write(fullPic, "png", new File(transfer.toString() + "," + x + "," + y+".png"));
                    }
                }
                
            }
            catch(IOException e){
                    System.out.println(e.getMessage());
            }
        }
    }
}