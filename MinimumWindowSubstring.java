import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String minWindowMyApproach(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (tLength > sLength || tLength == 0) {
            return "";
        }
        // Create 3 pointers
        int one = 0;
        int two = 0;
        int three = 0;
        // Create the shortest sequence variable
        int shortest = Integer.MAX_VALUE;
        int savedOne = 0;
        int savedThree = 0;
        // Create the chars arrays
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray(); 
        // Create set for t chars
        Set<Character> tCharsSet = new HashSet<>();
        for (int i = 0; i < tChars.length; i++) {
            tCharsSet.add(tChars[i]);
        }
        // Start looking for the sequence in a while loop
        while (three < sLength) {
            one = two;
            two = three;
            three++;
            if (three == sLength) {
                return s.substring(savedOne, savedThree);
            }
            
            while (one < sLength) {
                if (!tCharsSet.contains(sChars[one])) {
                    one++;
                }
            }
            if (!tCharsSet.isEmpty() && tCharsSet.contains(sChars[one])) {
                tCharsSet.remove(sChars[one]);
                two = one;
            }

            while (two < sLength) {
                if (!tCharsSet.contains(sChars[two])) {
                    two++;
                }
            }
            if (!tCharsSet.isEmpty() && tCharsSet.contains(sChars[two])) {
                tCharsSet.remove(sChars[two]);
                three = two;
            }

            while (tCharsSet.isEmpty() && three < sLength) {
                if (tCharsSet.contains(sChars[three])) {
                    tCharsSet.remove(sChars[three]);
                }
            }
            if (!tCharsSet.isEmpty()) {
                return "";
            }
            
            if (three - one < shortest) {
                savedOne = one;
                savedThree = three;
            }
        }
        // return shortest
        return s.substring(savedOne, savedThree);
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return new String();
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();
        int start = 0;
        int end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;

        while (end <s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    counter --;
                }
            }

            end++;
            while (counter == 0) {
                char tempc = s.charAt(start);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - start < len) {
                    len = end - start;
                    head = start;
                }
                start++;
            }
        }
        if (len == Integer.MAX_VALUE) {
            return new String();
        }
        return s.substring(head, head + len);
    }
}