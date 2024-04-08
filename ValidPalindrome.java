class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        char[] chars = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();

        if (chars.length == 0) {
            return true;
        }

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}