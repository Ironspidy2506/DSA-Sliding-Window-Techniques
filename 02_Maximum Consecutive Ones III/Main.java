import java.util.*;

// TC : O(n)
// SC : O(1) 

public class Main {
    public static int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int l = 0;
        int r = 0;
        int maxlen = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                zeros++;
            }

            if (zeros > k) {
                if (nums[l] == 0)
                    zeros--;
                l++;
            }

            if (zeros <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r++;
        }

        return maxlen;
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

        System.out.println(longestOnes(arr, K));

        sc.close();
    }
}