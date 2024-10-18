import java.util.*;

// TC : O(n)
// SC : O(1)

public class Main {
    public static int helper(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r] % 2;

            while (sum > k) {
                sum -= nums[l] % 2;
                l++;
            }

            cnt = cnt + (r - l + 1);
            r++;
        }
        return cnt;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
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

        System.out.println(numberOfSubarrays(arr, K));

        sc.close();
    }
}