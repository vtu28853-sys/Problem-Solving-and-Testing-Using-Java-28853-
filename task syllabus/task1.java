import java.util.*;
import java.util.stream.*;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] salary = new int[n];

        for (int i = 0; i < n; i++) {
            salary[i] = sc.nextInt();
        }

        int[] updated = Arrays.stream(salary)
                .map(s -> s * 110 / 100)
                .toArray();

        for (int s : updated) {
            System.out.print(s + " ");
        }
    }
}