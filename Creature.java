/**
 * The Creature class is the object that represents all creatures that go through the process of evolution.
 * There will be other creature classes that extend this one. These subclasses will have different ways
 *      of passing down their genes (number of parents and gender of parents may change).
 */

public abstract class Creature
{
    protected int id; //identification numbers start at 0
    protected int age; //by default is 0, object can be constructed with certain value
    protected int ageLimit; //once age == ageLimit, the creature dies. Set by subclass
    protected Gender gender; //isMale(), isFemale(), isNeither()
    protected Gender[] genderList; //all possible genders for this type of creature. Set by subclass

    //these two variables will be the same for all creatures of the same subclass
    //these two variables will be set by the subclass
    protected double mutationChance; //chance of mutation between generations, applied to each trait
    protected double mutationStrength; //strength of mutation when it occurs

    protected double maxHeritageDifference; //the most difference in sway each parent has on the child

    protected TraitList traits;

    public Creature(int inId, int inAgeLimit, Gender inGender,
        Gender[] inGenderList, double inMChance, double inMStrength,
        double inHDifference, TraitList inTraits)
    {
        id = inId;
        age = 0;
        ageLimit = inAgeLimit;
        gender = inGender;
        genderList = inGenderList;
        mutationChance = inMChance;
        mutationStrength = inMStrength;
        maxHeritageDifference = inHDifference;
        traits = inTraits;
    }

    public Creature(int inId, int inAge, int inAgeLimit, Gender inGender,
        Gender[] genderList, double inMChance, double inMStrength,
        double inHDifference, TraitList inTraits)
    {
        id = inId;
        age = inAge;
        gender = inGender;
        gender = inGender;
        mutationChance = inMChance;
        mutationStrength = inMStrength;
        traits = inTraits;
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

    protected Gender[] getGenderList()
    {return genderList;}

    protected TraitList getTraits()
    {return traits;}

    protected double getMutationChance()
    {return mutationChance;}

    protected double getMaxHeritageDifference()
    {return maxHeritageDifference;}

    protected void setId(int inId)
    {id = inId;}

    protected void setGender(Gender inGender)
    {gender = inGender;}

    /**
     * @param Creature[] parents. The array of creatures that are reproducing,
     *      mixing their genes together evenly. Later on, genes may
     *      be mixed unevenly. All creatures must be of the same type
     */
    protected static Creature reproduce(Creature[] parents, int inId)
    {
        Creature child = parents[0].copy();

        child.setId(inId);

        Gender[] list = child.getGenderList();
        child.setGender(list[(int)(Math.random()*list.length)]); //picks a random item from possible gender list
        double weightMultiple;


        double[] parentsWeights = new double[parents.length];
        double weightSum = 0;
        for(int i = 0; i < parents.length; i++)
        {
            parentsWeights[i] = (100 / parents.length) + ((Math.random() * child.getMaxHeritageDifference() * 2)
                - (child.getMaxHeritageDifference()));
            weightSum += parentsWeights[i];
            System.out.println(parentsWeights[i]);
        }

        weightMultiple = 100 / weightSum;
        System.out.println();

        for(int i = 0; i < parents.length; i++)
        {
            parentsWeights[i] = parentsWeights[i] * weightMultiple;
            System.out.println(parentsWeights[i]);
        }

        //parentsWeights[parents.length-1] = 100 - weightSum;
        
        child.getTraits().emptyTraits();
        for(int i = 0; i < parents.length; i++)
        {
            child.getTraits().addToTraits(parents[i].getTraits());
        }
        child.getTraits().divideTraitsBy(parents.length);
        if((Math.random()*100) < child.getMutationChance())
            child.mutate();
        return child;
    }

    protected void mutate()
    {
        traits.mutate(mutationStrength);
    }

    protected abstract Creature copy();

    protected abstract Creature copy(boolean hasAge);

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