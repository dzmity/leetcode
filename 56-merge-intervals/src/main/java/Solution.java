import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        return mergeOverlappingIntervals(intervals);
    }

    private int[][] mergeOverlappingIntervals(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();

        int startOfInterval = intervals[0][0];
        int endOfInterval = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (endOfInterval >= currentInterval[0]) {
                endOfInterval = Math.max(endOfInterval, currentInterval[1]);
            } else {
                mergedIntervals.add(new int[]{startOfInterval, endOfInterval});
                startOfInterval = intervals[i][0];
                endOfInterval = intervals[i][1];
            }

            if (i == intervals.length - 1) {
                mergedIntervals.add(new int[]{startOfInterval, endOfInterval});
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}