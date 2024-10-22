// https://leetcode.com/problems/insert-interval/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 6, 9 }, { 10, 15 } };
        int[] newInterval = { 4, 8 };
        int[][] result = insert(intervals, newInterval);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] arr = new int[intervals.length + 1][2];
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                arr[i][0] = intervals[i][0];
                arr[i][1] = intervals[i][1];
            } else {
                arr[i][0] = newInterval[0];
                arr[i][1] = newInterval[1]; 
            }
        }

        sorting(arr);

        // merge overlapings
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(arr[0][0], arr[0][1]));
        for(int i=1; i < arr.length; i++){
            int size = list.size();
            int start = list.get(size - 1).get(0);
            int end = list.get(size - 1).get(1);
            if(end >= arr[i][0]){
                if(end < arr[i][1]){
                    list.remove(size-1);
                    list.add(Arrays.asList(start,arr[i][1]));
                }
            }else{
                list.add(Arrays.asList(arr[i][0],arr[i][1]));
            }
        }

        // converting into array
        arr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }

        return arr;
    }

    static public void sorting(int[][] intervals){
        Arrays.sort(intervals,(i1,i2) -> Integer.compare(i1[0],i2[0]));
    }
}
