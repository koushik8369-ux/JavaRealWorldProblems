import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/** Compares a student's skills with one or more technology career paths. */
public class CareerAnalyzer {
    private final Career career;

    /** Retained for V2 compatibility; uses Java Full Stack Developer. */
    public CareerAnalyzer(String targetRole) { this(new CareerRepository().getJavaFullStackDeveloper()); }
    public CareerAnalyzer(Career career) { this.career = career; }

    public String getTargetRole() { return career.getName(); }
    public ArrayList<String> getRequiredSkills() { return career.getRequiredSkills(); }
    public LinkedHashMap<String, ArrayList<String>> getSkillCategories() { return career.getSkillCategories(); }

    public ArrayList<String> getMatchedSkills(Student student) {
        ArrayList<String> matched = new ArrayList<>();
        for (String required : career.getRequiredSkills()) if (findSkill(student, required) != null) matched.add(required);
        return matched;
    }

    public ArrayList<String> getMissingSkills(Student student) {
        ArrayList<String> missing = new ArrayList<>();
        for (String required : career.getRequiredSkills()) if (findSkill(student, required) == null) missing.add(required);
        return missing;
    }

    public double calculateReadinessScore(Student student) {
        return getMatchedSkills(student).size() * 100.0 / career.getRequiredSkills().size();
    }

    public double calculateWeightedReadinessScore(Student student) {
        double contribution = 0;
        for (String required : career.getRequiredSkills()) {
            Skill skill = findSkill(student, required);
            if (skill != null) contribution += skill.getProficiency().getContribution();
        }
        return contribution / career.getRequiredSkills().size();
    }

    /** Retained V2 category analysis for careers that define categories. */
    public LinkedHashMap<String, Double> getCategoryReadiness(Student student) {
        LinkedHashMap<String, Double> readiness = new LinkedHashMap<>();
        for (Map.Entry<String, ArrayList<String>> category : career.getSkillCategories().entrySet()) {
            int matched = 0;
            for (String required : category.getValue()) if (findSkill(student, required) != null) matched++;
            readiness.put(category.getKey(), matched * 100.0 / category.getValue().size());
        }
        return readiness;
    }

    public CareerMatch analyzeCareer(Student student) {
        return new CareerMatch(career, getMatchedSkills(student), getMissingSkills(student), calculateReadinessScore(student), calculateWeightedReadinessScore(student));
    }

    public static ArrayList<CareerMatch> rankCareers(Student student, ArrayList<Career> careers) {
        ArrayList<CareerMatch> matches = new ArrayList<>();
        for (Career career : careers) matches.add(new CareerAnalyzer(career).analyzeCareer(student));
        matches.sort(Comparator.comparingDouble(CareerMatch::getWeightedMatchPercentage).reversed());
        return matches;
    }

    /** Returns a student skill matching the required name, ignoring letter case. */
    public Skill findSkill(Student student, String requiredSkill) {
        for (Skill skill : student.getSkills()) if (skill.getName().equalsIgnoreCase(requiredSkill)) return skill;
        return null;
    }
}
