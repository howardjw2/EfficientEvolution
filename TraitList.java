import java.util.ArrayList;

/**
 * The TraitList class holds objects of type Trait.
 * This is an abstract class so that every Creature of the same species
 *      will have the same set of traits.
 */

public abstract class TraitList
{
    protected ArrayList<Trait> traits;

    protected TraitList()
    {
        traits = new ArrayList<Trait>();
    }

    protected void mutate(double mutationStrength)
    {
        for(int i = 0; i < traits.size(); i++)
        {
            traits.get(i).addToModifier(Math.random() * mutationStrength - (mutationStrength / 2));
        }
    }

    //sets modifiers of all traits to zero
    protected void emptyTraits()
    {
        for(int i = 0; i < traits.size(); i++)
        {
            traits.get(i).setModifier(0);
        }
    }

    //combines two TraitList objects
    protected void addToTraits(TraitList inTraitList)
    {
        ArrayList<Trait> inTraits = inTraitList.getTraits();
        for(int i = 0; i < inTraits.size(); i++)
        {
            traits.get(i).addToModifier(inTraits.get(i).getModifier());
        }
    }

    /**
     * @param int num. What number to divide traits by
     */
    protected void divideTraitsBy(int num)
    {
        for(int i = 0; i < traits.size(); i++)
        {
            traits.get(i).divideModifierBy(num);
        }
    }

    protected ArrayList<Trait> getTraits()
    {
        return traits;
    }

    public String toString()
    {
        String returnString = "";
        for(int i = 0; i < traits.size(); i++)
        {
            returnString += traits.get(i) + "\n";
        }
        return returnString;
    }
}