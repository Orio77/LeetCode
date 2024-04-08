import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer num : stones) {
            pQueue.add(num);
        }

        while (pQueue.size() > 1) {
            int stone1 = pQueue.poll();
            int stone2 = pQueue.poll();

            if (stone1 != stone2) {
                pQueue.add(Math.abs(stone2 - stone1));
            }
        }
        return pQueue.isEmpty() ? 0 : pQueue.poll();
    }
}