import java.util.Scanner;

class StudentGrades {
    public static String calculateGrade(double percentage) {
        if (percentage >= 90) return "A";
        else if (percentage >= 75) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 40) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3]; 
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks (Physics, Chemistry, Maths) for student " + (i+1) + ":");
            marks[i][0] = sc.nextInt();
            marks[i][1] = sc.nextInt();
            marks[i][2] = sc.nextInt();

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = (total / 3.0);
            grade[i] = calculateGrade(percentage[i]);
        }

        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\t%age\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + "\t" + marks[i][0] + "\t" + marks[i][1] + "\t\t" + marks[i][2] + "\t" + String.format("%.2f", percentage[i]) + "\t" + grade[i]);
        }
        sc.close();
    }
}