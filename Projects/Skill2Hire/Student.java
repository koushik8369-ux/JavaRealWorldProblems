import java.util.ArrayList;

/**
 * Stores the details and current skills of one student.
 */
public class Student {
    private final String name;
    private final ArrayList<String> skills;

    public Student(String name) {
        this.name = name;
        this.skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    /** Adds a skill after removing leading and trailing spaces. */
    public void addSkill(String skill) {
        skills.add(skill.trim());
    }
}
