import java.util.ArrayList;
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
            student.addSkill(skill);
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
        double readinessScore = analyzer.calculateReadinessScore(student);

        System.out.println("\n============================================================");
        System.out.println("                 CAREER READINESS REPORT");
        System.out.println("============================================================");
        System.out.println("Student Name          : " + student.getName());
        System.out.println("Target Role           : " + analyzer.getTargetRole());
        System.out.println("Total Required Skills : " + analyzer.getRequiredSkills().size());
        System.out.println("Matched Skills (" + matchedSkills.size() + ")     : " + formatSkills(matchedSkills));
        System.out.println("Missing Skills (" + missingSkills.size() + ")     : " + formatSkills(missingSkills));
        System.out.printf("Career Readiness Score: %.2f%%%n", readinessScore);
        System.out.println("------------------------------------------------------------");
        System.out.println(getRecommendation(readinessScore));
        System.out.println("============================================================");
    }

    private static String formatSkills(ArrayList<String> skills) {
        return skills.isEmpty() ? "None" : String.join(", ", skills);
    }

    private static String getRecommendation(double readinessScore) {
        if (readinessScore == 100.0) {
            return "Excellent! You currently meet all required skills for this role.";
        }
        return "Focus on the missing skills to strengthen your readiness for this role.";
    }
}
