// Solved using cyclic sort

// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
// time complexity : O(n)

// Amazon question
// https://leetcode.com/problems/missing-number/description/

// google question 
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = { 9,6,4,2,3,5,7,0,1 };
        System.out.println(missingNumber(arr));
    }
    
    static public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i]; // get the correct index of the number
            // check weather the number is present at the correct index or not
            // If the number is present at the correct index, increment i
            // else swap the number with the correct index
            if (correctIndex < nums.length && nums[i] != nums[correctIndex]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        // check for the missing number [ if missing number < n]

        // // linear saerch
        for (int j = 0; j < nums.length; j++) {
            if (j != nums[j]) {
                return j;
            }
        }

        // // case 2 : if the missing number is n 
        return nums.length;
    }
}


/*
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 */