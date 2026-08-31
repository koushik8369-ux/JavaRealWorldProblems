/** Represents one skill entered by a student and its proficiency level. */
public class Skill {
    private final String name;
    private final ProficiencyLevel proficiency;

    public Skill(String name, ProficiencyLevel proficiency) {
        this.name = name.trim();
        this.proficiency = proficiency;
    }

    public String getName() { return name; }
    public ProficiencyLevel getProficiency() { return proficiency; }

    /** Supported proficiency levels and their weighted-score contributions. */
    public enum ProficiencyLevel {
        BEGINNER("Beginner", 40), INTERMEDIATE("Intermediate", 70), ADVANCED("Advanced", 100);
        private final String displayName;
        private final int contribution;
        ProficiencyLevel(String displayName, int contribution) {
            this.displayName = displayName;
            this.contribution = contribution;
        }
        public String getDisplayName() { return displayName; }
        public int getContribution() { return contribution; }
    }
}
