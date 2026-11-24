
import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String courseId;
    String courseName;
    int credits;

    Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    void displayCourse() {
        System.out.println(courseId + " | " + courseName +
                " | Credits: " + credits);
    }
}

class Student {
    String name;
    String studentId;
    ArrayList<Course> registeredCourses;

    Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        registeredCourses = new ArrayList<>();
    }

    void registerCourse(Course course) {
        for (Course c : registeredCourses) {
            if (c.courseId.equals(course.courseId)) {
                System.out.println("You are already registered for this course!");
                return;
            }
        }

        registeredCourses.add(course);
        System.out.println("Course registered successfully!");
    }

    void dropCourse(String courseId) {
        for (Course c : registeredCourses) {
            if (c.courseId.equalsIgnoreCase(courseId)) {
                registeredCourses.remove(c);
                System.out.println("Course dropped successfully!");
                return;
            }
        }

        System.out.println("Course not found in your registrations.");
    }

    void viewRegistrations() {
        System.out.println("\n--- Your Registered Courses ---");

        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered yet.");
            return;
        }

        for (Course c : registeredCourses) {
            c.displayCourse();
        }
    }
}

public class CourseRegistrationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course("C101", "Java Programming", 4));
        courses.add(new Course("C102", "Database Management", 3));
        courses.add(new Course("C103", "Web Development", 4));
        courses.add(new Course("C104", "Data Structures", 3));
        courses.add(new Course("C105", "Computer Networks", 3));

        System.out.println("===== STUDENT COURSE REGISTRATION SYSTEM =====");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        Student student = new Student(name, id);

        int choice;

        do {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. View Student Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Available Courses ---");
                    for (Course c : courses) {
                        c.displayCourse();
                    }
                    break;

                case 2:
                    System.out.print("Enter Course ID to register: ");
                    String registerId = sc.nextLine();

                    boolean found = false;

                    for (Course c : courses) {
                        if (c.courseId.equalsIgnoreCase(registerId)) {
                            student.registerCourse(c);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid Course ID!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Course ID to drop: ");
                    String dropId = sc.nextLine();
                    student.dropCourse(dropId);
                    break;

                case 4:
                    student.viewRegistrations();
                    break;

                case 5:
                    System.out.println("\n--- Student Details ---");
                    System.out.println("Name: " + student.name);
                    System.out.println("Student ID: " + student.studentId);
                    System.out.println("Registered Courses: " +
                            student.registeredCourses.size());
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
