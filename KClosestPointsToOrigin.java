import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        Queue<int[]> pQueue = new PriorityQueue<>((a1, a2) -> (a1[0]*a1[0] + a1[1]*a1[1]) - (a2[0]*a2[0] + a2[1]*a2[1]));
        int[][] answer = new int[k][2];
        
        for (int[] point : points) {
            pQueue.add(point);
        }

        for (int i = 0; i < k; i++) {
            int[] point = pQueue.poll();
            answer[i][0] = point[0];
            answer[i][1] = point[1];
        }

        return answer;
    }
}