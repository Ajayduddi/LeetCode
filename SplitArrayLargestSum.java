/*
 * Given an integer array 'nums' and an integer 'k', split 'nums' into 'k' non-empty subarrays such that the largest sum of any subarray is minimized.
 * Return the minimized largest sum of the split.
 * A subarray is a contiguous part of the array.
 */

// https://leetcode.com/problems/split-array-largest-sum/description/

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int arr[] = { 7, 2, 5, 10, 8 };
        int k = 2;

        System.out.println(splitArray(arr, k));
    }

    public static int splitArray(int[] nums, int k) {
        int start = 0, end = 0;

        for (int val : nums) {
            start = Math.max(start, val);
            end += val;
        }

        
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0, parts = 1;

            for (int val : nums) {
                sum += val;
                if (sum > mid) {
                    // the cuuent array sum > mid
                    // then we start the new array
                    sum = val;
                    parts++;
                }
            }

            if ( parts <= k ) end = mid;
            else start = mid + 1;
             
        }

        return start;
    }
}

// nums = [7,2,5,10,8], k = 2
/*
 * case1: The minimum no of partations that can make with the array = 1
 * case2: The max no of partations that can make with the array = n (length of
 * the array)
 * 
 * max value = case1, min value = case2
 * max value = 32 ( sum of the whole array ), min value = 10 ( largest value in
 * the array )
 * 
 * [ 10,32 ] apply bineart search search over here
 * mid = (10+32)/2 = 21 ( try to split the array with 21 as the max sum)
 * then we got [ 7,2,5 ], [ 10,8] ( no of parts = 2)
 * 
 * check1: if( parts <= k ) : end = mid ;
 * 
 * Again find new mid : ( 10+ 21 )/2 = 15 ( try to split the array with 15 as
 * the max sum)
 * then we got [ 7,2,5 ], [ 10 ] ,[ 8 ] ( no of parts = 3)
 * 
 * check2: if( parts > k ) : start = mid+1 ;
 * 
 * Repeat the above steps until start == end
 * the start value is the final answer. so, my ans is 18
 */
