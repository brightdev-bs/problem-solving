package dynamic;

import java.util.Scanner;

public class Q15486R {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 2];
        int[][] arr = new int[n + 2][2];
        for(int i = 1; i < n + 1; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i][0] = a; // 기간
            arr[i][1] = b; // 가격
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < n + 2; i++) {

            if(max < dp[i]) {
                max = dp[i];
            }

            int nx = arr[i][0] + i;
            if(nx < n + 2) {
                dp[nx] = Math.max(dp[nx], max + arr[i][1]);
            }
        }

        System.out.println(max);
    }
}
