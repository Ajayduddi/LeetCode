/**
 * Search2DMatrix
 * You are given an m x n integer matrix matrix with the following two properties:
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 * 
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 34;

        System.out.println(searchMatrix(matrix, target));
    }
    
    static public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0;
        int row = matrix.length - 1;

        while (rowStart <= row) {
            int midrow = rowStart + (row - rowStart) / 2;
            int start = 0;
            int end = matrix[midrow].length - 1;

            if (matrix[midrow][0] <= target && matrix[midrow][matrix[midrow].length - 1] >= target) {
                while (start <= end) {
                    int mid = start + (end - start) / 2;

                    if (matrix[midrow][mid] == target) {
                        return true;
                    } else if (matrix[midrow][mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

                return false;
            } else if (matrix[midrow][0] > target) {
                row = midrow - 1;
            } else {
                rowStart = midrow + 1;
            }
        }
        
        return false;
    }
}

/*
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 */