package house.locations.outdoor;

import house.locations.Location;
import java.util.Map;
import house.utils.GameUtils;

public class Arrival extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();

    public Arrival(String name, Map<String, Location> locations) 
    {
        super(name, locations);

        inputs.put(new String[] {
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "The car is off now that you took the key out. You have a travel mug in the cupholder, and a computer bag under the passenger seat. "));

        inputs.put(new String[] {
            "out", "leave", "door", "yard"
        }, new LocationInfo("frontYard", "You open the car door and step out. "));
    }

    public void enter()
    {
        System.out.println(END_OF_LINE);
        System.out.println("You turn the car keys and pull them out after parking out on an overgrown lawn. You think this is the address your friend gave you. " + END_OF_LINE + "You have arrived at the house. If a single-story home could be said to loom before you, this one was. ");
        GameUtils.checkInput();
    }
}