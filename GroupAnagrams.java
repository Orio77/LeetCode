import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();

        char[] letters = null;
        for (String string : strs) {
            letters = string.toCharArray();
            Arrays.sort(letters);
            String str = new String(letters);
            if (map.containsKey(str)) {
                map.get(str).add(string);
            }
            else {
                map.put(str, new ArrayList<>());
                map.get(str).add(string);
            }
        }
        return map.values().stream().toList();
    }
}