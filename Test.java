public class Test
{
    public static void main(String[] args)
    {
        Creature trialCreature = new BasicCreature(0, new Gender("male"));
        Environment world = new Environment();
        world.populate(trialCreature, 3);
        world.passTime();
        //world.printHistory();

        Creature whoCares = new BasicCreature(72, 6, new Gender("female"));
        Creature buzzOff = new BasicCreature(85, 5, new Gender("male"));
        System.out.println(Creature.reproduce(new Creature[]{whoCares, buzzOff}, 22));
    }
}