import java.util.ArrayList;

/** Creates and provides the career paths supported by Skill2Hire. */
public class CareerRepository {
    private final ArrayList<Career> careers = new ArrayList<>();
    public CareerRepository() {
        Career fullStack = new Career("Java Full Stack Developer", "Java", "HTML", "CSS", "JavaScript", "SQL", "Spring Boot", "REST API", "Git");
        fullStack.addCategory("Frontend", "HTML", "CSS", "JavaScript");
        fullStack.addCategory("Backend", "Java", "Spring Boot", "REST API");
        fullStack.addCategory("Database", "SQL");
        fullStack.addCategory("Tools", "Git");
        careers.add(fullStack);
        careers.add(new Career("Frontend Developer", "HTML", "CSS", "JavaScript", "React", "Git"));
        careers.add(new Career("Backend Developer", "Java", "SQL", "Spring Boot", "REST API", "Git"));
        careers.add(new Career("Data Analyst", "Python", "SQL", "Excel", "Statistics", "Power BI"));
    }
    public ArrayList<Career> getCareers() { return careers; }
    public Career getJavaFullStackDeveloper() { return careers.get(0); }
}
