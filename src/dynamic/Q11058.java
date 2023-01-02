package dynamic;

import java.util.Scanner;

public class Q11058 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + 1;
            for(int j = 1; j <= i - 3; j++) {
                long tmp = arr[i - (j + 2)] * (j + 1);
                arr[i] = Math.max(arr[i], tmp);
            }
        }

        System.out.println(arr[n]);

    }
}
