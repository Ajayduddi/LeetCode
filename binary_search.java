/**
 * Perfom Binary search on infinite sorted array
 * Time complexity: O(logn)
 * 
 * In normal binary search, we search for a value in a sorted array by dividing the array into two halves. ( divide by 2)
 * for infinte sorted arrray we follow the process in reverse order. 
 * Means first we take single element compare with the target value. if not found multiply the search space by 2 and selectthe next chunck repeat the process. ( multply with 2)
 */
public class binary_search {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20, 30, 31, 33, 55 };
        int target = 100 ;
        
        int ans = binarySearch(arr, target);
        if (ans == -1) {
            System.out.println("Not found");
        }
        else {
            System.out.println("Found at " + ans);
        }
    }
    
    static int binarySearch(int[] arr, int target) {
        int start=0, end = 1;
        int ans = -1;

        ans = search(arr, target, start, end);

        while (ans == -1) {
            int size = (end - start) + 1;
            start = end + 1;
            end = end + (size * 2);
            ans = search(arr, target, start, end);
        }

        if(ans == -2) ans = -1;
    
        return ans;
    }
    
    static int search(int[] arr, int target, int start, int end) {
        try {
            while (start <= end) {
                int mid = start + (end - start) / 2;
    
                if (arr[mid] > target)
                    end = mid - 1;
                else if (arr[mid] < target)
                    start = mid + 1;
                else
                    return mid;
            }
        } catch (Exception e) {
            return -2;
        }
        
        return -1;
    }
}