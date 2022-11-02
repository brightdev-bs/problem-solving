package step2;

import java.util.ArrayList;
import java.util.Scanner;

// anta로 시작하고 tica로 끝난다.
public class Q1062_A {

    public static boolean ch[] = new boolean[26];

    static int n, k;

    public static String[] arr;

    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        arr = new String[n];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            arr[i] = s;
        }

        if(k < 5) { //a c i n t의 개수가 5개이므로
            System.out.println("0");
            return;
        } else if(k == 26) { //모든 알파벳을 다 읽을 수 있다.
            System.out.println(n);
            return;
        }

        ch['a' - 'a'] = true;
        ch['c' - 'a'] = true;
        ch['i' - 'a'] = true;
        ch['n' - 'a'] = true;
        ch['t' - 'a'] = true;

        backTracking(0, 0);

        System.out.println(answer);

    }

    public static void backTracking(int alpha, int len) {
        if(len == k - 5) {
            int count = 0;
            for (String s : arr) {
                boolean flag = true;
                for (char c : s.toCharArray()) {
                    int idx = c - 'a';
                    if(!ch[idx]) {
                        flag = false;
                    }
                }
                if(flag) count++;
            }
            answer = Math.max(answer, count);
        } else {
            for(int i = alpha; i < 26; i++) {
                if(!ch[i]) {
                    ch[i] = true;
                    backTracking(i, len + 1);
                    ch[i] = false;
                }
            }
        }
    }
}
