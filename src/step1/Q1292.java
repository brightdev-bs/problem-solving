package step1;

import java.util.Scanner;

public class Q1292 {
    static int[] arr = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = 0;
        for(int i = 1; i < 1001; i++) {
            for(int j = 0; j < i; j++) {
                if(c == 1001) break;
                arr[c++] = i;
            }
        }

        int sum = 0;
        for(int i = a - 1; i < b; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}

