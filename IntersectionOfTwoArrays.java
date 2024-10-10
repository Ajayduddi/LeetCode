import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1, 2 };
        int[] nums2 = { 2, 2, 1 };
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
    
    static public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                if (!arr.contains(nums1[i])){
                    arr.add(nums1[i]);
                    i++;
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }

        int[] num = new int[arr.size()];
        for(int k=0; k<arr.size(); k++){
            num[k] = arr.get(k);
        }

        return num;
    }
}
