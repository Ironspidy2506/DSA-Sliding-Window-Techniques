import java.util.*;

// TC : O(n)
// SC : O(1)

public class Main {
    public static int numberOfSubstrings(String s) {
        int[] ans = new int[] { -1, -1, -1 };
        int r = 0;
        int cnt = 0;
        while (r < s.length()) {
            ans[s.charAt(r) - 'a'] = r;
            if (ans[0] != -1 && ans[1] != -1 && ans[2] != -1) {
                cnt = cnt + (1 + Math.min(ans[0], Math.min(ans[1], ans[2])));
            }
            r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String s = sc.nextLine();

        System.out.println(numberOfSubstrings(s));
        sc.close();
    }
}