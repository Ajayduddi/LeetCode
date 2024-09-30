/**
 * SearchInRotatedArray2
 * here is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 */
public class SearchInRotatedArray2 {

    public static void main(String[] args) {
        int[] nums = new int[] { 2,2,2,0,1 };
        int target = 0;
        System.out.println(search(nums, target));
    }
    
    static public boolean search(int[] nums, int target) {
        int max = findMax(nums);
        int end = nums.length - 1;
        int ans = -1;

        ans = binearySearch(nums, target, 0, max);
        if (ans == -1) {
            ans = binearySearch(nums, target, max + 1, end);
        }

        return ans!=-1?true:false;
    }
    
    static int findMax(int[] nums) {
        int max = nums[0];
        int index=0;

        for (int i=1; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max == nums[i]) {
                index = i;
            }
            if (nums[i] < nums[i - 1])
                break;
        }

        return index;
    }
    
    
    static int binearySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        return -1;
    }

}

/*
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 */