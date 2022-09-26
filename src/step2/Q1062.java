package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1062 {

    static boolean visited[] = new boolean[26];
    static int max = 0;
    static String[] substring;
    static int[] numbers;
    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        substring = new String[n];

        if(k < 5) {
            System.out.println(0);
            return;
        } else if(k == 26) {
            System.out.println(n);
            return;
        } else {
            for(int i = 0; i < n; i++) {
                String str = sc.next();
                substring[i] = str.substring(4, str.length() - 4);
            }

            visited['a' - 97] = true;
            visited['n' - 97] = true;
            visited['t' - 97] = true;
            visited['i' - 97] = true;
            visited['c' - 97] = true;

            numbers = new int[k-5];
            combination(0,0);
            System.out.println(max);
        }
    }

    private static void combination(int idx, int start) {
        if(idx == k - 5) {
            int count = 0;

            for(int i = 0; i < n; i++) {
                boolean isValid = true;
                for(int j = 0; j < substring[i].length(); j++) {
                    if(!visited[substring[i].charAt(j)-97]) {
                        isValid = false;
                        break;
                    }
                }
                if(isValid) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for(int i = start; i < 26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(idx+1, i+1);
                visited[i] = false;
            }
        }
    }
}
