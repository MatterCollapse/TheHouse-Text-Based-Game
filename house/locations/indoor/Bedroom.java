package house.locations.indoor;

import house.locations.Location;
import java.util.Map;
import house.utils.GameUtils;

public class Bedroom extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();
    
    public Bedroom(String name, Map<String, Location> locations) 
    {
        super(name, locations);
        
        inputs.put(new String[] {
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "It is the most absolutely amazingly inconcievably empty room you have ever had the pleasure of visiting. " + GameUtils.END_OF_LINE + "This was truelly an eye-opening experience. "));

        inputs.put(new String[] {
            "listen", "hide", "monster", "what", "hear"
        }, new LocationInfo(this.getName(), "You stand still and listen silently. ", "listen"));

        inputs.put(new String[] {
            "kitchen", "leave", "exit", "out"
        }, new LocationInfo("livingRoom", "you walk back out into the living room. "));
    }
    
    public void enter()
    {
        System.out.println(END_OF_LINE);
        System.out.println("This must have been a bedroom at one point or another, but now it is absolutely empty." + GameUtils.END_OF_LINE + " There are 4 walls, wooden rafters, and a carpeted floor which smells of something foul. ");
        GameUtils.checkInput();
    }
}