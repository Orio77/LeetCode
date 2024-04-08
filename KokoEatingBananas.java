import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; 
        int[] copy = Arrays.copyOf(piles, piles.length);
        Arrays.sort(copy);
        int right = copy[piles.length-1];

        while (left < right) {
            int k = (left + right) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += Math.ceil(pile/k);
            }
            if (hours <= h) {
                right = k;
            }
            else 
                left = k+1;
        }
        return left;
    }
}