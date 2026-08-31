import java.util.ArrayList;
import java.util.LinkedHashMap;

/** Defines a career path, its required skills, and optional skill categories. */
public class Career {
    private final String name;
    private final ArrayList<String> requiredSkills;
    private final LinkedHashMap<String, ArrayList<String>> skillCategories;

    public Career(String name, String... skills) {
        this.name = name;
        this.requiredSkills = new ArrayList<>();
        this.skillCategories = new LinkedHashMap<>();
        for (String skill : skills) requiredSkills.add(skill);
    }
    public String getName() { return name; }
    public ArrayList<String> getRequiredSkills() { return requiredSkills; }
    public LinkedHashMap<String, ArrayList<String>> getSkillCategories() { return skillCategories; }
    public void addCategory(String categoryName, String... skills) {
        ArrayList<String> categorySkills = new ArrayList<>();
        for (String skill : skills) categorySkills.add(skill);
        skillCategories.put(categoryName, categorySkills);
    }
}
