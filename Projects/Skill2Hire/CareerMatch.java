import java.util.ArrayList;

/** Stores a student's analysis result for one career. */
public class CareerMatch {
    private final Career career;
    private final ArrayList<String> matchedSkills;
    private final ArrayList<String> missingSkills;
    private final double basicMatchPercentage;
    private final double weightedMatchPercentage;
    public CareerMatch(Career career, ArrayList<String> matchedSkills, ArrayList<String> missingSkills, double basicMatchPercentage, double weightedMatchPercentage) {
        this.career = career;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
        this.basicMatchPercentage = basicMatchPercentage;
        this.weightedMatchPercentage = weightedMatchPercentage;
    }
    public Career getCareer() { return career; }
    public ArrayList<String> getMatchedSkills() { return matchedSkills; }
    public ArrayList<String> getMissingSkills() { return missingSkills; }
    public double getBasicMatchPercentage() { return basicMatchPercentage; }
    public double getWeightedMatchPercentage() { return weightedMatchPercentage; }
}
