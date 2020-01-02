package house.utils;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;

import house.Monster;
import house.locations.Location;
import house.locations.outdoor.*;
import house.locations.indoor.*;

public class GameUtils //Provides the base utilities to be used in Main and each Location, as well as streamlines use of checkinput
{
    private static final Scanner scanner = new Scanner(System.in);
    public static final String END_OF_LINE = System.lineSeparator();
    
    public static String location = "arrival";
    
    public static boolean frontDoorOpen = false;
    public static boolean openingFrontDoor = false;
    public static boolean gateOpen = true;
    public static boolean monsterReleased = false;

    public static Map<String, Location> lctns = new HashMap<>();

    public static void checkInput() //handles all non-binary user inputs
    {
        if(Monster.checkCollision()) 
        {
            if(lctns.get(location).getName() == "restroom")
            {
                System.out.println("To your horror. The monster opens the door before you can leave. He seems less startled than you are. " + END_OF_LINE + "Tall and white, you can't seem to see him. His form shifts, and his color sparks. " + END_OF_LINE + "He wears a hidious old black mask, the only thing on him not changing shape. ");
                System.out.println("He picks you up by the skull. Your eyes hurt from looking at it, and touching his large arm burns your hands. Everything goes hazzy and you black out. " + END_OF_LINE);
                System.out.println("There your story ends on a sour note. Reopen the program to restart, or settle with your fate. ");
                pause(10);
                System.exit(0);
            }
            else 
            {
                System.out.println("As you enter the new location, the monster hears you. " + END_OF_LINE + "He is there, and you walked right to him. " + END_OF_LINE + "Tall and white, you can't seem to see him. His form shifts, and his color sparks. " + END_OF_LINE + "He wears a hidious old black mask, the only thing on him not changing shape. ");
                System.out.println("He picks you up by the skull. Your eyes hurt from looking at it, and touching his large arm burns your hands. Everything goes hazzy and you black out. " + END_OF_LINE);
                System.out.println("There your story ends on a sour note. Reopen the program to restart, or settle with your fate. ");
                pause(10);
                System.exit(0);
            }
        }

        System.out.println("What will you do next? Type 'look around' or 'examine' to get more details on your location, or type the action you wish to commit. " + END_OF_LINE);
        String result = scanner.nextLine();
        pause(1);
        System.out.println(END_OF_LINE);

        Location loc = lctns.get(location); //find the current location
        Location newLocation = loc.checkInput(result); //checkInput for the new location
        
        if(monsterReleased == true && (loc.getName() != newLocation.getName() || newLocation.getName() == "laundryRoom" || newLocation.getName() == "restroom")) 
        {
            Monster.monsterTurn();
        }

        location = newLocation.getName();

        pause(1);
        newLocation.enter();
    }
    
    public static boolean confirm() //handles all binary user inputs
    {
        String result = scanner.nextLine();
        pause(1);
        
        if(result.equals("y") || result.equals("yes")) 
        {
            return true;
        }
        else if(result.equals("n") || result.equals("no"))
        {
            return false;
        }
        else
        {
            System.out.println("Incorrect Input; please respond with yes or no (y / n)");
            return confirm();
        }
    }
    
    public static void pause(int time) //creates a pause using TimeUnit.sleep
    {
        try 
        {
            TimeUnit.SECONDS.sleep(time);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}