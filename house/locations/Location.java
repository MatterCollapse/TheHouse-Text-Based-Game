package house.locations;

import house.Monster;
import house.utils.*;
import java.util.HashMap;
import java.util.Map;

public class Location { //default location class, parent to all locations

    private final String name;
    protected final Map<String, Location> locations;
    public final Map<String[], LocationInfo> inputs;
    public static final String END_OF_LINE = System.lineSeparator();

    public Location(String name, final Map<String, Location> locations) {
        this.name = name;
        this.locations = locations;
        inputs = new HashMap<String[], LocationInfo>();
    }

    public String getName() {
        if(name == null) {
            System.out.println("NULL NAME");
        }
        return name;
    }

    public void enter() {}
    
    public Location checkInput(String result) 
    {
        LocationInfo location = resolveLocation(result);
        if (null != location) {
            System.out.println(location.dialogText);
            if(location.event == "awaken" && GameUtils.monsterReleased == false)
            {
                GameUtils.monsterReleased = true;
                Monster.position = "backYard";
                GameUtils.gateOpen = false;
                System.out.println("Quite empty, although... " + GameUtils.END_OF_LINE + "Under those cardboard boxes you see the sharp edge of something black. covering your nose, you pull up the large pile of rotting cardboard. The underside is not as disgusting as you thought, just layers of dark dirt. " + GameUtils.END_OF_LINE + "The box is metal and painted black. The lock was busted by a blunt object and one of the sides is bent in. You pry the lid open partway with your keys, then pull the edge of the lid open by force. The walls of the box are very thin. " + GameUtils.END_OF_LINE + "Inside are multiple layers of dry rags and plastic wrap, and underneath you pull out a small black pendant. It is black metal too. You don't know the abstract shape but you know this is what you were looking for" + GameUtils.END_OF_LINE + "You pocket it and walk back over to the ladder. ");
                System.out.println("You push an empty bottle with your foot walking back. It rolls and hits the base of a shelf with a clink. ");
                System.out.println("Something up above responds. You hear rattling throughout the house upstairs. The chill down your spine is telling you not to check it out. ");
            }
            else if(location.event == "unlock")
            {
                if(GameUtils.frontDoorOpen == false)
                {
                    GameUtils.openingFrontDoor = true;
                }
                GameUtils.frontDoorOpen = true;
                System.out.println("you open the door from the inside. ");
            }
            else if(location.event == "listen")
            {
                if(Monster.position == "kitchen")
                {
                    System.out.println("You hear footsteps through the door. You also hear... static? Something is in the kitchen. ");
                }
                else if(Monster.position == "backYard")
                {
                    System.out.println("Something is wandering in the back yard. You hear footsteps on dirt, and... static? You can't see it through the small window. ");
                }
                else if(Monster.position == "livingRoom")
                {
                    System.out.println("You hear slow, undirected footsteps on hardwood floor. You also hear... static? Something is barely audible from the living room. ");
                }
                else if(Monster.position == "backExit")
                {
                    System.out.println("You hear something moving outside the kitchen. You also hear... static? It isn't outside but not quite in the kitchen either. Must be the anteroom. ");
                }
                else if(Monster.position == "restroom")
                {
                    System.out.println("Something wandered into the restroom. ");
                }
                else 
                {
                    System.out.println("It is very quiet. Leaves bristle outside. ");
                }
            }
            else if(location.event == "carCheck")
            {
                if(GameUtils.monsterReleased) 
                {
                    if(GameUtils.gateOpen)
                    {
                        System.out.println("You jump into the car, turn the ignition, put the car in reverse and step on the gas. " + END_OF_LINE + "As you drive out onto the near road you see something open the front door. " + END_OF_LINE + "It is tall and shapeless. " + END_OF_LINE + "Your farsighted vision must have gotten worse, because you couldn't tell what it looked like, or even what color it was. ");
                        GameUtils.pause(10);
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("The gate is closed. While the resultant scratches aren't a primary concern at the moment, you are still not busting down the gate with your car. ");
                    }
                }
                else
                {
                    System.out.println("You don't need to go yet. ");
                }
            }
            else if(location.event == "opengate")
            {
                if(GameUtils.gateOpen)
                {
                    System.out.println("The Gate is already open. ");
                    GameUtils.pause(10);
                }
                else
                {
                    System.out.println("You push the gate out and it swings wide open. ");
                    GameUtils.gateOpen = true;
                    GameUtils.pause(10);
                }
            }
            else if(location.event == "closegate")
            {
                if(GameUtils.gateOpen)
                {
                    System.out.println("You walk out to get both sides of the gate and line them up to make them look closed. Mission accomplished. ");
                    GameUtils.gateOpen = false;
                    GameUtils.pause(10);
                }
                else
                {
                    System.out.println("The gate is already closed... so to speak. ");
                    GameUtils.pause(10);
                }
            }

            return null != location.loc ? locations.get(location.loc) : null;
        }
        else
        {
            System.out.println("I do not understand, please rephrase yourself. ");
            GameUtils.checkInput();
            return null; //DONT DO THIS!!!
        }
    }

    LocationInfo resolveLocation(String key) //ResolveLocation determines if a string contains one of the contents of the list
    {
        for (Map.Entry<String[], LocationInfo> entry : inputs.entrySet()) {
            for (String keyword : entry.getKey()) {
                if (key.contains(keyword))
                {
                    LocationInfo locationInfo = entry.getValue();
                    if (null != locationInfo && null != locationInfo.loc) {
                        //System.out.println("--1.2 : ResolveLocation : " + locationInfo.loc + "--"); //ENTRY.GETVALUE().LOC HAS AN ENTRYTEXT BUT NO INNITIALIZED NAME
                        //System.out.println("--1.3 : ResolveLocation : " + keyword + "--"); //THE KEYWORD IS NOT THE PROBLEM
                        //System.out.println("--1.4 : ResolveLocation : " + key + "--"); //THE KEY MATCHES THE KEYWORD    
                    }
                    else {
                        System.out.println("--1.2 : ResolveLocation : EMPTY--");
                    }

                    return entry.getValue(); 
                }
            }
        }
        return null;
    }

    protected static class LocationInfo {
        public final String loc;
        public final String dialogText;
        public final String event;

        public LocationInfo(String loc, String dialogText) {
            this.loc = loc;
            this.dialogText = dialogText;
            this.event = "";
        }

        public LocationInfo(String loc, String dialogText, String event) {
            this.loc = loc;
            this.dialogText = dialogText;
            this.event = event;
        }
    }
}