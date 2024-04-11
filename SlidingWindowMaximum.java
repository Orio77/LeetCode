import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {
    
}



class MySolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int i = 0;
        int j = k;
        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> res = new ArrayList<>();

        for (int l = 0; l < k; l++) {
            heap.add(nums[l]);
        }
        res.add(heap.peek());

        while (j < nums.length) {
            heap.remove(nums[i]);
            heap.add(nums[j]);
            res.add(heap.peek());
            i++; j++;
        }
        int length = res.size();
        int[] ans = new int[length];
        Iterator<Integer> iterator = res.iterator();
        for (int l = 0; l < length; l++) {
            ans[l] = iterator.next();
        }
        return ans;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (deque.size() > 0 && deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }

            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }

        }
        return result;
    }
}