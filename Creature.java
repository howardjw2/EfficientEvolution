/**
 * The Creature class is the object that represents all creatures that go through the process of evolution.
 * There will be other creature classes that extend this one. These subclasses will have different ways
 *      of passing down their genes (number of parents and gender of parents may change).
 */

public abstract class Creature
{
    protected int id; //identification numbers start at 0
    protected int age; //by default is 0, object can be constructed with certain value
    protected int ageLimit; //once age == ageLimit, the creature dies. Set by subclass.
    protected Gender gender; //isMale(), isFemale(), isNeither()

    //these two variables will be the same for all creatures of the same subclass.
    //these two variables will be set by the subclass.
    protected double mutationChance; //chance of mutation between generations
    protected double mutationStrength; //strength of mutation when it occurs.

    public Creature(int inId, int inAgeLimit, Gender inGender, double inMChance, double inMStrength)
    {
        id = inId;
        age = 0;
        ageLimit = inAgeLimit;
        gender = inGender;
        mutationChance = inMChance;
        mutationStrength = inMStrength;
    }

    public Creature(int inId, int inAge, int inAgeLimit, Gender inGender, double inMChance, double inMStrength)
    {
        id = inId;
        age = inAge;
        gender = inGender;
        mutationChance = inMChance;
        mutationStrength = inMStrength;
    }

    //used by the passTime method in Environment class
    //returns true if creature survives, returns false if creature dies
    public boolean passTime()
    {
        age++;
        if(age > ageLimit)
        {
            return false;
        }
        return true;
    }

    protected Gender getGender()
    {return gender;}

    protected void setId(int inId)
    {id = inId;}

    protected abstract Creature copy();

    public String toString()
    {
        String returnString = "";
        returnString += "    ID: " + id + "\n";
        returnString += "        Age: " + age + " / " + ageLimit + "\n";
        returnString += "        Gender: " + gender.toString() + "\n";
        returnString += "        Mutation Chance:   " + mutationChance + "\n";
        returnString += "        Mutation Strength: " + mutationStrength + "\n";
        return returnString;
    }
}