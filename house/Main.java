package house;

//import java.util.Scanner;
//import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;
import house.locations.Location;
import house.locations.outdoor.*;
import house.locations.indoor.*;
import house.utils.GameUtils;

public class Main //Begins the game with a starting screen
{
    public static final String END_OF_LINE = System.lineSeparator();
    
    private static final Map<String, Location> lctns = new HashMap<>();

    public static void main(String[] args)
    {
        lctns.put("arrival", new Arrival("arrival", lctns)); //List new locations here
        lctns.put("frontYard", new FrontYard("frontYard", lctns));
        lctns.put("frontDoor", new FrontDoor("frontDoor", lctns));
        lctns.put("sidePath", new SidePath("sidePath", lctns));
        lctns.put("backYard", new BackYard("backYard", lctns));

        lctns.put("backExit", new BackExit("backExit", lctns));
        lctns.put("kitchen", new Kitchen("kitchen", lctns));
        lctns.put("laundryRoom", new LaundryRoom("laundryRoom", lctns));
        lctns.put("livingRoom", new LivingRoom("livingRoom", lctns));
        lctns.put("restroom", new Restroom("restroom", lctns));
        GameUtils.lctns = lctns;

        System.out.println("Story this = new Story (\"The House\", 1); ");
        GameUtils.pause(1);
        System.out.println("this.innitialize(); ");
        GameUtils.pause(1);
        System.out.println("System.out.println(\"Are You Present ? \"); ");
        GameUtils.pause(1);
        System.out.println("if (user.location = \"here\") { ");
        System.out.println("return y; ");
        System.out.println("} ");
        GameUtils.pause(1);

        if(GameUtils.confirm())
        {
            System.out.println("System.out.println(\"Good . \"); ");
            GameUtils.pause(1);
            System.out.println("System.out.println(\"Let Us Begin Then . \"); ");
            GameUtils.pause(2);
            lctns.get("arrival").enter();
        }
        else
        {
            System.exit(0);
        }
    }
}