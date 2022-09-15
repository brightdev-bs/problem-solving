package step1;

import java.util.Scanner;

public class Q3460 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int cnt = 0;
            int n = sc.nextInt();
            while(n > 0) {
                if(n % 2 == 1) System.out.print(cnt + " ");
                n = n / 2;
                cnt++;
            }
        }
    }
}
