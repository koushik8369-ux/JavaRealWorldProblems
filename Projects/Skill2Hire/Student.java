import java.util.ArrayList;

/**
 * Stores the details and current skills of one student.
 */
public class Student {
    private final String name;
    private final ArrayList<Skill> skills;

    public Student(String name) {
        this.name = name;
        this.skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    /** Adds a skill and its proficiency level. */
    public void addSkill(String skillName, Skill.ProficiencyLevel proficiency) {
        skills.add(new Skill(skillName, proficiency));
    }
}
