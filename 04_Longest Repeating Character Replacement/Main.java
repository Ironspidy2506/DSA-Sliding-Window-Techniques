import java.util.*;

// TC : O(n)
// SC : O(1)

public class Main {
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int r = 0;
        int l = 0;
        int maxlen = 0;
        int len = 0;
        int maxf = 0;
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(r)));
            len = r - l + 1;
            if (len - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if (len - maxf <= k) {
                maxlen = Math.max(maxlen, len);
            }
            r++;
        }

        return maxlen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String s = sc.nextLine();

        System.out.print("Enter the value of K: ");
        int K = sc.nextInt();

        System.out.println(characterReplacement(s, K));

        sc.close();
    }
}