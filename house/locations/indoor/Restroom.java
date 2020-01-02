package house.locations.indoor;

import house.locations.Location;
import java.util.Map;
import house.utils.GameUtils;

public class Restroom extends Location
{
    public static final String END_OF_LINE = System.lineSeparator();
    
    public Restroom(String name, Map<String, Location> locations) 
    {
        super(name, locations);
        
        inputs.put(new String[] {
            "look around", "examine", "check around"
        }, new LocationInfo(this.getName(), "There is a plunger, a toilet, bath, no  toilet paper or soap. That's all the detail you get. "));

        inputs.put(new String[] {
            "listen", "hide", "monster", "what", "hear"
        }, new LocationInfo(this.getName(), "Despite your better judgement, you close the door, crouch behind it and listen silently. ", "listen"));

        inputs.put(new String[] {
            "toilet", "use", "poop"
        }, new LocationInfo(this.getName(), "You don't need to go, plus, it doesn't work anyway. "));

        inputs.put(new String[] {
            "toilet paper", "paper"
        }, new LocationInfo(this.getName(), "There is no toilet paper. "));

        inputs.put(new String[] {
            "kitchen", "leave", "exit", "out"
        }, new LocationInfo("kitchen", "you leave the restroom. "));
    }
    
    public void enter()
    {
        System.out.println(END_OF_LINE);
        System.out.println("It is dusty, and you can see spots of mold, but you have to admit it's cleaner than you expected. ");
        if(GameUtils.monsterReleased)
        {
            System.out.println("The room is small and leads out into the kitchen. If you needed to hide, this wouldn't be the place. It's too small, and the door does not lock. " + END_OF_LINE + "However, you might still afford to listen carefully to any sounds coming from any nearby rooms if you listen closer. ");
        }
        GameUtils.checkInput();
    }
}