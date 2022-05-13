/**
 * The Creature class is the object that represents all creatures that go through the process of evolution.
 * There will be other creature classes that extend this one. These subclasses will have different ways
 *      of passing down their genes (number of parents and gender of parents may change).
 */

public abstract class Creature
{
    protected Gender gender; //isMale(), isFemale(), isNeither()

    //these two variables will be the same for all creatures of the same subclass.
    //these two variables will be set by the subclass.

    protected double mutationChance; //chance of mutation between generations
    protected double mutationStrength; //strength of mutation when it occurs.

    public Creature(Gender inGender, double inMChance, double inMStrength)
    {
        gender = inGender;
        mutationChance = inMChance;
        mutationStrength = inMStrength;
    }

    protected Gender getGender()
    {return gender;}

    protected abstract Creature copy();
}