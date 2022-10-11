package step2;

import java.util.Scanner;

// 연산자 끼워넣기 복습
public class Q14888_A {

    static int[] arr;
    static int[] operator = new int[4];
    static int n;

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int L, int sum) {
        if(L == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        } else {
            for(int i = 0; i < 4; i++) {
                if(operator[i] > 0) {

                    operator[i]--;

                    switch(i) {
                        case 0: dfs(L+1, sum + arr[L]); break;
                        case 1: dfs(L+1, sum - arr[L]); break;
                        case 2: dfs(L+1, sum * arr[L]); break;
                        case 3: dfs(L+1, sum / arr[L]); break;
                    }

                    operator[i]++;
                }
            }
        }
    }
}
