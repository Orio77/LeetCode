import java.util.ArrayList;
import java.util.List;




class MySolution {
    @SuppressWarnings("unused")
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] result = new int[1][2];
            result[0] = newInterval;
            return result;
        }
        
        int i = 0, j = 1;
        int startIndex = -1;
        int[] startInterval = null;

        while (j < intervals.length) { // TODO what if intervals.length == 1?
            if (newInterval[0] > intervals[i][1] && newInterval[0] < intervals[j][0]) {
                startIndex = j;
                break;
            }

            if (newInterval[i] >= intervals[i][0] && newInterval[i] <= intervals[i][1]) {
                startInterval = intervals[i];
                break;
            }
        }

        int endIndex = -1;
        int[] endInterval = null;
        int k = j+1;

        if (startIndex > -1) {
            while (j < intervals.length) {
                if (newInterval[1] > intervals[j][1] && newInterval[1] < intervals[k][0]) {
                    endIndex = k;
                    break;
                }

                if (newInterval[1] >= intervals[j][0] && newInterval[1] <= intervals[j][1]) {
                    endInterval = intervals[j];
                }
            }
        }

        if (startIndex == -1) {
            startIndex = 0;
        }
        if (endIndex == -1) {
            endIndex = 0;
        }
        int[][] answer = new int[intervals.length - (startIndex - endIndex)][2];

        for (int m = 0; m < intervals.length; m++) {
            
        }

        return new int[0][]; // Added after I finished coding for half an hour
    }
}


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> answer = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean inserted = false;

        for (int[] intv : intervals) {
            int currStart = intv[0];
            int currEnd = intv[1];

            if (currEnd < start || inserted) {
                answer.add(new int[]{currStart, currEnd});
                continue;
            }

            start = Math.min(start, currStart);
            if (end < currStart) {
                answer.add(new int[]{start, end});
                answer.add(new int[]{currStart, currEnd});
                inserted = true;
                continue;
            }

            if (end <= currEnd) {
                answer.add(new int[]{start, currEnd});
                inserted = true;
            }
        }
        if (!inserted) {
            answer.add(new int[]{start, end});
        }

        return answer.toArray(new int[answer.size()][]);
    }
}