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
    ArrayList<ArrayList<Creature>> history;
    ArrayList<Creature> creatures;

    public Environment()
    {
        history = new ArrayList<ArrayList<Creature>>();
        creatures = new ArrayList<Creature>();
    }

    public void passTime()
    {
        
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
        for(int i = 0; i < num; i++)
        {
            creatures.add(sample.copy());
        }
    }
}