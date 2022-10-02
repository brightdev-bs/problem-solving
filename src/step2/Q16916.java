package step2;

import java.util.Scanner;

public class Q16916 {

    static int result, pi[];
    static String s, p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        s = sc.next();
        p = sc.next();

        pi = new int[p.length()];
        getPi();
        KMP();
    }

    private static void getPi() {
        int n = p.length();
        int j = 0;
        for(int i = 1; i < n; i++) {
            while(j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }

            if(p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }

    public static void KMP() {
        int j = 0;
        for(int i = 0 ; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != p.charAt(j)) {
                j = pi[j-1];
            }

            if(s.charAt(i) == p.charAt(j)) {
                if(j == p.length() - 1) {
                    result = 1;
                    break;
                }
                else ++j;
            }
        }
        System.out.println(result);
    }

}
