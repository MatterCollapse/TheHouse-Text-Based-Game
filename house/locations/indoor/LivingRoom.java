package house.locations.indoor;

import house.locations.Location;
import java.util.Map;
import house.utils.GameUtils;

public class LivingRoom extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();
    
    public LivingRoom(String name, Map<String, Location> locations) 
    {
        super(name, locations);
        
        inputs.put(new String[] {
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "The floor is of linoleum tiles positioned less than perfectly. A vertical window rests next to the door. "));

        inputs.put(new String[] {
            "go back", "front"
        }, new LocationInfo("frontDoor", "you head towards the front door. ", "unlock"));

        inputs.put(new String[] {
            "kitchen"
        }, new LocationInfo("kitchen", "you pass through the archeway. "));
    }
    
    public void enter()
    {
        System.out.println(END_OF_LINE);
        System.out.println("A round dining room table sits in the center of the room. It is bare and has two large stains. " + END_OF_LINE + "In one back corner is an armchair and a small bookshelf. " + END_OF_LINE + "Whoever lived here took all the books with them. " + END_OF_LINE + "In another corner is a couch, looking rather awkward. Maybe there was a TV on the other wall at some point. " + END_OF_LINE + "A short step sits under the front door, and an arche on the adjacent wall opens up into the kitchen. ");
        GameUtils.checkInput();
    }
}