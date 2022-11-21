package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Q3 {

    static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dy = new int[n];
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dy[0] = 1;
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = i - 1; 0 <= j; j--) {
                if(arr[i] > arr[j] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
        }

        System.out.println(Arrays.stream(dy).max().getAsInt());

    }
}
