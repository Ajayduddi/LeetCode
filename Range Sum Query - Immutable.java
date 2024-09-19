// Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
// using prefix sum pattern.

class NumArray {
    int[] prefixsum;
    public NumArray(int[] nums) {
        int n=nums.length;
        prefixsum = new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                prefixsum[i]=nums[i];
            }else{
                prefixsum[i]=prefixsum[i-1]+nums[i];
            }
        }
    }
    
    public int sumRange(int left, int right) {
        if(left>0){
            return prefixsum[right]-prefixsum[left-1];
        }
       return prefixsum[right];
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(1, 2));
        System.out.println(obj.sumRange(0, 4));
    }
}


// Time Complexity: O(n)
// output: -1,3,2