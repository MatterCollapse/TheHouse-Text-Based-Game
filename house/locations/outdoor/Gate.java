package house.locations.outdoor;

import house.locations.Location;
import java.util.Map;
import house.utils.GameUtils;

public class Gate extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();

    public Gate(String name, Map<String, Location> locations) 
    {
        super(name, locations);

        inputs.put(new String[] {
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "The Gate is old and rusted. The lock on it oddly no longer locks. "));
        
        inputs.put(new String[] {
            "close", "shut"
        }, new LocationInfo(this.getName(), "", "closeGate"));

        inputs.put(new String[] {
            "open"
        }, new LocationInfo(this.getName(), "", "openGate"));

        inputs.put(new String[] {
            "back", "leave", "house", "yard", "car"
        }, new LocationInfo("frontYard", "You walk back up the hill to the front yard. "));
    }

    public void enter()
    {
        if(GameUtils.gateOpen)
        {
            System.out.println(END_OF_LINE);
            System.out.println("You stand before the gate you came in through. It is open wide at this moment. ");
            GameUtils.checkInput();
            
        }
        else
        {
            System.out.println(END_OF_LINE);
            System.out.println("You stand before the gate you came in through. It is closed at this moment. ");
            GameUtils.checkInput();
        }
    }
}