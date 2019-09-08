package house.locations.outdoor;

import house.locations.Location;
import java.util.Map;
import house.utils.GameUtils;

public class SidePath extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();
    
    public SidePath(String name, Map<String, Location> locations) 
    {
        super(name, locations);
        
        inputs.put(new String[] {
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "There are no windows on this side of the house. " + END_OF_LINE + "The floor under your feet is tiled with bricks that have either been burried under dirt or have dislocated from the pattern."));

        inputs.put(new String[] {
            "sit", "planter"
        }, new LocationInfo(this.getName(), "You decide to sit down on the planter. " + END_OF_LINE + "What a good sit. " + END_OF_LINE + "It might be just about the best sit you have ever sat, but now you have business to attend to, and you are standing back up."));

        inputs.put(new String[] {
            "go back", "front", "car", "front door"
        }, new LocationInfo("frontYard", "you return to the front yard. "));

        inputs.put(new String[] {
            "back yard", "backyard", "forward", "behind", "swing"
        }, new LocationInfo("backYard", "you pass through to the back yard. "));
    }
    
    public void enter()
    {
        System.out.println(END_OF_LINE);
        System.out.println("Trees and planters to the left, the house wall to the right. " + END_OF_LINE + "There is a long wooden bench keeping back a hill of dirt used as a planter. " + END_OF_LINE + "The narrowness of the path plus the treetops overhead make it feel like a room outdoors. " + END_OF_LINE + "You are between the front and back yard. ");
        GameUtils.checkInput();
    }
}