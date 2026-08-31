import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Compares a student's skills with the skills required for a career role.
 */
public class CareerAnalyzer {
    private final String targetRole;
    private final ArrayList<String> requiredSkills;
    private final LinkedHashMap<String, ArrayList<String>> skillCategories;

    public CareerAnalyzer(String targetRole) {
        this.targetRole = targetRole;
        this.requiredSkills = new ArrayList<>();
        this.skillCategories = new LinkedHashMap<>();
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
        addCategory("Frontend", "HTML", "CSS", "JavaScript");
        addCategory("Backend", "Java", "Spring Boot", "REST API");
        addCategory("Database", "SQL");
        addCategory("Tools", "Git");
    }

    private void addCategory(String name, String... skills) {
        ArrayList<String> categorySkills = new ArrayList<>();
        for (String skill : skills) categorySkills.add(skill);
        skillCategories.put(name, categorySkills);
    }

    public String getTargetRole() {
        return targetRole;
    }

    public ArrayList<String> getRequiredSkills() {
        return requiredSkills;
    }

    public LinkedHashMap<String, ArrayList<String>> getSkillCategories() { return skillCategories; }

    /** Returns required skills that the student entered, ignoring letter case. */
    public ArrayList<String> getMatchedSkills(Student student) {
        ArrayList<String> matchedSkills = new ArrayList<>();

        for (String requiredSkill : requiredSkills) {
            if (findSkill(student, requiredSkill) != null) {
                matchedSkills.add(requiredSkill);
            }
        }
        return matchedSkills;
    }

    /** Returns required skills that are not currently listed by the student. */
    public ArrayList<String> getMissingSkills(Student student) {
        ArrayList<String> missingSkills = new ArrayList<>();

        for (String requiredSkill : requiredSkills) {
            if (findSkill(student, requiredSkill) == null) {
                missingSkills.add(requiredSkill);
            }
        }
        return missingSkills;
    }

    public double calculateReadinessScore(Student student) {
        return (getMatchedSkills(student).size() * 100.0) / requiredSkills.size();
    }

    /** Calculates readiness using 40%, 70%, or 100% per matched skill. */
    public double calculateWeightedReadinessScore(Student student) {
        double totalContribution = 0;
        for (String requiredSkill : requiredSkills) {
            Skill skill = findSkill(student, requiredSkill);
            if (skill != null) totalContribution += skill.getProficiency().getContribution();
        }
        return totalContribution / requiredSkills.size();
    }

    /** Returns basic readiness percentages for every category in display order. */
    public LinkedHashMap<String, Double> getCategoryReadiness(Student student) {
        LinkedHashMap<String, Double> result = new LinkedHashMap<>();
        for (Map.Entry<String, ArrayList<String>> category : skillCategories.entrySet()) {
            int matchedCount = 0;
            for (String requiredSkill : category.getValue()) {
                if (findSkill(student, requiredSkill) != null) matchedCount++;
            }
            result.put(category.getKey(), matchedCount * 100.0 / category.getValue().size());
        }
        return result;
    }

    /** Returns a matching student skill, or null when it is absent. */
    public Skill findSkill(Student student, String requiredSkill) {
        for (Skill studentSkill : student.getSkills()) {
            if (studentSkill.getName().equalsIgnoreCase(requiredSkill)) return studentSkill;
        }
        return null;
    }
}
