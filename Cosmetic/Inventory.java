package Cosmetic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private DBUtil db = new DBUtil();
    private Connection con;

    public void add(Cosmetic c) {
        try {
            con = db.getDBConnection();
            Statement stmt = con.createStatement();
            String qry = "INSERT INTO cosmeticproducts(id, name, brand, price) VALUES('" + c.getId() + "','" + c.getName() + "','" + c.getBrand() + "','" + c.getPrice() + "')";
            int count = stmt.executeUpdate(qry);
            if (count == 1) {
                System.out.println("Product added successfully");
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Cosmetic search(String id) {
        try {
            con = db.getDBConnection();
            Statement stmt = con.createStatement();
            String qry = "SELECT * FROM cosmeticproducts WHERE id='" + id + "'";
            ResultSet rs = stmt.executeQuery(qry);
            if (rs.next()) {
                return new Cosmetic(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void update(String id) {
        Scanner sc = new Scanner(System.in);
        int ch;

        try {
            con = db.getDBConnection();
            Statement stmt = con.createStatement();

            System.out.print("Enter to update 1.Name 2.Price ");
            ch = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            String qry = null;
            switch (ch) {
                case 1:
                    System.out.println("Enter New Name: ");
                    String newName = sc.nextLine();
                    qry = "UPDATE cosmeticproducts SET name='" + newName + "' WHERE id='" + id + "'";
                    break;

                case 2:
                    System.out.println("Enter New Price: ");
                    float newPrice = sc.nextFloat();
                    qry = "UPDATE cosmeticproducts SET price=" + newPrice + " WHERE id='" + id + "'";
                    break;



                default:
                    System.out.println("Invalid choice");
                    return;
            }

            int count = stmt.executeUpdate(qry);
            if (count == 1) {
                System.out.println("Record updated successfully.");
            } else {
                throw new Exception("No record updated.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(String id) {
        try {
            con = db.getDBConnection();
            Statement stmt = con.createStatement();
            String qry = "DELETE FROM cosmeticproducts WHERE id='" + id + "'";
            int count = stmt.executeUpdate(qry);
            if (count == 1) {
                System.out.println("Cosmetic product removed successfully.");
            } else {
                System.out.println("Cosmetic product not found!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void show() {
        try {
            con = db.getDBConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cosmeticproducts");
            while (rs.next())
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getFloat(4));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
