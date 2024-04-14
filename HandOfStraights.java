import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class MySolution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int max = Arrays.stream(hand).max().getAsInt();
        int[] nums = new int[max+1];
        int handLength = hand.length;

        for (int i = 0; i < handLength; i++) {
            nums[hand[i]]++;
        }

        int i = 0;
        while (i < handLength) {
            int k = 0;
            while (k < groupSize) {
                if (i+k >= hand.length || nums[hand[i + k]]-- -1 < 0) {
                    return false;
                }
                k++;
            }
            i += k;
        }
        return true;
    }
}

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        Map<Integer, Long> map = Arrays.stream(hand).boxed().collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        Arrays.sort(hand);

        for (int i = 0; i < hand.length; i++) {
            if (map.get(hand[i]) == 0) {
                continue;
            }

            for (int j = 0; j < groupSize; j++) {
                int currCard = hand[i] + j;

                if (map.getOrDefault(currCard, 0L) == 0) {
                    return false;
                }

                map.put(currCard, map.get(currCard)-1);
            }
        }
        return true;
    }
}