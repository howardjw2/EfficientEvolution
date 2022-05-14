import java.util.ArrayList;

/**
 * The environment will contain a list of Creatures.
 * Will also contain the history and heritage of creatures.
 * 
 * Later, this class will contain environment factors such as
 *      temperature, humidity, and food abundance.
 */

public class Environment
{
    int time;
    ArrayList<ArrayList<Creature>> history;
    ArrayList<Creature> creatures;
    int lastUsedId = -1; // determines what the next creature's id will be
                         //     ensures all ids are unique

    public Environment()
    {
        time = 0;
        history = new ArrayList<ArrayList<Creature>>();
        creatures = new ArrayList<Creature>();
    }

    public void passTime()
    {
        if(time == 0)
        {
            addToHistory();
        }
        for(int i = 0; i < creatures.size(); i++)
        {
            if(!creatures.get(i).passTime()) //if creature dies, remove it from list
            {
                creatures.remove(i);
            }
        }
        addToHistory();
    }

    /**
     * This method will add a number of creatures to the environment.
     *      The creatures will be the same type
     * This method can be run multiple times to have multiple types of creatures
     * 
     * @param
     * @param int num, which determines how many Creatures will be added initially
     */
    public void populate(Creature sample, int num)
    {
        Creature tempCreature;
        for(int i = 0; i < num; i++)
        {
            tempCreature = sample.copy();
            tempCreature.setId(++lastUsedId); //increments lastUsedId
            creatures.add(tempCreature);
        }
    }

    public void addToHistory()
    {
        ArrayList<Creature> tempList = new ArrayList<Creature>();
        for(int i = 0; i < creatures.size(); i++)
        {
            tempList.add(creatures.get(i).copy());
        }
        history.add(tempList);
    }

    public void printHistory()
    {
        for(int i = 0; i < history.size(); i++)
        {
            System.out.println("--------------------------------");
            System.out.println("TIME: " + i);
            for(int ii = 0; ii < history.get(i).size(); ii++)
            {
                System.out.println(history.get(i).get(ii));
            }
        }
    }
}