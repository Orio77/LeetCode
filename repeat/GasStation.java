package repeat;

public class GasStation {
    public int canCircle(int[] gas, int[] cost) {

        int gasSum = 0;
        int costSum = 0;
        int tank = 0;
        int index = 0;

        // Add gas and costs
        for (int i = 0; i < cost.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (costSum > gasSum) {
            return -1;
        }

        for (int i = 0; i < cost.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                index = i+1;
                tank = 0;
            }
        }
        return index;
    }
}
