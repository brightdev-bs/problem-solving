package basic;

import java.util.Scanner;

public class Q2293 {

    static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        dy = new int[k + 1];

        int[] coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        dy[0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = coins[i]; j <= k; j++) {
                if(dy[j - coins[i]] > 0) {
                    dy[j] += dy[j - coins[i]];
                }
            }
        }

        System.out.println(dy[k]);
    }
}
