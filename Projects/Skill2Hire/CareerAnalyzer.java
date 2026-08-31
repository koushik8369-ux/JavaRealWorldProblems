import java.util.ArrayList;

/**
 * Compares a student's skills with the skills required for a career role.
 */
public class CareerAnalyzer {
    private final String targetRole;
    private final ArrayList<String> requiredSkills;

    public CareerAnalyzer(String targetRole) {
        this.targetRole = targetRole;
        this.requiredSkills = new ArrayList<>();
        addJavaFullStackDeveloperSkills();
    }

    private void addJavaFullStackDeveloperSkills() {
        requiredSkills.add("Java");
        requiredSkills.add("HTML");
        requiredSkills.add("CSS");
        requiredSkills.add("JavaScript");
        requiredSkills.add("SQL");
        requiredSkills.add("Spring Boot");
        requiredSkills.add("REST API");
        requiredSkills.add("Git");
    }

    public String getTargetRole() {
        return targetRole;
    }

    public ArrayList<String> getRequiredSkills() {
        return requiredSkills;
    }

    /** Returns required skills that the student entered, ignoring letter case. */
    public ArrayList<String> getMatchedSkills(Student student) {
        ArrayList<String> matchedSkills = new ArrayList<>();

        for (String requiredSkill : requiredSkills) {
            if (hasSkill(student.getSkills(), requiredSkill)) {
                matchedSkills.add(requiredSkill);
            }
        }
        return matchedSkills;
    }

    /** Returns required skills that are not currently listed by the student. */
    public ArrayList<String> getMissingSkills(Student student) {
        ArrayList<String> missingSkills = new ArrayList<>();

        for (String requiredSkill : requiredSkills) {
            if (!hasSkill(student.getSkills(), requiredSkill)) {
                missingSkills.add(requiredSkill);
            }
        }
        return missingSkills;
    }

    public double calculateReadinessScore(Student student) {
        return (getMatchedSkills(student).size() * 100.0) / requiredSkills.size();
    }

    private boolean hasSkill(ArrayList<String> studentSkills, String requiredSkill) {
        for (String studentSkill : studentSkills) {
            if (studentSkill.equalsIgnoreCase(requiredSkill)) {
                return true;
            }
        }
        return false;
    }
}
