/**
 * A simple data type that contains a string (the name of the trait) and
 *      a double (how present the trait is in the Creature)
 * Each Trait will be contained in a TraitList, which will be within a Creature
 */

public class Trait
{
    private String type;
    private double modifier;

    public Trait(String inType, double inModifier)
    {
        type = inType;
        modifier = inModifier;
    }

    private String getType()
    {return type;}

    private double getModifier()
    {return modifier;}
}