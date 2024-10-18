import java.util.*;

// TC : O(n)
// SC : O(n)

public class Main {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int cnt = 0;
        int l = 0;
        int r = 0;
        int si = 0;
        while (r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                if (map.get(s.charAt(r)) > 0) {
                    cnt = cnt + 1;
                }
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
            }

            while (cnt == t.length()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    si = l;
                }
                if (map.containsKey(s.charAt(l))) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    if (map.get(s.charAt(l)) > 0) {
                        cnt = cnt - 1;
                    }
                }
                l++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(si, si + minLen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String s: ");
        String s = sc.nextLine();

        System.out.print("Enter the String t: ");
        String t = sc.nextLine();

        System.out.println(minWindow(s, t));
        sc.close();
    }
}