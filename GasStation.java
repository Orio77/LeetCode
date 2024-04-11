
class MySolution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1 && cost.length == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }
        
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] > gas[i]) {
                continue;
            }
            int tank = 0;
            int startIndex = i;
            tank += gas[startIndex];
            int index = startIndex+1;

            while (index != startIndex) {
                if (index == cost.length) {
                    index = 0;
                    if (index == startIndex) {
                        break;
                    }
                }
                
                if (index == 0) {
                    tank -= cost[cost.length-1];
                }
                else
                    tank -= cost[index-1];

                if (tank < 0) {
                    break;
                }

                tank += gas[index];

                if (tank <= 0) {
                    break;
                }
                index++;
            }

            if (startIndex == 0) {
                if (index == startIndex && tank >= 0 && tank - cost[cost.length-1] >= 0) {
                    return startIndex;
                }
            }
            else {
                if (index == startIndex && tank >= 0 && tank - cost[startIndex-1] >= 0) {
                    return startIndex;
                }
            }
        }
        return -1;
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int result = 0;
        int total = 0;

        for (int i = 0; i < cost.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum < costSum) {
            return -1;
        }

        for (int i = 0; i < cost.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                result = i+1;
            }
        }
        return result;
    }
}