package step2;

import java.util.Scanner;

public class Q14719_A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int[] height = new int[w];
        for(int i = 0; i < w; i++) {
            height[i] = sc.nextInt();
        }

        int lt = height[0];
        int answer = 0;
        for(int i = 1; i < w; i++) {
            int left = 0, right = 0;

            for(int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }

            for(int j = i; j < w; j++) {
                right = Math.max(right, height[j]);
            }

            int result = Math.min(left, right) - height[i];
            if(result >= 0) answer += result;
        }

        System.out.println(answer);

    }
}
