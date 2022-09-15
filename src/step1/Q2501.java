package step1;

import java.util.Scanner;

public class Q2501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) cnt++;
            if(cnt == m) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
