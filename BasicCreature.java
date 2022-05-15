public class BasicCreature extends Creature
{
    public BasicCreature(int inId, Gender inGender)
    {
        super(inId, 8, inGender, new Gender[]{new Gender("male"), new Gender("female")}, 10, 10, new BasicTraitList());
    }

    public BasicCreature(int inId, int inAge, Gender inGender)
    {
        super(inId, inAge, 8, inGender, new Gender[]{new Gender("male"), new Gender("female")}, 10, 10, new BasicTraitList());
    }

    protected Creature copy()
    {
        return new BasicCreature(id, new Gender(gender.toString()));
    }

    protected Creature copy(boolean hasAge)
    {
        if(hasAge)
            return new BasicCreature(id, age, new Gender(gender.toString()));
        return new BasicCreature(id, new Gender(gender.toString()));
    }
}