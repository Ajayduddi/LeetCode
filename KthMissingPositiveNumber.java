import java.util.ArrayList;

/**
 * KthMissingPositiveNumber
 * 
 * Given an array arr of positive integers sorted in a strictly increasing
 * order, and an integer k.
 * 
 * Return the kth positive integer that is missing from this array.
 * 
 * https://leetcode.com/problems/kth-missing-positive-number/
 * 
 */
public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11};
        int target = 5;

        System.out.println(findKthPositive2(arr, target));
    }

    // method 1
    static public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length -1;
        ArrayList<Integer> newa = new ArrayList(10);

        while(start<end){
            int mid = start+(end-start)/2;
            int no_missing = ( arr[mid] - 1 ) - mid;

            if(no_missing >= k){
                end = mid;
            }
            else start = mid+1;
        }

        int j = 0, i = 1;
        while(newa.size() <= k){
            if(j <= end && i==arr[j]){
                j++;
                i++;
            }else{
                newa.add(i);
                i++; 
            }
        }

        return newa.get(k-1);
    }

    // method 2

    static public int findKthPositive2(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int no_missing = (arr[mid] - 1) - mid;

            if (no_missing >= k) {
                end = mid - 1;
            } else
                start = mid + 1;
        }

        return start + k;
    }
}

/*
 * array = [3,4,9,10,12,13] , k=4
 * 
 * If no element was missing, indices of numbers would've been 1 less than the number.
 * [1,2,3,4,5,6,7,8,9,10,11,12,13]. Here, index of 1 is 0, of 2 is 1, of 3 is 2 and so on.
 * 
 * We can calculate total missing values to the left of any number in O(1) by subtracting its index in the array from index it would have in the array with
 * no missing numbers. Obviously the difference is equal to the total missingnumbers. 
 * 
 * For. eg,  4 has 2 missing numbers to its left in the example array [1,2]. Calculation : (4-1) - 1 = 2
 *           9 has 6 missing numbers to its left [1,2,5,6,7,8]. Calculation (9-1) - 2 = 6
 * 
 * 
 *  ( number - 1 ) - no.of elements present in left to that numbers in the array = no.of missing values.
 */