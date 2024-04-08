import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public String encode(List<String> strs) {
        return strs.stream().collect(Collectors.joining(":;"));
    }

    public List<String> decode(String s) {
        return Arrays.asList(s.split(":;"));
    }
}