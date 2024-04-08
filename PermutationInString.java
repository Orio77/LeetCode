class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] freq = new int[26];
        for(int i = 0; i < s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s2.length(); i++){
            freq[s2.charAt(i) - 'a']--;
            if(i - s1.length() >= 0){
                freq[s2.charAt(i - s1.length()) - 'a']++;
            }
            if(allZeros(freq)){
                return true;
            }
        }
        return false;
    }
    private boolean allZeros(int[] f){
        for(int i = 0; i < 26; i++){
            if(f[i] != 0){
                return false;
            }
        }
        return true;
    }
}