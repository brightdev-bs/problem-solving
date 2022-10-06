package basic;

import java.util.Scanner;

public class Q3085 {

    static char[][] board;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        board = new char[n][n];
        for(int i = 0; i < n; i++){
            String input = sc.next();
            for(int j = 0; j < input.length(); j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j + 1 < n && board[i][j] != board[i][j+1]) {
                    char tmp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = tmp;

                    int check = check(board);
                    ans = Math.max(ans, check);

                    tmp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j+1] = tmp;
                }

                if(j + 1 < n && board[j][i] != board[j+1][i]) {
                    char tmp = board[j][i];
                    board[j][i] = board[j+1][i];
                    board[j+1][i] = tmp;

                    ans = Math.max(ans, check(board));

                    tmp = board[j][i];
                    board[j][i] = board[j+1][i];
                    board[j+1][i] = tmp;
                }
            }
        }
        System.out.println(ans);

    }


    public static int check(char[][] a) {
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j = 1; j < n; j++) {
                if(a[i][j] == a[i][j-1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                ans = Math.max(ans, cnt);
            }

            cnt = 1;
            for(int j = 1; j < n; j++) {
                if(a[j][i] == a[j-1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
