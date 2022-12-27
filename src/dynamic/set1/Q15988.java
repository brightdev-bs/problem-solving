package dynamic.set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15988 {

    static long[] memory = new long[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        memory[1] = 1;
        memory[2] = 2;
        memory[3] = 4;
        for(int i = 4; i <= 1000000; i++) {
            memory[i] = (memory[i - 1] + memory[i - 2] + memory[i - 3]) % 1_000_000_009;
        }

        for (int i : arr) {
            System.out.println(memory[i]) ;
        }

    }
}
