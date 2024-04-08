import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, 0, 0, "", n);
        return result;
    }

    public void backtrack(List<String> result, int openN, int closedN, String str, int n) {
        if (str.length() == n*2) {
            result.add(str);
            return;
        }

        if (openN < n) {
            backtrack(result, openN+1, closedN, str + "(", n);
        }

        if (closedN < openN) {
            backtrack(result, openN, closedN+1, str + ")", n);
        }
    }
}