package step1;

import java.util.Scanner;

public class Q2581 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] ch = new int[n + 1];
        ch[0] = 1;
        ch[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = i + i; j <= n; j = j + i) {
                ch[j] = 1;
            }
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = m; i <= n; i++) {
            if(ch[i] == 0) {
                min = Math.min(i, min);
                sum += i;
            }
        }
        
        if(sum == 0) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
