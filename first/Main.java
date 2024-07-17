import java.util.Arrays;

class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product id=" + id +", name='" + name + '\'' +", category='" + category + '\'' +", price=" + price +", quantity=" + quantity;
    }
}

class Inventory {
    private Product[] products;
    private int size;

    public Inventory(int capacity) {
        products = new Product[capacity];
        size = 0;
    }

    public void add(Product product) {
        if (size < products.length) {
            products[size++] = product;
        } else {
            System.out.println("Full.");
        }
    }

    public void remove(int id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId() == id) {
                for (int j = i; j < size - 1; j++) {
                    products[j] = products[j + 1];
                }
                size--;
                return;
            }
        }
        System.out.println("not found.");
    }

    public void update(int id, double price, int quantity) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId() == id) {
                products[i].setPrice(price);
                products[i].setQuantity(quantity);
                return;
            }
        }
        System.out.println("not found.");
    }

    public Product search(String keyword) {
        for (Product product : products) {
            if (product != null && (product.getName().equalsIgnoreCase(keyword) ||
                    product.getCategory().equalsIgnoreCase(keyword) ||
                    String.valueOf(product.getId()).equals(keyword))) {
                return product;
            }
        }
        return null;
    }

    public void all() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory(10);

        //Adding
        inventory.add(new Product(1, "Laptop", "Electronics", 100, 10));
        inventory.add(new Product(2, "Chair", "Furniture", 40, 30));

        //All
        System.out.println("All products:");
        inventory.all();
        //Search
        Product foundProduct = inventory.search("2");
        if (foundProduct != null) {
            System.out.println(foundProduct);
        } else {
            System.out.println("not found.");
        }

        //Removing
        inventory.remove(1);

        //Updating
        inventory.update(2, 59, 25);
        System.out.println("Updated:");
        System.out.println(inventory.search("2"));
    }
}
// ამოცანა 1 (ონლაინ მაღაზიის აღრიცხვის სიტემა) (50 ქულა):
// დაწერეთ ონლაინ მაღაზიის ინვენტარის აღრიცხვის სისტემა ობიექტზე ორიენტირებული
// პროგრამირების დახმარებით. სისტემამ საშუალება უნდა მოგცეთ:
// - დაამატოთ პროდუქტი ინვენტარში
// - ამოიიღოთ პროდუქტი ინვენტარიდან
// - განაახლოთ პროდუქთის ინფორმაცია (მაგ. ფასი, ხარისხი)
// - მოძებნოთ პროდუქტი სახელით, კატეგორიით, აიდით.
// - დააბრუნოთ ყველა პროდუქტი რაც არის ინვენტარში.
// თითოეულ პროდუქტს უნდა გააჩნდეს შემდეგი ატრიბუტები:
// - აიდი
// - სახელი
// - კატეგორია
// - ფასი
// - რაოდენობა მარაგში
// მოგიწევთ იმპლემენტაცია გაუკეთოთ შემდეგ კლასებს:
// - პროდუქტის კლსაის (Product.java): რომელიც წარმოადგენს ერთ პროდუქტს თავისი
// ატრიბუტებით.
// - ინვენტარის კლასი (Inventory.java): რომელიც ინახავს პროდუქტების კოლექციას და
// რომელსაც გააჩნია პროდუქტის დამატების, ამოღების, დააფდეითების და მოძებნის
// მეთოდები, ასევე ყველა პროდუქტის გამოტანის მეთოდი.
// გამოუყენეთ მხოლოდ მასივები და სხვა მარტივი მონაცემთა სტრუქტურები პროდუქტების
// შესანახად და ინვენტარის მენეჯინგისთვის. ეცადეთ წეროთ ოოპეს პრინციპებით და სუფთა კოდი.
public class Unique {
    public static void main(String[] args) {
        Unique uniqueFinder = new Unique();
        String text1 = "acbdba";
        String text2 = "aabwbccddef";
        System.out.println(uniqueFinder.unique(text1));
        System.out.println(uniqueFinder.unique(text2));
    }
    
    private static final int size = 26;
    private int unique(String text) {
        int[] count = new int[size];

        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int maxIndex = -1;


        for (int i = 0; i < size; i++) {
            if (count[i] == 1) {
                maxIndex = Math.max(maxIndex, text.lastIndexOf((char)('a' + i))+1);
            }
        }
        return maxIndex;
    }
}
// ამოცანა 2 (50 ქულა):
// მოცემული გაქვთ ტექსტი, რომელიც შედგენილია ინგლისურის ალფაბეტისგან , რომელშიც ორის
// გარდა ყველა სიმბოლო ზუსტად ორჯერ გვხვდება, ეს ორის სიმბოლო უნიკალურია და გვხვდება
// მხოლოდ ერთხელ. იპოვეთ ორთავე სიმბოლოს ინდექსები და დააბრუნეთ ამ ინდექსებს შორის
// მაქსიმალური.
// მაგალითად ტექსტში “acbdba” უნიკალური სიმბოლოებია ‘c’ და ‘d’ მათი ინდექსების მაქსიმუმი კი
// არის 3.
// ხოლო ტექსტში “aabwbccddeef” უნიკალური სიმბოლოებია ‘w’ და ‘f’ მაქსიმალური ინდექსი კი 11.
// დაწერეთ მეთოდი unique რომელსაც გადაეცემა სტრინგი და აბრუნებს მთელ რიცხვს.
// მეთოდი private int unique(String text) დაწერეთ Unique.java ფაილში
// public void run() {
// int n = unique(“acbdba”);
// println(n); // უნდა დაბეჭდოს 3
// }
// ამოხსენით მაქსიმუმ მასივის გამოყენებით.