package house.locations.indoor;

import house.locations.Location;
import java.util.Map;
import house.utils.GameUtils;

public class Kitchen extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();
    
    public Kitchen(String name, Map<String, Location> locations) 
    {
        super(name, locations);
        
        inputs.put(new String[] {
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "Dust is hanging in the air. Instead of a lamp on the ceiling, there is only a hole for one. " + END_OF_LINE + "A metal grate door separates the kitchen from a small room leading to the back yard. A long curtainless window sits over a sink and shows the back patio. ", "awaken"));

        inputs.put(new String[] {
            "back", "grate", "backyard", "back door"
        }, new LocationInfo("backExit", "you open a metal grate door to a short hall or anteroom. "));

        inputs.put(new String[] {
            "laundry"
        }, new LocationInfo("laundryRoom", "you open the laundry room door. "));

        inputs.put(new String[] {
            "bathroom", "restroom", "toilet", "bath", "fascilit"
        }, new LocationInfo("restroom", "you open the restroom door. "));

        inputs.put(new String[] {
            "living room", "back"
        }, new LocationInfo("livingRoom", "you pass into the living room through a wide arche. "));
    }
    
    public void enter()
    {
        System.out.println(END_OF_LINE);
        System.out.println("Small for a bedroom, large for a kitchen. There are the expected pieces: an old fridge, dirty stove, archaic toaster. " + END_OF_LINE + "The counter tops are covered in stains coated by dust. A trash bag full of beer bottles, cans, lays spilled across the floor. " + END_OF_LINE + "A large empty island stands in the middle to break up the space. " + END_OF_LINE + "The restroom and the laundry room are two doors towards the side of the room on opposite walls, but there is also a metal grate leading to a back hall and a large arche leading to the living room. ");
        GameUtils.checkInput();
    }
}