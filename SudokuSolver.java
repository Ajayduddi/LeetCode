// https://leetcode.com/problems/sudoku-solver/

import java.util.Arrays;

public class SudokuSolver {

    public static void main(String[] args) {
        // char[][] board = {
        //     {'5','3','.','.','7','.','.','.','.'},
        //     {'6','.','.','1','9','5','.','.','.'},
        //     {'.','9','8','.','.','.','.','6','.'},   
        //     {'8','.','.','.','6','.','.','.','3'},
        //     {'4','.','.','8','.','3','.','.','1'},
        //     {'7','.','.','.','2','.','.','.','6'},
        //     {'.','6','.','.','.','.','2','8','.'},
        //     {'.','.','.','4','1','9','.','.','5'},    
        //     {'.','.','.','.','8','.','.','7','9'}
        // };

        char[][] board = {
            {'.','.','9','7','4','8','.','.','.'},
            {'7','.','.','.','.','.','.','.','.'},
            {'.','2','.','1','.','9','.','.','.'},
            {'.','.','7','.','.','.','2','4','.'},
            {'.','6','4','.','1','.','5','9','.'},
            {'.','9','8','.','.','.','3','.','.'},
            {'.','.','.','8','.','3','.','2','.'},
            {'.','.','.','.','.','.','.','.','6'},
            { '.', '.', '.', '2', '7', '5', '9', '.', '.' }
        };

        solveSudoku(board);
        // for (char[] list : board) {
        //     System.out.println(Arrays.toString(list));
        // }
    }
    
    static public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    
    static public boolean solve(char[][] board, int row, int col) {
        // Solution found
        if (row == 9) {
            display(board);
            return true;
        }
    
        // Move to the next row if we are at the last column
        if (col == 9) {
            return solve(board, row + 1, 0);
        }
    
        // If cell is already filled, skip to the next cell
        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }
    
        // Try placing numbers from 1 to 9
        for (char num = '1'; num <= '9'; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                
                // If solve(board) returns true, solution is complete
                if (solve(board, row, col + 1)) {
                    return true;
                }
                
                // Backtrack if not successful
                board[row][col] = '.';
            }
        }
    
        return false; // No solution found for this configuration
    }
    
    static public boolean isSafe(char[][] board, int row, int col, char num) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
    
        // Check 3x3 box
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
    
        return true;
    }
    
    static public void display(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
    
    
}