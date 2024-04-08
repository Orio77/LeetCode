import java.util.Comparator;
import java.util.PriorityQueue;

class MinStack {
    int[] stack;
    private int index;
    private PriorityQueue<Integer> pQueue;

    public MinStack() {
        stack = new int[20];
        index = 0;
        pQueue = new PriorityQueue<>(Comparator.naturalOrder());
    }
    
    public void push(int val) {
        stack[index++] = val;
        pQueue.add(val);
    }
    
    public void pop() {
        if (index == 0) 
            return;
        
        pQueue.remove(stack[index-1]);
        stack[--index] = 0;
    }
    
    public int top() {
        if (index == 0) 
            return 0;
        
        return stack[index-1];
    }
    
    public int getMin() {
        if (pQueue.isEmpty()) 
            return 0;

        return pQueue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */