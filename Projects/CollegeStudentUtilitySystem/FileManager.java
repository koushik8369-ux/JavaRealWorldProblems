import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "students.txt";

    public static void saveStudents(ArrayList<Student> students) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(FILE_NAME))) {

            for (Student student : students) {

                writer.write(
                        student.getId()
                                + "|"
                                + student.getName()
                                + "|"
                                + student.getDepartment()
                                + "|"
                                + student.getSemester());

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error while saving student records: "
                            + e.getMessage());
        }
    }

    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students =
                new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {

            return students;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 4) {

                    int id =
                            Integer.parseInt(data[0]);

                    String name =
                            data[1];

                    String department =
                            data[2];

                    int semester =
                            Integer.parseInt(data[3]);

                    Student student =
                            new Student(
                                    id,
                                    name,
                                    department,
                                    semester);

                    students.add(student);
                }
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error while loading student records: "
                            + e.getMessage());
        }

        return students;
    }
}