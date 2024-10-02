/**
 * CountNegativeNumbersInMatrix
 * 
 * Given a m x n matrix grid which is sorted in non-increasing order both
 * row-wise and column-wise, return the number of negative numbers in grid.
 * 
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
 */
public class CountNegativeNumbersInMatrix {

    public static void main(String[] args) {
        int[][] arr = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};

        System.out.println(countNegatives(arr));
    }

    static public int countNegatives(int[][] grid) {
        int row = 0;
        int col = grid[0].length - 1;
        int sum = 0;

        while (row < grid.length && col >= 0) {
            if (grid[row][col] < 0) {
                col--;
                int rowl = (grid.length) - row;
                sum += rowl;
            } else {
                row++;
            }
        }

        return sum;
    }
}

/*
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 */