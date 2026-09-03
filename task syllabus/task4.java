import java.util.*;

public class task4 {

    static int[] createLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int length = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    static void KMP(String text, String pattern) {

        int[] lps = createLPS(pattern);

        int i = 0;
        int j = 0;

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                System.out.print((i - j) + " ");
                j = lps[j - 1];
            } else if (i < text.length()
                    && text.charAt(i) != pattern.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        String pattern = sc.next();

        KMP(text, pattern);
    }
}