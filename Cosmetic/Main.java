package Cosmetic;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Cosmetic c;
        Inventory i = new Inventory();
        Login l = new Login();
        User u;

        int op, con;
        String name, id, brand, u_name, pwd;
        float price;

        do {
            System.out.println("Welcome to Cosmetic Shop!");
            System.out.println("User Name: ");
            u_name = scan.next();
            System.out.println("Password: ");
            pwd = scan.next();
            u = new User(u_name, pwd);
            int lc = l.checkUser (u);

            if (lc == 1) {
                do {
                    System.out.println("Cosmetic Shop Menu:");
                    System.out.println("1-Add Product\n2-Update Product\n3-Remove Product\n4-Search Product\n5-Display Inventory");
                    System.out.println("Enter Option: ");
                    int option = scan.nextInt();

                    switch (option) {
                        case 1:
                            System.out.println("Product ID: ");
                            id = scan.next();
                            System.out.println("Product Name: ");
                            name = scan.next();
                            System.out.println("No of item: ");
                            brand = scan.next();
                            System.out.println("Price: ");
                            price = scan.nextFloat();
                            i.add(new Cosmetic(id, name, brand, price));
                            break;

                        case 2:
                            System.out.println("Product ID: ");
                            id = scan.next();
                            i.update(id);
                            break;

                        case 3:
                            System.out.println("Product ID: ");
                            id = scan.next();
                            i.remove(id);
                            break;

                        case 4:
                            System.out.println("Product ID: ");
                            id = scan.next();
                            c = i.search(id);
                            if (c != null) {
                                System.out.println("Product Found: " + c);
                            } else {
                                System.out.println("Product not found!");
                            }
                            break;

                        case 5:
                            i.show();
                            break;

                        case 6:
                            System.out.println("Exiting...");
                            return;

                        default:
                            System.out.println("Invalid Option!");
                            break;
                    }

                    System.out.println("Enter -1 to logout");
                    op = scan.nextInt();

                } while (op != -1);

            } else if (lc == 2) {
                i.show();
            } else {
                System.out.println("Invalid Login.");
            }

            System.out.println("Enter 1 to login");
            con = scan.nextInt();

        } while (con == 1);

        scan.close();
    }
}