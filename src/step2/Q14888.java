package step2;

import java.util.Scanner;

public class Q14888 {

    static int[] operators = new int[4];
    static int[] arr;

    static int n;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int L, int sum) {
        if(L == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }


        for(int i = 0; i < 4; i++) {
            if(operators[i] > 0) {

                operators[i]--;

                switch(i) {
                    case 0: dfs(L+1, sum + arr[L]); break;
                    case 1: dfs(L+1, sum - arr[L]); break;
                    case 2: dfs(L+1, sum * arr[L]); break;
                    case 3: dfs(L+1, sum / arr[L]); break;
                }

                operators[i]++;
            }
        }

    }

}
