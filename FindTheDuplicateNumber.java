import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (Integer integer : nums) {
            if (!set.add(integer)) {
                return integer;
            }
        }
        return 0;
    }
}