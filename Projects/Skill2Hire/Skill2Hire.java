import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/** Entry point for the Skill2Hire Multi-Career Intelligence system. */
public class Skill2Hire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CareerRepository repository = new CareerRepository();
        printWelcome();
        Student student = new Student(readNonEmptyInput(scanner, "Enter student name: "));
        collectSkills(scanner, student, readSkillCount(scanner));
        ArrayList<CareerMatch> rankings = CareerAnalyzer.rankCareers(student, repository.getCareers());
        printMultiCareerReport(student, rankings);
        printJavaFullStackDetail(student, new CareerAnalyzer(repository.getJavaFullStackDeveloper()));
        scanner.close();
    }

    private static void printWelcome() {
        System.out.println("================================================================");
        System.out.println("        SKILL2HIRE - Multi-Career Intelligence System");
        System.out.println("================================================================");
        System.out.println("Analyze your skills across multiple technology career paths.\n");
    }

    private static int readSkillCount(Scanner scanner) {
        while (true) {
            System.out.print("How many skills do you currently have? ");
            try {
                int count = Integer.parseInt(scanner.nextLine().trim());
                if (count >= 0) return count;
                System.out.println("Please enter 0 or a positive whole number.");
            } catch (NumberFormatException exception) {
                System.out.println("Invalid number. Please enter a whole number such as 3.");
            }
        }
    }

    private static void collectSkills(Scanner scanner, Student student, int count) {
        System.out.println("\nEnter your current skills:");
        for (int number = 1; number <= count; number++) {
            String skill = readNonEmptyInput(scanner, "Skill " + number + ": ");
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
            if (!input.isEmpty()) return input;
            System.out.println("This field cannot be empty. Please try again.");
        }
    }

    private static void printMultiCareerReport(Student student, ArrayList<CareerMatch> rankings) {
        System.out.println("\n================================================================");
        System.out.println("                    CAREER INTELLIGENCE REPORT");
        System.out.println("================================================================");
        System.out.println("Student Name: " + student.getName());
        System.out.println("----------------------------------------------------------------");
        System.out.println("CAREER MATCH RANKING");
        for (int index = 0; index < rankings.size(); index++) {
            CareerMatch match = rankings.get(index);
            System.out.printf("%d. %-28s %6.2f%%%n", index + 1, match.getCareer().getName(), match.getWeightedMatchPercentage());
        }
        printBestCareerRecommendation(rankings.get(0));
        System.out.println("----------------------------------------------------------------");
        System.out.println("CAREER COMPARISON REPORT");
        for (CareerMatch match : rankings) printCareerComparison(match);
    }

    private static void printBestCareerRecommendation(CareerMatch bestMatch) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("BEST CAREER MATCH");
        System.out.println("Recommended Career: " + bestMatch.getCareer().getName());
        System.out.printf("Match Score        : %.2f%%%n", bestMatch.getWeightedMatchPercentage());
        System.out.println("Reason             : " + getGuidance(bestMatch));
        System.out.println("Top Missing Skills : " + topMissingSkills(bestMatch.getMissingSkills()));
    }

    private static String getGuidance(CareerMatch match) {
        double score = match.getWeightedMatchPercentage();
        if (score >= 80) return "You are highly aligned with this career path.";
        if (score >= 50) return "You have a good foundation; improve the missing skills to grow further.";
        return "Build more core skills to strengthen your alignment with this career.";
    }

    private static String topMissingSkills(ArrayList<String> missingSkills) {
        if (missingSkills.isEmpty()) return "None — you cover all required skills.";
        return String.join(", ", missingSkills.subList(0, Math.min(3, missingSkills.size())));
    }

    private static void printCareerComparison(CareerMatch match) {
        System.out.println("\n" + match.getCareer().getName());
        System.out.println("  Total Required Skills : " + match.getCareer().getRequiredSkills().size());
        System.out.println("  Matched Skills (" + match.getMatchedSkills().size() + ") : " + formatSkills(match.getMatchedSkills()));
        System.out.println("  Missing Skills (" + match.getMissingSkills().size() + ") : " + formatSkills(match.getMissingSkills()));
        System.out.printf("  Basic Match Score    : %.2f%%%n", match.getBasicMatchPercentage());
        System.out.printf("  Weighted Match Score : %.2f%%%n", match.getWeightedMatchPercentage());
    }

    /** Keeps the detailed V2 Java Full Stack category analysis available in V3. */
    private static void printJavaFullStackDetail(Student student, CareerAnalyzer analyzer) {
        System.out.println("\n================================================================");
        System.out.println("          JAVA FULL STACK DEVELOPER - DETAILED ANALYSIS");
        System.out.println("================================================================");
        System.out.println("CATEGORY-WISE ANALYSIS");
        for (Map.Entry<String, Double> category : analyzer.getCategoryReadiness(student).entrySet())
            System.out.printf("%-20s: %.2f%%%n", category.getKey() + " Readiness", category.getValue());
        System.out.println("----------------------------------------------------------------");
        System.out.println("SKILL PROFICIENCY DETAILS");
        boolean found = false;
        for (String requiredSkill : analyzer.getRequiredSkills()) {
            Skill skill = analyzer.findSkill(student, requiredSkill);
            if (skill != null) {
                System.out.println("- " + requiredSkill + ": " + skill.getProficiency().getDisplayName() + " (" + skill.getProficiency().getContribution() + "% contribution)");
                found = true;
            }
        }
        if (!found) System.out.println("No Java Full Stack required skills have been entered yet.");
        System.out.println("================================================================");
    }

    private static String formatSkills(ArrayList<String> skills) { return skills.isEmpty() ? "None" : String.join(", ", skills); }
}
