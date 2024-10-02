// Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
// The tests are generated such that there is exactly one solution. You may not use the same element twice.

// slove using two pointers, bineary search
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

import java.util.Arrays;

public class TwoSum167 {
    public static void main(String[] args) {
        int[] numbers = { 1,2,3,4,4,9,56,90 };
        int target = 8;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
    
    static public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int ans = -1;

        while(ans == -1){
            int start = index1;
            int end = numbers.length -1;

            while(start<=end){
                int mid = start+(end-start)/2;
                int sum = numbers[index1]+numbers[mid];

                if(sum==target && index1 !=mid ) {
                    ans = 1;
                    return new int[] {index1+1,mid+1};
                }
                else if(sum>target) end = mid-1;
                else start = mid+1;
            }

            index1++;
        }

        return new int[] {-1,-1};
    }
}


/*
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 */