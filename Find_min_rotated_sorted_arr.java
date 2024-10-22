/**
 * Find_min_rotated_sorted_arr
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:
 * [4,5,6,7,0,1,4] if it was rotated 4 times
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 * 
 * Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 * 
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 */
public class Find_min_rotated_sorted_arr {

    public static void main(String[] args) {
        int[] arr = { 3, 1, 3, 3, 3, 3, 3 };
        System.out.println(findMin(arr));
    }
    
    static public int findMin(int[] nums) {
        return binearySearch(nums, 0, nums.length - 1);
    }

    static public int binearySearch(int[] arr, int start, int end){
        // base condition
        if(end - start == 1){
            return Math.min(arr[end],arr[start]);
        }

        while (start < end){
            int mid = start + (end - start)/2;

            if(arr[mid] > arr[mid+1] ){
                return arr[mid+1];
            }
            else if(arr[mid] < arr[end]){
                end = mid;
            }
            // this is unconditional deciding state so, we check both half
            else if(arr[mid] == arr[end]){
                return Math.min(binearySearch(arr,mid+1,end),binearySearch(arr,start,mid));
            }
            else{
                start = mid + 1;
            }
        }

        return arr[start];

    }
}