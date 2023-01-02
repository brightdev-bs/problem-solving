package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Q1495 {
    static int n,s,m;
    static int[] arr;
    static int[][] dp;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();
        m = sc.nextInt();
        dp = new int[m + 1][n];

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int[] arr : dp) {
            Arrays.fill(arr, -2);
        }

        System.out.println(DFS(s, 0));
    }

    public static int DFS(int sum, int idx) {

        if(sum > m || sum < 0) {
            return -1;
        }

        if(idx == n) {
            return sum;
        }

        if(dp[sum][idx] != -2) {
            return dp[sum][idx];
        }

        return dp[sum][idx] = Math.max(dp[sum][idx],
                Math.max(
                        DFS(sum + arr[idx], idx + 1),
                    DFS(sum - arr[idx], idx + 1)
                )
        );

    }
}
