package Cosmetic;

public class Login {
    private static final String VALID_USERNAME = "Admin";
    private static final String VALID_PASSWORD = "adm";
    private static final String VALID_USERNAME1 = "User";
 //   private static final String VALID_PASSWORD1 = "12345";
    public int checkUser  (User  u) 
    {
        if (u.getUsername().equals(VALID_USERNAME) && u.getPassword().equals(VALID_PASSWORD)) 
        {
            System.out.println("Login  as Admin");
            return 1;
        } 
        else if (u.getUsername().equals(VALID_USERNAME1)) 
        {
            System.out.println("Login as User");
            return 2;
        } 
        else 
        {
            System.out.println("Login failed. Please try again.");
            return 0;
        }
    }
}