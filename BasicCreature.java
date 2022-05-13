public class BasicCreature extends Creature
{
    public BasicCreature(Gender inGender)
    {
        super(inGender, 10, 10); //super(gender, mutationChance, mutationStrength)
    }

    protected Creature copy()
    {
        return new BasicCreature(new Gender(gender.toString()));
    }
}