// There is an integer array nums sorted in ascending order.(with distinct values).
// The array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// https://leetcode.com/problems/search-in-rotated-sorted-array/

// using bineary search
// time complexity O(logn)

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 5;
        SearchInRotatedArray obj = new SearchInRotatedArray();
        int ans = obj.search(nums, target);
        System.out.println(ans);
    }
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // If the last element is greater than mid element then search in left half
            // If the last element is less than mid element then search in right half
            if (nums[end] > nums[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        
        int peek = start;  // minimum value index
        ans = binearySearch(nums,target,0,peek-1);
        if(ans == -1){
            ans = binearySearch(nums,target, peek , nums.length -1 );
        }

        return ans;

    }

    public int binearySearch(int[] arr,int target,int start, int end){
        while(start<=end){
            int mid = start+(end-start)/2;

            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target) end = mid-1;
            else start = mid+1;
        }

        return -1;
    }
}
