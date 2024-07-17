public class Apartment implements Comparable<Apartment> {
    private String streetAddress;
    private int apartmentNumber;
    private double rent;
    private int numberOfBedrooms;

    public Apartment(String streetAddress, int apartmentNumber, double rent, int numberOfBedrooms) {
        this.streetAddress = streetAddress;
        this.apartmentNumber = apartmentNumber;
        this.rent = rent;
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public double getRent() {
        return rent;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }


    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }


    @Override
    public String toString() {
        return "Apartment{" +
                "streetAddress='" + streetAddress + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                ", rent=" + rent +
                ", numberOfBedrooms=" + numberOfBedrooms +
                '}';
    }


    @Override
    public int compareTo(Apartment other) {
        return Double.compare(this.rent, other.rent);}


        if (apt1.compareTo(apt2) > 0) {
            System.out.println("Apartment 1>Apartment 2.");
        } else if (apt1.compareTo(apt2) < 0) {
            System.out.println("Apartment 1<Apartment 2.");
        } else {
            System.out.println("The same");
        }
    }
}
// Apartment.java
// ნინომ იყიდა შენობები, რომლებიც შეიცავს გასაქირავებელ ბინებს. შექმენით ბინების
// Apartment კლასი, რომელიც შეიცავს ველებს:
// - Street Address,
// - Apartment Number,
// - Rent ყოველთვიური ქირავნობის ოდენობას
// - საძინებლების რაოდენობას
// ასევე მეთოდებს:
// - კონსტრუქტორს, რომელიც ანიჭებს ველებს მნიშვნელობებს,
// - toString() მეთოდი, რომელიც აბრუნებს Apartment მნიშვნელობებს
// - compareTo() მეთოდი, რომელიც ადარებს ბინის ობიექტებს rent-ის საფუძველზე.
// - ნებისმიერ სხვა მეთოდს, რომელიც, თქვენი აზრით, შეიძლება დაგჭირდეთ.
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

class Apartment implements Comparable<Apartment> {
    private String streetAddress;
    private int apartmentNumber;
    private double rent;
    private int numberOfBedrooms;

    public Apartment(String streetAddress, int apartmentNumber, double rent, int numberOfBedrooms) {
        this.streetAddress = streetAddress;
        this.apartmentNumber = apartmentNumber;
        this.rent = rent;
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public double getRent() {
        return rent;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }


    @Override
    public String toString() {
        return "Apartment{" +
                "streetAddress='" + streetAddress + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                ", rent=" + rent +
                ", numberOfBedrooms=" + numberOfBedrooms +
                '}';
    }

    @Override
    public int compareTo(Apartment other) {
        return Double.compare(this.rent, other.rent);
    }
}

public class ApartmentsLinkedList {
    public static void main(String[] args) {
        LinkedList<Apartment> apartments = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Details: ('exit'-stop input)");

        while (true) {
            System.out.print("Address: ");
            String streetAddress = scanner.nextLine();
            if (streetAddress.equalsIgnoreCase("exit")) break;

            System.out.print("Apartment number: ");
            int apartmentNumber = Integer.parseInt(scanner.nextLine());

            System.out.print("Rent: ");
            double rent = Double.parseDouble(scanner.nextLine());

            System.out.print("Number of bedrooms: ");
            int numberOfBedrooms = Integer.parseInt(scanner.nextLine());

            Apartment apartment = new Apartment(streetAddress, apartmentNumber, rent, numberOfBedrooms);
            apartments.add(apartment);
        }

        Collections.sort(apartments);

        System.out.println("\nSorted:");
        for (Apartment apartment : apartments) {
            System.out.println(apartment);
        }

        scanner.close();
    }
}
// ApartmentsLinkedList.java
// დაწერეთ აპლიკაცია, რომელიც შეიცავს LinkedList-ს, რომელშიც ინახება ბინის ობიექტები.
// შემოაყვანინეთ მომხმარებელს კონსოლიდან ველები/მნიშვნელობები ბინისთვის და
// დაამატეთ ისინი LinkedList-ში, იქამდე სანამ მომხმარებელი არ შეიყვანს რაიმე შენსავე
// შემოღებულ sentinel value-ს.
// დაალაგეთ ბინები ქირის ღირებულების ზრდის მიხედვით და შემდეგ აჩვენეთ დალაგებული
// სია.
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

class Apartment implements Comparable<Apartment> {
    private String streetAddress;
    private int apartmentNumber;
    private double rent;
    private int numberOfBedrooms;

    public Apartment(String streetAddress, int apartmentNumber, double rent, int numberOfBedrooms) {
        this.streetAddress = streetAddress;
        this.apartmentNumber = apartmentNumber;
        this.rent = rent;
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public double getRent() {
        return rent;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }


    @Override
    public String toString() {
        return "Apartment{" +
                "streetAddress='" + streetAddress + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                ", rent=" + rent +
                ", numberOfBedrooms=" + numberOfBedrooms +
                '}';
    }

    @Override
    public int compareTo(Apartment other) {
        return Double.compare(this.rent, other.rent);
    }
}

public class ApartmentsLinkedList {
    public static void main(String[] args) {
        LinkedList<Apartment> apartments = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Details: ('exit'-stop input)");

        while (true) {
            System.out.print("Address: ");
            String streetAddress = scanner.nextLine();
            if (streetAddress.equalsIgnoreCase("exit")) break;

            System.out.print("Apartment number: ");
            int apartmentNumber = Integer.parseInt(scanner.nextLine());

            System.out.print("Rent: ");
            double rent = Double.parseDouble(scanner.nextLine());

            System.out.print("Number of bedrooms: ");
            int numberOfBedrooms = Integer.parseInt(scanner.nextLine());

            Apartment apartment = new Apartment(streetAddress, apartmentNumber, rent, numberOfBedrooms);
            apartments.add(apartment);
        }

        Collections.sort(apartments);
        System.out.println("\nSorted:");
        for (Apartment apartment : apartments) {
            System.out.println(apartment);
        }


        System.out.print("\nStreet address to remove apartments: ");
        String addressToRemove = scanner.nextLine();
        Iterator<Apartment> iterator = apartments.iterator();
        while (iterator.hasNext()) {
            Apartment apartment = iterator.next();
            if (apartment.getStreetAddress().equalsIgnoreCase(addressToRemove)) {
                iterator.remove();
            }
        }

        System.out.println("\nApartments:");
        for (Apartment apartment : apartments) {
            System.out.println(apartment);
        }

        scanner.close();
    }
}
// ApartmentsLinkedList2.java
// ნინო ზოგჯერ ყიდის თავის ერთ-ერთ შენობას. დააფდეითეთ ApartmentsLinkedList
// აპლიკაცია ისე, რომ მონაცემების შეყვანის და ბინის ობიექტების სიის გამოჩენის შემდეგ,
// აპლიკაცია სთხოვს მომხმარებელს ქუჩის მისამართ, რათა ამოიღოს ყველა ბინა შესაბამისი
// ველით ამ სიიდან. კვლავ აჩვენეთ ბინების სია.