package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import javax.imageio.ImageIO;
import sun.awt.image.ToolkitImage;

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
    static BufferedImage clone(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
    public static void setAlpha(BufferedImage obj_img) {
        byte alpha = (byte)200;
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
    public static BufferedImage stretch(BufferedImage src, int w, int h){
//        int finalw = w;
//        int finalh = h;
//        double factor = 1.0d;
//        if(src.getWidth() > src.getHeight()){
//            factor = ((double)src.getHeight()/(double)src.getWidth());
//            finalh = (int)(finalw * factor);                
//        }else{
//            factor = ((double)src.getWidth()/(double)src.getHeight());
//            finalw = (int)(finalh * factor);
//        }   

        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(src, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
    public static BufferedImage darker(BufferedImage img){
        Graphics g = img.getGraphics();
        float percentage = .5f; // 50% bright - change this (or set dynamically) as you feel fit
        int brightness = (int)(256 - 256 * percentage);
        g.setColor(new Color(0,0,0,brightness));
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        return img;
    }
    
    
}
