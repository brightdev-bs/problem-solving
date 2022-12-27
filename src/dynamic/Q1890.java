package dynamic;

import java.util.Scanner;

public class Q1890 {

    public static int[][] board;
    public static long[][] dp;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];
        dp = new long[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(DFS(0, 0));

    }

    public static long DFS(int r, int c) {
        if(r == n - 1 && n - 1 == c) return 1;

        if(dp[r][c] != 0) return dp[r][c];

        int cv = board[r][c];

        // 중간에 0이 있으면 무한루프가 돈다
        if(cv == 0) return 0;

        int nr = r + cv;
        int nc = c + cv;

        if(nr > n && nc > n) {
            return 0;
        }

        if(nr < n) {
            dp[r][c] = Math.max(dp[r][c], dp[r][c] + DFS(nr, c));
        }

        if(nc < n) {
            dp[r][c] = Math.max(dp[r][c], dp[r][c] + DFS(r, nc));
        }

        return dp[r][c];
    }
}
