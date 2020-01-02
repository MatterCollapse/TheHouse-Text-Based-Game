package house;

import java.util.List;
import java.util.Random;

import house.utils.GameUtils;

import java.util.ArrayList;

//find a way to track changes in the location. if the player moves, the monster moves. 
//if player location = monster location, print a line and end the game. 
//the monster appears once the player finds some object in the house
//the monster should be able to move to a random attached location, but not jump around. He will not go into the laundry room, but once inside the player will be told if he hears the monster pass.

public class Monster
{
    public static String position = "ether";
    public static int attempt = 3;

    public static void monsterTurn() //called from Main when the monster must move
    {
        List<String> possibleMoves = new ArrayList<>();

        if(attempt <= 1)
        {
            possibleMoves.add(position);
        }
        switch(position)
        {
            case "backExit":
            possibleMoves.add("backYard");
            possibleMoves.add("kitchen");
            break;
            case "kitchen":
            possibleMoves.add("restroom");
            possibleMoves.add("livingRoom");
            possibleMoves.add("backExit");
            break;
            case "livingRoom":
            possibleMoves.add("kitchen");
            //possibleMoves.add("frontDoor");
            break;
            case "restroom":
            possibleMoves.add("kitchen");
            break;
            case "backYard":
            possibleMoves.add("sidePath");
            possibleMoves.add("backExit");
            break;
            case "frontDoor":
            possibleMoves.add("frontYard");
            //possibleMoves.add("livingRoom");
            break;
            case "frontYard":
            possibleMoves.add("frontDoor");
            possibleMoves.add("sidePath");
            break;
            case "sidePath":
            possibleMoves.add("frontYard");
            possibleMoves.add("backYard");
            break;
        }
        
        //System.out.println("--MONSTER OLD LOCATION: " + position +  "--"); //Temporary progress check

        position = getRandomElement(possibleMoves);

        //System.out.println("--MONSTER NEW LOCATION: " + position + "--"); //Temporary progress check
    }

    public static String getRandomElement(List<String> list) 
    { 
        Random rand = new Random(); 
        return list.get(rand.nextInt(list.size())); 
    } 

    public static boolean checkCollision() 
    {
        if(position == GameUtils.location) 
        {
            if(attempt == 1)
            {
                return true;
            }
            else if(attempt == 2)
            {
                System.out.println("He reaches out at you faster than before, scratching your shoulder and pulling blood. You reel back and run. Find another room, he seems to have be getting more aggresive. ");
            }
            else
            {
                System.out.println("You jump back before it can grab you. You don't know what it is but you know you don't want it touching you. It's intent on getting you, run to a different room, it might fall behind. ");
            }
        }
        attempt--;
        return false;
    }
}