package graficos;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageTools {
    public static BufferedImage getFoto(File fileEntry){
        BufferedImage originalImage = null;
        try{
            originalImage = ImageIO.read(fileEntry);
        }
        catch(Exception ex){
            return new BufferedImage(0, 0, 0);
        }
        return originalImage;
    }
    public static BufferedImage cut(BufferedImage img,int width,int height,int x,int y){
        return img.getSubimage(x, y, width, height);
    }
    public static BufferedImage copyPaste(BufferedImage copy,int x,int y, BufferedImage paste){
        Graphics2D gr = paste.createGraphics();  
        gr.drawImage(copy, x, y, copy.getWidth(), copy.getHeight(), null);
        gr.dispose();
        return paste;
    }
    public static BufferedImage copyPasteAlfa(BufferedImage copy,int x,int y, BufferedImage paste){
        Graphics2D gr = paste.createGraphics();
        gr.drawImage(copy, x, y, copy.getWidth(), copy.getHeight(), null);
        gr.dispose();
        setAlpha((byte)125,paste);
        return paste;
    } 
    static BufferedImage clone(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
    public static void setAlpha(byte alpha, BufferedImage obj_img) {       
        alpha %= 0xff; 
        for (int cx=0;cx<obj_img.getWidth();cx++) {          
            for (int cy=0;cy<obj_img.getHeight();cy++) {
                int color = obj_img.getRGB(cx, cy);

                int mc = (alpha << 24) | 0x00ffffff;
                int newcolor = color & mc;
                obj_img.setRGB(cx, cy, newcolor);            

            }

        }
    }
    public static void erase(int x,int y,int width, int height, BufferedImage toErase){
        Graphics2D g = toErase.createGraphics();
        g.clearRect(x, y, width, height);
    }
    
}
