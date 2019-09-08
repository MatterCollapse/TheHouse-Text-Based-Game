package house.locations.outdoor;

import house.locations.Location;
import java.util.Map;
import house.utils.GameUtils;

public class FrontYard extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();

    public FrontYard(String name, Map<String, Location> locations) 
    {
        super(name, locations);

        inputs.put(new String[] {
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "It's very empty, save for a trash can by the house wall and the circle of forest all around."));

        inputs.put(new String[] {
            "gate"
        }, new LocationInfo(this.getName(), "Closing the gate now means opening it later. That is far too much effort."));

        inputs.put(new String[] {
            "front", "door"
        }, new LocationInfo("frontDoor", "You walk through thick grass to the front door. "));

        inputs.put(new String[] {
            "path", "side", "around", "back", "back yard", "backyard"
        }, new LocationInfo("sidePath", "you walk up the side path. "));

        inputs.put(new String[] {
            "car", "return"
        }, new LocationInfo(this.getName(), "The car is waiting for you patiently. ", "carCheck"));
    }

    public void enter()
    {
        System.out.println(END_OF_LINE);
        System.out.println("You stand up to the knees in grass and see trees on either side of the house. " + END_OF_LINE + "You arrived here via a narrow private road gated off by the rusted remains of an iron gate. " + END_OF_LINE + "A wooden step with no porch leads to the step door. There is no wind. " + END_OF_LINE + "There is also a narrow path to the left around the house paved with stone steps. ");
        GameUtils.checkInput();
    }
}