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
        }, new LocationInfo(this.getName(), "Dust is hanging in the air. Instead of a lamp on the ceiling, there is only a hole for one. " + END_OF_LINE + "A metal grate door separates the kitchen from a small room leading to the back yard. A long curtainless window sits over a sink and shows the back patio. "));

        inputs.put(new String[] {
            "laundry"
        }, new LocationInfo("laundryRoom", "you open the laundry room door. "));

        inputs.put(new String[] {
            "fridge", "refridgerator", "food"
        }, new LocationInfo(this.getName(), "you open the refridgerator door. It's grimy and empty, save for a single rat which seems to have starved to death inside. You shut the door so as not to puke. "));

        inputs.put(new String[] {
            "stove", "oven"
        }, new LocationInfo(this.getName(), "The stove is beyond repair. A thick layer of dust and grime has settled atop it. When you open the oven door some metal rod gets dislodged." + GameUtils.END_OF_LINE + " You close it back up. "));

        inputs.put(new String[] {
            "toaster"
        }, new LocationInfo(this.getName(), "The toaster is dead. Extremely dead. "));

        inputs.put(new String[] {
            "window", "look out"
        }, new LocationInfo(this.getName(), "you look out the far window. It's the backyard, nothing more. "));

        inputs.put(new String[] {
            "clean", "dust"
        }, new LocationInfo(this.getName(), "No, maybe you won't. "));

        inputs.put(new String[] {
            "back", "grate", "backyard", "back door"
        }, new LocationInfo("backExit", "you open a metal grate door to a short hall or anteroom. "));

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
        System.out.println("The Kitchen. There are the expected pieces: an old fridge, dirty stove, archaic toaster. " + END_OF_LINE + "The counter tops are covered in stains coated by dust. A trash bag full of beer bottles, cans, lays spilled across the floor. " + END_OF_LINE + "A large empty island stands in the middle to break up the space. " + END_OF_LINE + "The restroom and the laundry room are two doors towards the side of the room on opposite walls, but there is also a metal grate leading to a back hall and a large arche leading to the living room. ");
        GameUtils.checkInput();
    }
}