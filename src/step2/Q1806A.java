package step2;

import java.util.Scanner;

public class Q1806A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int lt = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        int count = 0;
        for(int rt = 0; rt < n; rt++){

            // 일단 더한다.
            sum += arr[rt];
            count++;

            if(sum >= k) {
                answer = Math.min(answer, count);
            }

            // sum이 k보다 크면 lt를 증가시키면서 가감한다.
            while(sum >= k) {
                sum -= arr[lt++];
                count--;
                if(sum >= k) {
                    answer = Math.min(answer, count);
                }
            }
        }

        if(answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {

            System.out.println(answer);
        }
    }
}
