package house.locations.outdoor;

import house.locations.Location;
import java.util.Map;
import house.utils.GameUtils;

public class BackYard extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();
    
    public BackYard(String name, Map<String, Location> locations) 
    {
        super(name, locations);
        
        inputs.put(new String[] {
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "The house comes with a few acres of forested land. The land behind the porch is dark with brush and tree shadows. You almost expect something to come out of the darkness. "));
        
        inputs.put(new String[] {
            "swing"
        }, new LocationInfo(this.getName(), "You would rather not get tetanus today, but you push the seat forward a bit. The sound of creeking brings back good memories. "));

        inputs.put(new String[] {
            "ball", "inflate", "play"
        }, new LocationInfo(this.getName(), "You feel bad for the deflated balls, but their time has come. No need to defile the dead. "));
        
        inputs.put(new String[] {
            "woods", "wander", "forest", "trees"
        }, new LocationInfo(this.getName(), "The surrounding forest stretches out into near-total darkness. The idea of getting lost in there is too menacing to risk. "));

        inputs.put(new String[] {
            "inside", "kitchen", "go in", "house", "anteroom", "door"
        }, new LocationInfo("backExit", "You walk into the house. "));

        inputs.put(new String[] {
            "side", "path", "front", "car"
        }, new LocationInfo("sidePath", "You walk around the side of the house. "));
    }
    
    public void enter()
    {
        System.out.println(END_OF_LINE);
        System.out.println("You are behind the house. The heavily rusted old swing probably hasn't swung in years. There is also a deflated ball or two in the grass right under the wooden porch. " + END_OF_LINE + "The back door is ajar. There is a side path that curves around back to the front of the house. ");
        GameUtils.checkInput();
    }
}