package step1;

import java.util.Scanner;

public class Q2460 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        int current = 0;
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < 10; i++) {
            int out = sc.nextInt();
            int in = sc.nextInt();
            current = current - out;
            current = current + in;
            answer = Math.max(answer, current);
        }

        System.out.println(answer);
    }
}
