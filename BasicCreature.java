public class BasicCreature extends Creature
{
    public BasicCreature(int inId, Gender inGender)
    {
        super(inId, 8, inGender, 10, 10); //super(id, ageLimit, gender, mutationChance, mutationStrength)
    }

    protected Creature copy()
    {
        return new BasicCreature(id, new Gender(gender.toString()));
    }
}