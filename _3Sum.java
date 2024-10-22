import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * _3Sum
 * 
 * https://leetcode.com/problems/3sum/description/
 */
public class _3Sum {

    public static void main(String[] args) {
        int[] nums = { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 };
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> set = new ArrayList<>();
        Map<List<Integer>,Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int target = -1 * nums[i];
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int result = nums[j] + nums[k];
                if (result == target) {
                    
                    if(!map.containsKey(Arrays.asList(nums[i],nums[j],nums[k]))){
                        set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        map.put(Arrays.asList(nums[i],nums[j],nums[k]),true);
                        j++;
                        k--;
                    }
                    else {
                        j++;
                        k--;
                    }
                }
                else if( result+(target * -1 ) > 0 ){
                    k--;
                }
                else{
                    j++;
                }

            }
        }

        return set;
    }
}

/*
 * Sort the given array in non-decreasing order.
 * Loop through the array from index 0 to n-1.
 * For each iteration, set the target as -nums[i].
 * Set two pointers, j=i+1 and k=n-1.
 * While j<k, check if nums[j]+nums[k]==target.
 * If yes, add the triplet {nums[i], nums[j], nums[k]} to the result and move j to the right and k to the left.
 * If no, move either j or k based on the comparison of nums[j]+nums[k] with target.
 * To avoid duplicate triplets, skip the iterations where nums[i]==nums[i-1] and
 * also skip the iterations where nums[j]==nums[j-1] or nums[k]==nums[k+1].
 */