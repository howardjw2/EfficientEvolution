/**
 * This class is just the data type for gender. The gender will either be male, female, or neither.
 * Additional genders may be added.
 */

public class Gender
{
    private String genderString;

    /**
     * @param String inString, which determines the gender.
     * Capitalization does not matter, as it will turn lower case regardless.
     */
    public Gender(String inString)
    {
        //inString = String.toLower(inString);
        genderString = inString;
    }

    private boolean isMale()
    {
        return genderString == "male";
    }

    private boolean isFemale()
    {
        return genderString == "female";
    }

    private boolean isNeither()
    {
        return genderString == "neither";
    }

    public String toString()
    {
        return genderString;
    }
}