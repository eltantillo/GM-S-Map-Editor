/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.projectAssets.rooms;

/**
 *
 * @author eltan
 */
import java.util.concurrent.ThreadLocalRandom;

public class Instance {
    public String objName = "";
    public String name;
    public String code = "";
    public String colour = "4294967295";
    public double scaleX = 1;
    public double scaleY = 1;
    public double rotation = 0;
    public boolean locked = false;
    public int x = 0;
    public int y = 0;

    public Instance(){
        this.name = "inst_" + ThreadLocalRandom.current().nextInt(0, 999999999 + 1);
    }
}
