package step1;

import java.util.Scanner;

public class Q1978 {

    static int[] ch = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i <= 1000; i++) {
            for(int j = i; j <= 1000; j = j + i) {
                ch[j]++;
            }
        }

        int cnt = 0;
        for (int i : arr) {
            if(ch[i] == 2) cnt++;
        }

        System.out.println(cnt);

    }
}
