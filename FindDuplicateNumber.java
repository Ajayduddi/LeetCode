/**
 * FindDuplicateNumber
 * 
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * 
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 3, 2, 4, 5 };
        System.out.println(findDuplicate(nums));
    }
    
    
    static public int findDuplicate(int[] nums) {
        int i = 0;
        
        // cyclic sort
        while (i < nums.length) {
            // Calculate the correct index where the current number should be placed
            int correct = nums[i] - 1;
    
            // Check if the number is not equal to its correct number present in index
            if (nums[i] != i + 1) {
                
                // If the current number matches the number at its correct position, it is a duplicate
                if (nums[i] == nums[correct]) {
                    return nums[i]; // Return the duplicate number
                } else {
                    // Swap the current number with the number at its correct position
                    int temp = nums[i];
                    nums[i] = nums[correct];
                    nums[correct] = temp;
                }
            } else {
                // If the number is in its correct position, move to the next index
                i++;
            }
        }
        
        // Return -1 if no duplicate is found (though problem guarantees at least one duplicate)
        return -1;
    }
    
}