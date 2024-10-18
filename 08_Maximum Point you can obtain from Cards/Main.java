import java.util.*;

// TC : O(n)
// SC : O(1)

public class Main {
    public static int maxScore(int[] card, int k) {
        int maxSum = 0;
        int lsum = 0;
        for (int i = 0; i <= k - 1; i++) {
            lsum += card[i];
        }

        maxSum = Math.max(maxSum, lsum);

        int rsum = 0;
        int ridx = card.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            lsum = lsum - card[i];
            rsum = rsum + card[ridx];
            maxSum = Math.max(maxSum, lsum + rsum);
            ridx--;
        }

        return maxSum;
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

        System.out.println(maxScore(arr, K));

        sc.close();
    }
}