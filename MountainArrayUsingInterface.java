// Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
// You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

// MountainArray.get(k) returns the element of the array at index k (0-indexed).
// MountainArray.length() returns the length of the array.

// https://leetcode.com/problems/find-in-mountain-array/

interface MountainArrayI {
    int length();
    int get(int index);
}

public class MountainArrayUsingInterface implements MountainArrayI {
    int[] arr;

    public MountainArrayUsingInterface(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int length() {
        return arr.length;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    public static void main(String[] args) {
        int[] arr = { 1,5,2};
        MountainArrayI mountainArr = new MountainArrayUsingInterface(arr);

        System.out.println(findInMountainArray(2, mountainArr));
    }
    
    static int findInMountainArray(int target, MountainArrayI mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        int ans = -1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int element = mountainArr.get(mid);
            if (element > mountainArr.get(mid + 1))
                end = mid;
            else
                start = mid + 1;
        }

        int peak = start;
        ans = binarySearch(mountainArr, target, 0, peak, true);
        if (ans == -1) {
            ans = binarySearch(mountainArr, target, peak, mountainArr.length() - 1, false);
        }

        return ans;
    }
    
    static int binarySearch(MountainArrayI mountainArr, int target,int start, int end,boolean Assescending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int element = mountainArr.get(mid);

            if (element == target) {
                return mid;
            } else if (element > target) {
                if (Assescending) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (Assescending) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        return -1;
    }
}

