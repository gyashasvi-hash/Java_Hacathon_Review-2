import java.util.Scanner;

class Student {
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Parameterized constructor
    Student(String studentName, int rollNumber, double marks,
            String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Calculate course fee
    double calculateFee() {
        return courseCredits * 1500;
    }

    // Check eligibility
    boolean checkEligibility() {
        return marks >= 50;
    }

    // Calculate scholarship percentage
    double calculateScholarship() {
        if (marks >= 85)
            return 20;
        else if (marks >= 70)
            return 10;
        else
            return 0;
    }

    // Calculate final fee
    double calculateFinalFee() {
        double fee = calculateFee();
        double scholarship = fee * calculateScholarship() / 100;
        return fee - scholarship;
    }

    // Display details
    void displayDetails() {
        double fee = calculateFee();
        double scholarship = fee * calculateScholarship() / 100;
        double finalFee = calculateFinalFee();

        System.out.println("\n--- Student Course Details ---");
        System.out.println("Student Name : " + studentName);
        System.out.println("Roll Number  : " + rollNumber);
        System.out.println("Marks        : " + marks);
        System.out.println("Course Name  : " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligible     : Yes");
        System.out.println("Total Fee    : Rs." + fee);
        System.out.println("Scholarship  : Rs." + scholarship);
        System.out.println("Final Fee    : Rs." + finalFee);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter course name: ");
        String course = sc.nextLine();

        System.out.print("Enter course credits: ");
        int credits = sc.nextInt();

        // Create object using parameterized constructor
        Student s = new Student(name, roll, marks, course, credits);

        // Check eligibility first
        if (s.checkEligibility()) {
            s.displayDetails();
        } else {
            System.out.println("\nStudent is NOT eligible for course registration.");
        }

        sc.close();
    }
}
  