// https://leetcode.com/problems/valid-sudoku/description/
import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' },
                { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' },
                { '.', '.', '4', '.', '.', '.', '.', '.', '.' }
        };

        System.out.println(isValidSudoku(board));
    }

    static public boolean isValidSudoku(char[][] board) {
        boolean ans = true;

        for (int i = 0; i < 9; i++) {
            if (!isValid(board, i, i)) {
                ans = false;
                break;
            }
        }

        return ans;
    }

    static public boolean isValid(char[][] board, int row, int col) {
        Map<Character, Boolean> map = new HashMap<>();
        // chcek column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.') {
                if (!map.containsKey(board[i][col])) {
                    map.put(board[i][col], true);
                } else {
                    return false;
                }
            }
        }

        map = new HashMap<>();
        // chcek row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.') {
                if (!map.containsKey(board[row][i])) {
                    map.put(board[row][i], true);
                } else {
                    return false;
                }
            }
        }


        // chcek grid
        int gridRow, x=0;
        while (x < 9) {
            map = new HashMap<>();
            gridRow = x - x % 3;
            x += 3;
            int gridCol = col - col % 3;
            for (int i = gridRow; i < gridRow + 3; i++) {
                for (int j = gridCol; j < gridCol + 3; j++) {
                    if (board[i][j] != '.') {
                        if (!map.containsKey(board[i][j])) {
                            map.put(board[i][j], true);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}