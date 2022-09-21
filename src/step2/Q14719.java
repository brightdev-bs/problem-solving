package step2;

import java.util.Scanner;

public class Q14719 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] map = new int[w];
        for(int i = 0; i < w; i++) {
            map[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < w; i++) {
            int index = map[i];

            // 왼쪽에서 기준점보다 큰 최대높이 기둥 찾기
            int left = 0;
            for(int j = i; 0 <= j; j--) {
                left = Math.max(left, map[j]);
            }

            int right = 0;
            for(int j = i; j < w; j++) {
                right = Math.max(right, map[j]);
            }

            sum += Math.min(left, right) - index;
        }

        if(sum < 0) sum = 0;
        System.out.println(sum);
    }
}
