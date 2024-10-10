import java.util.ArrayList;
import java.util.List;

/**
 * FindAllDuplicatesNumbers
 * 
 * Given an integer array nums of length n where all the integers of nums are in
 * the range [1, n] and each integer appears once or twice, return an array of
 * all the integers that appears twice.
 * 
 * microsoft
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 */
public class FindAllDuplicatesNumbers {

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDuplicates(nums));
    }

    // method 1 [ it exceeds the time limit in leet code]
    static public List<Integer> findDuplicates1(int[] nums) {
        int i = 0;
        List<Integer> dup = new ArrayList<>();

        // cyclic sort
        while (i < nums.length) {
            int correct = nums[i] - 1;
            // Check if the number is not equal to its correct number present in index
            if (nums[i] != i + 1) {
                // If the current number matches the number at its correct position, it is a
                // duplicate
                if (nums[i] == nums[correct]) {
                    if (!dup.contains(nums[i])) {
                        dup.add(nums[i]);
                    }
                    i++;
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

        return dup;
    }

    // method2 [ efficient]
    static public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        List<Integer> dup = new ArrayList<>();

        // cyclic sort
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] == nums[correct]) {
                i++;
            } else {
                // Swap the current number with the number at its correct position
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
        }

        // find the duplicate numbers
        // logic is if item appear once then it is in its corret position. 
        // if it appears more then once remaining items are not its in correct position
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j + 1) {
                dup.add(nums[j]);
            }
        }

        return dup;
    }
}