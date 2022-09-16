package step1;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309 {

    static int[] combi = new int[9];
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int input = sc.nextInt();
            arr[i] = input;
            sum += input;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    Arrays.sort(arr);
                    for (int k = 2; k < 9; k++) {
                        System.out.println(arr[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
