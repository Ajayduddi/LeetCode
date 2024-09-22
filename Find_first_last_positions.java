import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * 
 * using binary search
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Find_first_last_positions {
    
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 7, 8, 8, 10 };
        int target = 7;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
    
    static int[] searchRange(int[] nums, int target) {
        int[] arr = { -1, -1 };

        int start = search(nums, target, true);
        int end = search(nums, target, false);

        arr[0] = start;
        arr[1] = end;

        return arr;
    }

    static int search(int[] nums, int target, boolean findFirstIndex) {
        int start = 0;
        int end = nums.length - 1;

        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target)
                end = mid - 1;
            else if (nums[mid] < target)
                start = mid + 1;
            else {
                ans = mid;
                if (findFirstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        
        return ans;
    }
}

// Example 1:
// Input: nums = [5,7,7,7,8,8,10], target = 7
// Output: [1,3]

// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]