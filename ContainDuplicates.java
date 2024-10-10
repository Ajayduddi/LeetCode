import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainDuplicates {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 2, 6, 7, 8, 9, 10 };
        System.out.println(containsDuplicate3(nums));
    }

    static public boolean containsDuplicate(int[] nums) {
        // Solved using HashMap
        Map<Integer, Boolean> arr = new HashMap<>();

        // check the array contains duplicates or not
        for (int j = 0; j < nums.length; j++) {
            if (arr.containsKey(nums[j])) {
                return true;
            }
            arr.put(nums[j], true);
        }

        return false;
    }

    static public boolean containsDuplicate2(int[] nums) {

        // apply sorting
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));

        // find duplicate
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                return true;
            }
        }
        return false;
    }
    
    static public boolean containsDuplicate3(int[] nums) {
        HashSet<Integer> arr = new HashSet<>();

        // find duplicate
        for (int j = 0; j < nums.length; j++) {
            arr.add(nums[j]);
        }

        return arr.size() != nums.length ;
    }
}
