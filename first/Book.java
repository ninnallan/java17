abstract class Book {
    private String title;
    private double price;
        public Book(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }

    public abstract void setPrice(double price);
}
// Book.java (5) - შექმენით აბსტრაქტული კლასი სახელად Book შემდეგი თვისებებით:
// ● String field წიგნის სათაურისთვის და double field წიგნის ფასისთვის.
// ● კონსტრუქტორი, რომელიც მოითხოვს წიგნის სათაურს
// ● ორი getter მეთოდი — ერთი, რომელიც აბრუნებს სათაურს და მეორე, რომელიც
// აბრუნებს ფასს.
// ● აბსტრაქტული მეთოდი სახელად setPrice().
public class FictionBook extends Book {
    private String author;
    public FictionBook(String title, String author) {
        super(title);
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

    @Override
    public void setPrice(double price) {
        this.price = 24.99;
    }
}
//----------------------------------------
public class NonFictionBook extends Book {
    private String subject;

    public NonFictionBook(String title, String subject) {
        super(title);
        this.subject = subject;
    }
    public String getSubject() {
        return subject;
    }
    @Override
    public void setPrice(double price) {
        this.price = 37.99;
    }
}

// Fiction.java და NonFiction.java (5) - შექმენით ორი Book-ის შვილობილი კლასი: Fiction
// და NonFiction.
// ● თითოეული უნდა შეიცავდეს setPrice() მეთოდს, რომელიც დასეტავს ყველა
// მხატვრული წიგნისთვის ფასს $24,99 და ყველა არამხატვრული წიგნისთვის
// $37,99-ს.
// ● დაწერეთ კონსტრუქტორი თითოეული ქვეკლასისთვის, რომლებიც გამოიძახებენ
//setPrice() კონსტრუქტორშივე.
import java.util.Scanner;

public class UseBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Details for F:");
        System.out.print("Title: ");
        String fictionTitle = scanner.nextLine();


        FictionBook fictionBook = new FictionBook(fictionTitle, fictionAuthor);
        fictionBook.setPrice();


        System.out.println("\nDetails for N:");
        System.out.print("Title: ");
        String nonFictionTitle = scanner.nextLine();


        NonFictionBook nonFictionBook = new NonFictionBook(nonFictionTitle, nonFictionSubject);
        nonFictionBook.setPrice();


        System.out.println("\nDetails:");
        System.out.println("Fiction Book:");
        System.out.println("Title: " + nonFictionBook.getTitle());
        System.out.println("Price: $" + fictionBook.getPrice());
        System.out.println("\nNon-Fiction Book:");
        System.out.println("Title: " + fonFictionBook.getTitle());
        System.out.println("Price: $" + fonFictionBook.getPrice());

        scanner.close();
    }
}
// UseBook.java (5) - დაწერეთ აპლიკაცია, რომელიც აჩვენებს, რომ შეგიძლიათ შექმნათ
// როგორც მხატვრული, ასევე არამხატვრული წიგნი.
// ● იუსერს შეაყვანინეთ ორივე წიგნისთვის value-ები.
// ● დაბეჭდეთ წიგნის value-ები.
// import java.util.Scanner;

public class BookArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] books = new Book[10];

        for (int i = 0; i < books.length; i++) {
            System.out.println("Details" + (i + 1) + ":");
            System.out.print("Title: ");
            String title = scanner.nextLine();

            String bookType;
            do {
                System.out.print("Is it Fiction or Non-fiction? (F/N): ");
                bookType = scanner.nextLine().toUpperCase();
            } while (!bookType.equals("F") && !bookType.equals("N"));


            if (bookType.equals("F")) {
                System.out.print("Author: ");
                String author = scanner.nextLine();
                books[i] = new FictionBook(title, author);
            } else {
                System.out.print("Subject: ");
                String subject = scanner.nextLine();
                books[i] = new NonFictionBook(title, subject);
            }
        }

        System.out.println("\nDetails:");
        for (int i = 0; i < books.length; i++) {
            System.out.println("\nBook " + (i + 1) + ":");
            System.out.println("Title: " + books[i].getTitle());
            System.out.println("Price: $" + books[i].getPrice());
        }

        scanner.close();
    }
}
// BookArray.java (5) - დაწერეთ აპლიკაცია სახელად BookArray, რომელშიც შექმნით მასივს,
// რომელიც შეიცავს 10 წიგნს, ზოგს მხატვრული და ზოგს არამხატვრულს.
// ● for loop-ის გამოყენებით, შემოაყვანინეთ მომხმარებელს სათაური და არის თუ არა
// წიგნი მხატვრული თუ არამხატვრული (F ან N).
// ● შექმენით წიგნის შესაბამისი ტიპი და შეინახეთ იგი მასივში.
// ● თუ მომხმარებელი არ შემოიყვანს F ან N-ს, ხელახლა სთხოვეთ მომხმარებელს
// ახალი სწორი ინფუთის შემოყვანა.
// ● სხვა ციკლში აჩვენეთ დეტალები 10-ივე წიგნის შესახებ.