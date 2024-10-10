import java.util.Arrays;

public class SetMisMatch {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 4 };
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
    
    static public int[] findErrorNums(int[] nums) {
        int i=0;

        // cyclic sort
        while(i<nums.length){
            int correct = nums[i] -1;
            if(nums[i] == nums[correct]){
                i++;
            }
            else{
                int temp = nums[i];
                nums[i]  = nums[correct];
                nums[correct] = temp;
            }
        }

        // find duplicate and missing value
        for(int j=0; j<nums.length; j++){
            if(nums[j] != j+1){
                return new int[] {nums[j],j+1};
            }
        }
    
    return new int[] {-1,-1};
    }
}
