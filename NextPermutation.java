// https://leetcode.com/problems/next-permutation/
import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = { 5, 4, 7, 5, 3, 2 };
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    // https://youtu.be/JDOXKqF60RQ?si=VZ6BxRTaGjXoKR5f
    static public void nextPermutation(int[] nums) {

        //find longest prefix from back side of the array
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // if no prfix found, then return the array in reverse order
        if (index == -1) {
            reverse(nums,0,nums.length-1);
            return;
        }

        // After finding the longest prefix, we need to find the next largest number in the array which is greater than array[index]
        // check the array in reverse order
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                // swap the array[index] with arr[i]
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        
        // reverse the array from index + 1 to the end
        reverse(nums, index + 1, nums.length - 1);
    }
    
    static public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
