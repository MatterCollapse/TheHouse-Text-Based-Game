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
            "mug"
        }, new LocationInfo(this.getName(), "The mug still has traces of coffee, but is now empty. "));

        inputs.put(new String[] {
            "computer", "bag", "dell"
        }, new LocationInfo(this.getName(), "Your Dell is in the bag ready for work. There's some random paperwork, pens and pencils. " + END_OF_LINE + "You unzip the smallest pouch and pull out a pieace of lined paper folded a few times over. Your friend at work wrote the address on this impromptu paper. He also drew a sketch of the thing I was looking for. " + END_OF_LINE + "He said it was a small amulet in a black box, and looked kind of like an eye with an X arround it, or like two Xs spliced together by two corners. "));

        inputs.put(new String[] {
            "out", "leave", "door", "yard"
        }, new LocationInfo("frontYard", "You open the car door and step out. "));
    }

    public void enter()
    {
        System.out.println(END_OF_LINE);
        System.out.println("You turn the car keys and pull them out after parking out on an overgrown lawn. You think this is the address your friend gave you. " + END_OF_LINE + "You have arrived at the house. If a single-story home could be said to loom before you, this one was. " + END_OF_LINE + "You need to get out of the car and walk around the house. Look around carefully anywhere you can. You are looking for a little black box. From your friend's panic you guess it's somewhat important. ");
        GameUtils.checkInput();
    }
}