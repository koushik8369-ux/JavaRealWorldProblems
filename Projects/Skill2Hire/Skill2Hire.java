import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Entry point for the Skill2Hire Career Readiness Analyzer.
 */
public class Skill2Hire {
    private static final String JAVA_FULL_STACK_DEVELOPER = "Java Full Stack Developer";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printWelcome();
        String studentName = readNonEmptyInput(scanner, "Enter student name: ");
        String targetRole = selectTargetRole(scanner);

        Student student = new Student(studentName);
        int skillCount = readSkillCount(scanner);
        collectSkills(scanner, student, skillCount);

        CareerAnalyzer analyzer = new CareerAnalyzer(targetRole);
        printReport(student, analyzer);

        scanner.close();
    }

    private static void printWelcome() {
        System.out.println("============================================================");
        System.out.println("          SKILL2HIRE - Career Readiness Analyzer");
        System.out.println("============================================================");
        System.out.println("Discover how your current skills match your career goal.\n");
    }

    private static String selectTargetRole(Scanner scanner) {
        System.out.println("Available target role:");
        System.out.println("1. " + JAVA_FULL_STACK_DEVELOPER);

        while (true) {
            System.out.print("Select target role (enter 1): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                return JAVA_FULL_STACK_DEVELOPER;
            }
            System.out.println("Invalid selection. Please enter 1 for Java Full Stack Developer.");
        }
    }

    private static int readSkillCount(Scanner scanner) {
        while (true) {
            System.out.print("How many skills do you currently have? ");
            String input = scanner.nextLine().trim();

            try {
                int skillCount = Integer.parseInt(input);
                if (skillCount >= 0) {
                    return skillCount;
                }
                System.out.println("Please enter 0 or a positive whole number.");
            } catch (NumberFormatException exception) {
                System.out.println("Invalid number. Please enter a whole number such as 3.");
            }
        }
    }

    private static void collectSkills(Scanner scanner, Student student, int skillCount) {
        System.out.println("\nEnter your current skills:");
        for (int skillNumber = 1; skillNumber <= skillCount; skillNumber++) {
            String skill = readNonEmptyInput(scanner, "Skill " + skillNumber + ": ");
            student.addSkill(skill, readProficiency(scanner));
        }
    }

    private static Skill.ProficiencyLevel readProficiency(Scanner scanner) {
        System.out.println("  Proficiency: 1. Beginner  2. Intermediate  3. Advanced");
        while (true) {
            System.out.print("  Select proficiency (1-3): ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) return Skill.ProficiencyLevel.BEGINNER;
            if (choice.equals("2")) return Skill.ProficiencyLevel.INTERMEDIATE;
            if (choice.equals("3")) return Skill.ProficiencyLevel.ADVANCED;
            System.out.println("  Invalid selection. Please enter 1, 2, or 3.");
        }
    }

    private static String readNonEmptyInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("This field cannot be empty. Please try again.");
        }
    }

    private static void printReport(Student student, CareerAnalyzer analyzer) {
        ArrayList<String> matchedSkills = analyzer.getMatchedSkills(student);
        ArrayList<String> missingSkills = analyzer.getMissingSkills(student);
        double basicReadinessScore = analyzer.calculateReadinessScore(student);
        double weightedReadinessScore = analyzer.calculateWeightedReadinessScore(student);

        System.out.println("\n============================================================");
        System.out.println("                 CAREER READINESS REPORT");
        System.out.println("============================================================");
        System.out.println("Student Name          : " + student.getName());
        System.out.println("Target Career         : " + analyzer.getTargetRole());
        System.out.println("Total Required Skills : " + analyzer.getRequiredSkills().size());
        System.out.println("Matched Skills (" + matchedSkills.size() + ")     : " + formatSkills(matchedSkills));
        System.out.println("Missing Skills (" + missingSkills.size() + ")     : " + formatSkills(missingSkills));
        System.out.printf("Basic Readiness Score : %.2f%%%n", basicReadinessScore);
        System.out.printf("Weighted Readiness Score: %.2f%%%n", weightedReadinessScore);
        System.out.println("------------------------------------------------------------");
        printCategoryAnalysis(analyzer.getCategoryReadiness(student));
        System.out.println("------------------------------------------------------------");
        printProficiencyDetails(student, analyzer);
        System.out.println("------------------------------------------------------------");
        printRecommendations(student, analyzer, missingSkills);
        System.out.println("============================================================");
    }

    private static void printCategoryAnalysis(LinkedHashMap<String, Double> readiness) {
        System.out.println("CATEGORY-WISE ANALYSIS");
        for (Map.Entry<String, Double> category : readiness.entrySet())
            System.out.printf("%-20s: %.2f%%%n", category.getKey() + " Readiness", category.getValue());
    }

    private static void printProficiencyDetails(Student student, CareerAnalyzer analyzer) {
        System.out.println("SKILL PROFICIENCY DETAILS");
        boolean found = false;
        for (String requiredSkill : analyzer.getRequiredSkills()) {
            Skill skill = analyzer.findSkill(student, requiredSkill);
            if (skill != null) {
                System.out.println("- " + requiredSkill + ": " + skill.getProficiency().getDisplayName()
                        + " (" + skill.getProficiency().getContribution() + "% contribution)");
                found = true;
            }
        }
        if (!found) System.out.println("No required skills have been entered yet.");
    }

    private static void printRecommendations(Student student, CareerAnalyzer analyzer, ArrayList<String> missingSkills) {
        LinkedHashMap<String, Double> readiness = analyzer.getCategoryReadiness(student);
        ArrayList<String> recommendations = new ArrayList<>();
        if (readiness.get("Backend") < 70) recommendations.add("Strengthen backend skills: Java, Spring Boot, and REST API.");
        if (readiness.get("Frontend") < 70) recommendations.add("Improve frontend skills: HTML, CSS, and JavaScript.");
        if (readiness.get("Database") < 70) recommendations.add("Learn or improve SQL for database readiness.");
        if (readiness.get("Tools") < 70) recommendations.add("Practice Git and GitHub for version-control readiness.");
        for (String requiredSkill : analyzer.getRequiredSkills()) {
            Skill skill = analyzer.findSkill(student, requiredSkill);
            if (skill != null && skill.getProficiency() == Skill.ProficiencyLevel.BEGINNER)
                recommendations.add("Build " + requiredSkill + " from Beginner to Intermediate or Advanced.");
        }
        if (missingSkills.isEmpty() && recommendations.isEmpty())
            recommendations.add("Excellent profile. Maintain your skills with practical projects.");
        System.out.println("PERSONALIZED RECOMMENDATIONS");
        for (String recommendation : recommendations) System.out.println("- " + recommendation);
    }

    private static String formatSkills(ArrayList<String> skills) {
        return skills.isEmpty() ? "None" : String.join(", ", skills);
    }

}
