package house.locations.indoor;

import house.locations.Location;
import java.util.Map;
import house.utils.GameUtils;

public class Basement extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();
    
    public Basement(String name, Map<String, Location> locations) 
    {
        super(name, locations);
        
        inputs.put(new String[] {
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "There is nothing much to see. wet Cardboad boxes have long since started composting in the corner. Bottles lay scattered on the floor. ", "awaken"));

        inputs.put(new String[] {
            "collect", "take", "jars", "kit"
        }, new LocationInfo(this.getName(), "You're not taking anything from here. "));

        inputs.put(new String[] {
            " up", "back", "leave"
        }, new LocationInfo("livingRoom", "You climb up the rattly ladder to the corner of the living room. "));
    }
    
    public void enter()
    {
        System.out.println(END_OF_LINE);
        System.out.println("Dust particles float through the air. You cough reflexively. Metal helves line most of the room in four rows, with two being up against walls. " + GameUtils.END_OF_LINE + "The shelves have some empty jars and an old barbequing kit, but are baren otherwise. " + GameUtils.END_OF_LINE + "With the flip of a lightswitch the room goes from black to a light orange. The presence of flies here is disturbing. ");
        System.out.println("You think this is the most likely place to find what you were looking for. ");
        GameUtils.checkInput();
    }
}