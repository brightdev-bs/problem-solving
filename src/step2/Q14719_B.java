package step2;

import java.util.Scanner;

public class Q14719_B {

    static int[] heights;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        heights = new int[w];
        for(int i = 0; i < w; i++) {
            heights[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i = 1; i < w - 1; i++) {

            int LM = 0;
            int RM = 0;

            int currentHeight = heights[i];

            // 왼쪽에서 가장 긴 기둥
            for(int j = 0; j <= i; j++) { // 이거를 포함 안하면 안됨.
                LM = Math.max(LM, heights[j]);
            }

            // 오른쪽에서 가장 긴 기둥
            for(int j = i; j < w  ; j++) {
                RM = Math.max(RM, heights[j]);
            }

            sum += Math.min(LM, RM) - currentHeight;
        }
        if(sum < 0) sum = 0;
        System.out.println(sum);

    }
}
