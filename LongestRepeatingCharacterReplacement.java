import java.util.ArrayList;
import java.util.List;

class Solution {
    public int incorrectCharacterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = i;
        int max = 0;
        int currentMax;
        List<Character> list1;
        List<Character> list2;

        while (i < chars.length && j < chars.length) {
            j = i;
            currentMax = 0;
            list1 = new ArrayList<>();
            list2 = new ArrayList<>();
            while ((list1.size() <= k || list2.size() <= k) && j < chars.length) {
                // co jesli listy sa puste
                if (list1.isEmpty()) {
                    list1.add(chars[j]);
                    currentMax++;
                    j++;
                    if (currentMax > max) {
                        max = currentMax;
                    }
                    continue;
                }
                else if (list2.isEmpty() && chars[j] != list1.get(0) && list2.size()+1 <= k) {
                    list2.add(chars[j]);
                    currentMax++;
                    j++;
                    if (currentMax > max) {
                        max = currentMax;
                    }
                    continue;
                }
                
                // dodajemy element do list1 jesli tam pasuje
                if (chars[j] == list1.get(0) && (list2.size() <= k || list1.size()+1 <= k)) {
                    list1.add(chars[j]);
                    currentMax++;
                }
                else if (list2.isEmpty() && 1 > k) {
                    break;
                }
                else if (chars[j] == list2.get(0) && (list2.size()+1 <= k || list1.size() <= k)) {
                        list2.add(chars[j]);
                        currentMax++;
                    if (currentMax > max) {
                        max = currentMax;
                    }
                }
                else {
                    if (currentMax > max) {
                        max = currentMax;
                    }
                    break;
                }
                if (currentMax > max) {
                    max = currentMax;
                }
                j++;
            }
            i++;
        }
        return max;
    }


    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int start = 0;
        int end = 0;
        int tempmax = 0;
        int max = 0;
        int length = s.length();

        while (end < length) {
            tempmax = Math.max(tempmax, ++charCount[s.charAt(end) - 'A']);

            while (end - start + 1 - tempmax - k > 0) {
                charCount[s.charAt(start) - 'A']--;
                start++;
            }

            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }

}