import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    static public void moveZeroes(int[] nums) {
        int i = 0, j = 1;

        // twopointers
        while (i < j && j < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
                j = i + 1;
            }
            if (i < nums.length && j<nums.length && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                j++;
            }
        }
    }
}
