package dynamic.set1;

import java.util.Scanner;

public class Q9095 {

    public static int[] memory = new int[12];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        memory[1] = 1;
        memory[2] = 2;
        memory[3] = 4;
        for(int i = 4; i <= 11; i++) {
            memory[i] = memory[i - 1] + memory[i - 2] + memory[i - 3];
        }

        for (int i : arr) {
            System.out.println(memory[i]);
        }
    }
}
