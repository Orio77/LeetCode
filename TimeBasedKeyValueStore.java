import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

class TimeMap {
    private Map<String, String> map;
    private Map<String, PriorityQueue<Integer>> timestamps;

    public TimeMap() {
        map = new HashMap<>();
        timestamps = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.put(key + "at timestamp: " + timestamp, value);
        if (!timestamps.containsKey(key)) {
            timestamps.put(key, new PriorityQueue<>(Comparator.reverseOrder()));
            timestamps.get(key).add(timestamp);
        }
        else if (timestamps.containsKey(key)) {
            timestamps.get(key).add(timestamp);
        }
    }
    
    public String get(String key, int timestamp) {
        String actualKey = key + "at timestamp: " + timestamp;
        if (map.containsKey(actualKey)) {
            return map.get(actualKey);
        }  
        else {
            if (timestamps.get(key) == null) {
                return new String();
            }
            Iterator<Integer> iterator = timestamps.get(key).iterator();
            int next = -1;
            int curr = -1;
            while (iterator.hasNext()) {
                curr = iterator.next();
                if (curr < timestamp) {
                    next = curr;
                    return map.get(key + "at timestamp: " + next);
                }
            }
            if (next == -1) {
                return new String();
            }
            return map.get(key + "at timestamp: " + next);
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */