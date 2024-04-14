import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class MergeIntervals {
    
}




class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
        
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        int[] interval1;
        int[] interval2;
        int a;
        int b;
        int c;
        int d;
        
        for (int i = 1; i < intervals.length; i++) {
            interval1 = stack.peek();
            interval2 = intervals[i];
            a = interval1[0];
            b = interval1[1];
            c = interval2[0];
            d = interval2[1];

            // Merge and continue
            if (c >= a && c <= b && d > b) {
                stack.pop();
                stack.push(merge(a, b, c, d, true));
                continue;
            }
            else if (c >= a && c <= b && d <= b) {
                stack.pop();
                stack.push(merge(a, b, c, d, false));
                continue;
            }

            // or simply add
            stack.push(interval2);
        }

        Iterator<int[]> iterator = stack.iterator();
        int[][] answer = new int[stack.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = iterator.next();
        }
        return answer;
    }

    private int[] merge(int a, int b, int c, int d, boolean firstCase) {

        // first case
        if (firstCase) {
            return new int[]{a, d};
        }
        else {
            return new int[]{a, b};
        }
    }
}