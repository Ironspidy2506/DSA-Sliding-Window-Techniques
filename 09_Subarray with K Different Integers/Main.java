import java.util.*;

// TC : O(n)
// SC : O(k)

public class Main {
    public static int helper(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int r = 0;
        int l = 0;
        int cnt = 0;
        if (k == 0) {
            return 0;
        }

        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            cnt = cnt + (r - l + 1);
            r++;
        }
        return cnt;
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the value of K: ");
        int K = sc.nextInt();

        System.out.println(subarraysWithKDistinct(arr, K));

        sc.close();
    }
}