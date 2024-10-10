public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,4 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m+n];
        int k = 0,j=0,i=0;

        while(i<m && j<n){
            if(nums1[i]>nums2[j]){
                arr[k] = nums2[j];
                j++;
                k++;
            }
            else{
                arr[k] = nums1[i];
                i++;
                k++;
            }
        }

        //remaining elements
        while(i<m){
            arr[k] = nums1[i];
            i++;
            k++;
        }

        while(j<n){
            arr[k] = nums2[j];
            j++;
            k++;
        }


        double ans = ans(arr,0,arr.length-1);
        return ans;
    }

    static public double ans(int[] arr,int start, int end){
        if(end>=0){
            int mid = start+(end-start)/2;
            if(end%2 == 0){
                return arr[mid];
            }
            else {
                double value = (double)(arr[mid]+arr[mid+1])/2;
                return value;
            }
        }
        else{
            return -1;
        }
    }
}
