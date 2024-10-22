import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } };
        int[][] result = merge(intervals);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static public int[][] merge(int[][] intervals) {
        int matrixSize = intervals.length;

        // sort the matrix
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        // merge intervals
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(intervals[0][0], intervals[0][1]));
        for (int i = 1; i < matrixSize; i++) {
            int size = list.size();
            int start = list.get(size - 1).get(0);
            int end = list.get(size - 1).get(1);
            if (end >= intervals[i][0]) {
                if (end >= intervals[i][1]) {
                    list.remove(size - 1);
                    list.add(Arrays.asList(start, end));
                } else {
                    list.remove(size - 1);
                    list.add(Arrays.asList(start, intervals[i][1]));
                }
            } else {
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
        }

        // converting into array
        intervals = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 2; j++) {
                intervals[i][j] = list.get(i).get(j);
            }
        }
        return intervals;
    }
}
