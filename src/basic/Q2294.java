package basic;

import java.util.Arrays;
import java.util.Scanner;

public class Q2294 {

    static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dy = new int[k + 1];
        Arrays.fill(dy, 100001);
        dy[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = arr[i]; j <= k; j++) {
                dy[j] = Math.min(dy[j], dy[j - arr[i]] + 1);
            }
        }

        System.out.println(dy[k] == 100001 ? -1 : dy[k]);
    }
}
