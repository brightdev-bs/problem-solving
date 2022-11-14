package basic;

import java.util.Arrays;
import java.util.Scanner;

public class Q17070 {

    static int n;
    static int[][] board;

    public enum Status {
        WID, LEN, DIA
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        n = sc.nextInt();
        board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        DFS(0,1, Status.WID);
        System.out.println(answer);
    }

    static int answer = 0;
    public static void DFS(int r, int c, Status status) {
        if(r == n - 1 && c == n - 1) {
            answer++;
            return;
        }

        if(status.equals(Status.WID)) {
            if(c + 1 < n && board[r][c+1] == 0) {
                DFS(r, c + 1, Status.WID);
            }
        } else if(status.equals(Status.LEN)) {
            if(r + 1 < n && board[r+1][c] == 0) {
                DFS(r + 1, c, Status.LEN);
            }
        } else if(status.equals(Status.DIA)) {
            if(c + 1 < n && board[r][c+1] == 0) {
                DFS(r, c + 1, Status.WID);
            }
            if(r + 1 < n && board[r+1][c] == 0) {
                DFS(r + 1, c, Status.LEN);
            }
        }

        if (r + 1 < n && c + 1 < n && board[r][c + 1] == 0 && board[r + 1][c] == 0 && board[r + 1][c + 1] == 0) {
            DFS(r+1, c+1, Status.DIA);
        }
    }
}
