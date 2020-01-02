package house.locations.indoor;

import house.Monster;
import house.locations.Location;
import java.util.Map;
import house.utils.GameUtils;

public class LaundryRoom extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();
    
    public LaundryRoom(String name, Map<String, Location> locations) 
    {
        super(name, locations);
        
        inputs.put(new String[] {
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "Flies seem to have found something of interest here. cockroaches too probably, although they're hidding somewhere. " + END_OF_LINE + "In short, you'd rather not touch anything here."));

        inputs.put(new String[] {
            "listen", "hide", "monster", "what", "hear"
        }, new LocationInfo(this.getName(), "You close the door, crouch behind it and listen silently. ", "listen"));

        inputs.put(new String[] {
            "shelf"
        }, new LocationInfo(this.getName(), "A shelf. "));

        inputs.put(new String[] {
            "dryer", "washing machine"
        }, new LocationInfo(this.getName(), "The washing and drying machine are have rust stains on the inside. It's concerning. "));

        inputs.put(new String[] {
            "take", "rag", "chemical"
        }, new LocationInfo(this.getName(), "Don't take anything. It's all trash. "));

        inputs.put(new String[] {
            "kitchen", "leave", "exit", "out"
        }, new LocationInfo("kitchen", "you walk back out into the kitchen. "));
    }
    
    public void enter()
    {
        System.out.println(END_OF_LINE);
        System.out.println("A dryer, shelf, and washing machine, each of which are dark with dust. Cleaning chemicals and hardened old rags. ");
        if(GameUtils.monsterReleased)
        {
            System.out.println("If you had to hide, you could fit to the side of the door. " + END_OF_LINE + "You might even afford to listen carefully to any sounds coming from any nearby rooms if you listen closer. ");
        }
        GameUtils.checkInput();
    }
}