import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    
    public static void main(String[] args) {
        List<List<Integer>> list = permuteUnique(new int[] { 1, 1,2 });
        System.out.println(list);
    }
    
    static public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,new ArrayList<>(),new boolean[nums.length],ans);
        return ans;
    }

    static public void helper(int[] nums, List<Integer> p, boolean[] arr, List<List<Integer>> ans){
        // base condition
        if(p.size() == nums.length){
            List<Integer> arr1 = new ArrayList<>();
            arr1.addAll(p);
            ans.add(arr1);
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!arr[i] ){
                if(i > 0 && nums[i] == nums[i-1] && !arr[i-1]){
                    continue;
                }
                arr[i] = true;
                p.add(nums[i]);
                helper(nums,p,arr,ans);
                // backtracking
                arr[i] = false;
                p.remove(p.size() - 1);
            }
        }
    }
}
