import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;



class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        pQueue.addAll(map.values());

        int time = 0;
        List<Integer> temp;

        while (!pQueue.isEmpty()) {
            temp = new ArrayList<>();
            for (int i = 0; i < n+1; i++) {
                if (!pQueue.isEmpty()) {
                    temp.add(pQueue.poll());
                }
            }

            for (int count : temp) {
                if (--count > 0) {
                    pQueue.add(count);
                }
            }

            time += pQueue.isEmpty() ? temp.size() : n+1;
        }
        return time;
    }
}