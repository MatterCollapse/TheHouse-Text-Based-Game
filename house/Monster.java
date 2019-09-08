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

    public static void monsterTurn() //called from Main when the monster must move
    {
        List<String> possibleMoves = new ArrayList<>();

        possibleMoves.add(position);
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
            return true;
        }
        return false;
    }
}