package house.locations.indoor;

import house.locations.Location;
import java.util.Map;
import house.utils.GameUtils;

public class BackExit extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();
    
    public BackExit(String name, Map<String, Location> locations) 
    {
        super(name, locations);
        
        inputs.put(new String[] {
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "There is a small window into the kitchen, and an air conditioning box over the secondary door. " + END_OF_LINE + "Literally nothing else."));

        inputs.put(new String[] {
            "yard", "back", "out", "leave", "backyard", "forest", "grass"
        }, new LocationInfo("backYard", "you pass through to the back yard. "));

        inputs.put(new String[] {
            "inside", "go in", "kitchen", "house", "living room", "front door"
        }, new LocationInfo("kitchen", "you open the secondary door and enter the kitchen. "));
    }
    
    public void enter()
    {
        System.out.println(END_OF_LINE);
        System.out.println("A short hall with doors on either end. There is a coatrack, but other than that this room seems a mistake in construction. " + END_OF_LINE + "It is completely useless. " + END_OF_LINE + "It is an intermediate area between the back yard and kitchen. ");
        GameUtils.checkInput();
    }
}