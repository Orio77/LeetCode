import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k > nums.length) {
            return nums;
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            }
            else
                frequencyMap.put(num, 1);
        }

        List<Integer> list = frequencyMap.entrySet().stream().sorted(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed()).limit(k).map(Map.Entry<Integer, Integer>::getKey).toList();
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}