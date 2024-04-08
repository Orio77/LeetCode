import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int currMax = 0;
        int newSequenceIndex = 0;
        Set<Character> set = new LinkedHashSet<>();
        char[] chars = s.toCharArray();

        for (int index = 0; index < chars.length; index++) {
            char c = chars[index];
            if (!set.contains(c)) {
                set.add(c);
                currMax++;
            }
            else {
                index = s.indexOf(c, newSequenceIndex);
                set = new HashSet<>();
                newSequenceIndex = index+1;
                if (currMax > max) {
                    max = currMax;
                }
                currMax = 0;
            }
        }
        
        return Math.max(max, currMax);
    }
}