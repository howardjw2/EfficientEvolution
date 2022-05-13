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

    protected ArrayList<Trait> getTraits()
    {return traits;}
}