// You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
// Return the index of the peak element.
// Sove in O(logn)

// https://leetcode.com/problems/peak-index-in-a-mountain-array/
// https://leetcode.com/problems/find-peak-element/

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 1, 0 };

        System.out.println("Peak Element at index " + peakIndexInMountainArray(arr));
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1])
                // We are in desc part of the array
                // this may be the ans, but look at left part for confirmation
                // this is why end != mid-1;
                end = mid;
            else
                // We are in asc part of the array
                start = mid + 1; // because we know mid+1 element > mid element
        }

        // if start == end, points to the peak element
        return start;
    }
}

// Example 1:
// Input: arr = [0,1,0]
// Output: 1

// Example 2:
// Input: arr = [0,2,1,0]
// Output: 1

// Example 3:
// Input: arr = [0,10,5,2]
// Output: 1