package house.locations.outdoor;

import house.locations.Location;
//import house.thehouse.house.locations.indoor.LivingRoom;

import java.util.Map;
import house.utils.GameUtils;

public class FrontDoor extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();
    
    public FrontDoor(String name, Map<String, Location> locations) 
    {
        super(name, locations);
        
        inputs.put(new String[] { //"Look around" input setup
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "The door is old and hollow on the inside. You can tell by a small hole in the bottom right corner. " + END_OF_LINE + "There seem to have also been a grate at some point, but only the hinges remain. "));

        inputs.put(new String[] {
            "leave", "back", "path", "front", "yard", "outside", "car"
        }, new LocationInfo("frontYard", "You walk back out into the front yard. "));
    }
    
    public void enter()
    {
        if(GameUtils.openingFrontDoor)
        {
            inputs.put(new String[] {
                "living room", "inside", "go in"
            }, new LocationInfo("livingRoom", "You enter the living Room. "));
            GameUtils.openingFrontDoor = false;
        }

        if(GameUtils.frontDoorOpen)
        {
            System.out.println(END_OF_LINE);
            System.out.println("You push the front door open with a loud squeek. " + END_OF_LINE + "The door is wide open. ");
            GameUtils.checkInput();
            
        }
        else
        {
            System.out.println(END_OF_LINE);
            System.out.println("Despite heavy rusting, the lock is holding. " + END_OF_LINE + "You will need to find another way in. ");
            GameUtils.checkInput();
        }
    }
}