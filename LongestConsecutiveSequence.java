import java.util.HashSet;
import java.util.Set;

// My take
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int longest = 0;
//         Map<Integer, ArrayList<Integer>> numMap = new HashMap<>();
//         Set<Integer> lookedForSet = new HashSet<>();

//         for (Integer num : nums) {
//             if (lookedForSet.contains(num)) {
//                 // Add to the hashmap
//                 // check if the list's length is greater than current longest

//                 lookedForSet.remove(num);
//             }
//             else {
//                 numMap.put(num, new ArrayList<>());
//                 numMap.get(num).add(num);
//             }
//             lookedForSet.add(num+1);
//             lookedForSet.add(num-1);
//         }
//     }
// }

// Nie moge sortowac
// Musze zalozyc ze kazda kolejna liczba jest wazna i o niej pamietac



// Correct Solution
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;

        for (Integer integer : nums) {
            set.add(integer);
        }

        for (Integer num : nums) {
            if (!set.contains(num-1)) {
                int length = 0;
                while (set.contains(num + length)) {
                    length+= 1;
                }
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}