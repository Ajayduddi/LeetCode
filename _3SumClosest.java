import java.util.Arrays;

/**
 * _3SumClosest
 * https://leetcode.com/problems/3sum-closest/description/
 */
public class _3SumClosest {

    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        int target = -2;
        System.out.println(threeSumClosest(nums, target));
    }
    
    static public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            int j = i+1,k = nums.length - 1;

            while( j < k ){
                int temp = ( nums[i] + nums[j] + nums[k] ); 
                if (temp == target) {
                    return temp;
                }
                else if(Math.abs(temp - target) < diff){
                    diff = Math.abs(temp - target);
                    sum = temp;
                }

                if (temp > target) {
                    k--;
                }
                else{
                    j++;
                }
            }
        }

        return sum;
    }
}