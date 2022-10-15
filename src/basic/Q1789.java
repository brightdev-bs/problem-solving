package basic;

import java.util.Scanner;

public class Q1789 {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        int n = 0;
        while(true) {
            if(s >= n) s -= n;
            else break;
            n++;
        }
        System.out.println(--n);
    }
}