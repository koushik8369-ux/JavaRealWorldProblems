public class Student {

    private int id;
    private String name;
    private String department;
    private int semester;

    public Student(int id, String name, String department, int semester) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSemester() {
        return semester;
    }

    public void displayStudent() {

        System.out.println("------------------------------------------");
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Semester: " + semester);
    }
}