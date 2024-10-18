import java.util.*;

// TC : O(n)
// SC : O(1)

public class Main {
    public static int helper(int[] nums, int goal) {
        int sum = 0;
        int r = 0;
        int l = 0;
        int cnt = 0;

        if (goal < 0)
            return 0;

        while (r < nums.length) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            cnt = cnt + (r - l + 1);
            r++;
        }
        return cnt;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int x = helper(nums, goal);
        int y = helper(nums, goal - 1);
        return x - y;
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

        System.out.println(numSubarraysWithSum(arr, K));

        sc.close();
    }
}