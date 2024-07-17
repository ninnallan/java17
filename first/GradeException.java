public class GradeException extends Exception {

    public static final char[] VALID_GRADES = {'A', 'B', 'C', 'D', 'F', 'I'};


    public GradeException(String message) {
        super(message);
    }


    public static boolean isValidGrade(char grade) {
        for (char validGrade : VALID_GRADES) {
            if (grade == validGrade) {
                return true;
            }
        }
        return false;
    }
}
// GradeException.java - შექმენით Exception-ის კლასი სახელად GradeException, რომელიც
// შეიცავს სტატიკურ public მასივს ნიშნის გამომხატველი ასოებით (A, B, C, D, F, და I), რომელიც
// შეგიძლიათ გამოიყენოთ იმის დასადგენად, არის თუ არა შეფასება სწორი.
// import java.util.Scanner;

public class TestGrade {
    public static void main(String[] args) {

        int[] studentIDs = {1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008};


        char[] grades = new char[studentIDs.length];

        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < studentIDs.length; i++) {
            System.out.print("Grade for student " + studentIDs[i] + ": ");
            char grade = scanner.nextLine().charAt(0);

            try {
                if (!GradeException.isValidGrade(grade)) {
                    throw new GradeException("Invalid");
                }
                grades[i] = grade;
            } catch (GradeException e) {
                System.out.println(e.getMessage());
                grades[i] = 'I';
            }
        }


        System.out.println("IDs and Grades:");
        for (int i = 0; i < studentIDs.length; i++) {
            System.out.println("Student ID: " + studentIDs[i] + ", Grade: " + grades[i]);
        }

        scanner.close();
    }
}
// TestGrade.java - დაწერეთ აპლიკაცია, რომელსაც აქვს მინიმუმ რვა სტუდენტის ID ნომრები
// შენახული მასივში და სთხოვეთ მომხმარებელს შეიყვანოს სტუდენტისთვის ქულა. ისროლეთ
// GradeException-ი, თუ მომხმარებელი არ შეიყვანს სწორ შეფასებას, როგორც ეს განსაზღვრულია
// GradeException კლასში. დაიჭირეთ GradeException და შემდეგ აჩვენეთ შესაბამისი შეტყობინება.
// გარდა ამისა, შეინახეთ I (არასრულის აღსანიშნად) ნებისმიერი სტუდენტისთვის, რომლისთვისაც
// ამოვარდა Exception-ი. აპლიკაციის დასასრულს აჩვენეთ ყველა სტუდენტის ID და შეფასება.