import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

class MyKthLargest {
    private int[] nums;
    private int k;

    public MyKthLargest(int k, int[] nums) {
        this.nums = nums;
        this.k = k;
    }
    
    public int add(int val) {
        IntStream stream = Arrays.stream(nums);
        nums = IntStream.concat(stream, IntStream.of(val)).toArray();
        return Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).limit(k).min(Integer::compare).orElse(0);
    }
}

class KthLargest {
    private PriorityQueue<Integer> heap =  new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */