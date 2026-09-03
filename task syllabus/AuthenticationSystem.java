import java.util.*;

class AuthenticationSystem {

    public boolean login(String username, String password) {

        if (username == null || password == null) {
            return false;
        }

        // Boundary value testing
        if (username.length() < 3 || username.length() > 20) {
            return false;
        }

        if (password.length() < 6 || password.length() > 20) {
            return false;
        }

        // Valid credentials
        return username.equals("admin")
                && password.equals("admin123");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AuthenticationSystem auth =
                new AuthenticationSystem();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String username = sc.next();
            String password = sc.next();

            try {

                if (auth.login(username, password)) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILURE");
                }

            } catch (Exception e) {
                System.out.println("FAILURE");
            }
        }
    }
}