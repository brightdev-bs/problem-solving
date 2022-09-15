package step1;

import java.util.Scanner;

public class Q10780 {

    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        memo = new int[n+1];
        System.out.println(fibo(n));
    }

    public static int fibo(int n) {
        if(memo[n] != 0) return memo[n];
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        else return memo[n] = fibo(n - 1) + fibo(n - 2);
    }
}
