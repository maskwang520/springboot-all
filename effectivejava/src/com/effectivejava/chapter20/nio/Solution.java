package com.effectivejava.chapter20.nio;

/**
 * Created by maskwang on 2017/9/16 0016.
 */
public class Solution {
    public static void solve(char[][] board) {
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[0].length; j++) {
                        if (board[i][j]=='O'&&hasX(board, i, j) == true) {
                            board[i][j] = 'X';
                        }
            }
        }

    }

    public static boolean hasX(char[][] board, int m, int n) {
        boolean cond1 = true, cond2 = true,cond3= true, cond4= true;
        if (m == 0 || m == board.length - 1 || n == 0 || n == board[0].length-1||board[m][n]=='X' ) {
            return false;
        } else {
            if (board[m + 1][n] == 'O') {
                cond1 = hasX(board, m + 1, n);
            }

            if(cond1==true) {
                if (board[m][n + 1] == 'O') {
                    cond2 = hasX(board, m, n + 1);
                }

            }

            if(cond1==true&&cond2==true) {
                if (board[m][n - 1] == 'O') {
                    cond3 = hasX(board, m, n - 1);
                }

            }
            if(cond1==true&&cond2==true&&cond3==true) {
                if (board[m - 1][n] == 'O') {
                    cond4 = hasX(board, m - 1, n);
                }
            }



        }

        return cond1 && cond2&&cond3 && cond4 ;
    }

    public static void main(String[] args) {
        char[][]board={{'O', 'X', 'X','O','X'},{'X',  'O', 'O','X','O'},
        {'X', 'O', 'X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
