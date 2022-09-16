package step1;

import java.util.Scanner;

public class Q2609 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int on = n;
        int om = m;

        while(n % m != 0) {
            int tmp = n;
            n = m;
            m = tmp % m;
        }

        System.out.println(m);

        System.out.println(m * (on / m) * (om / m));
    }
}
