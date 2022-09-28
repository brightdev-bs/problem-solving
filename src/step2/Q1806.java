package step2;

import java.util.Scanner;

public class Q1806 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        // 입력 받기
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 시작
        int lt = 0;
        int rt = 0;
        int answer = Integer.MAX_VALUE;
        int sum = 0;
        for(; rt < n; rt++) {
            if(sum >= s) {
                answer = Math.min(answer, rt - lt);
                while(sum >= s) {
                    sum -= arr[lt++];
                    if(sum >= s) {
                        answer = Math.min(answer, rt - lt);
                    }
                }
            }

            sum += arr[rt];
        }

        while(sum >= s && lt != rt) {
            answer = Math.min(answer, rt - lt);
            sum -= arr[lt++];
            if(sum >= s) {
                answer = Math.min(answer, rt - lt);
            }
        }

        if(answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);

    }
}
