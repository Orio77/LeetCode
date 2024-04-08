class Solution {
    @SuppressWarnings("unused")
    public int carFleetMyAttempt(int target, int[] position, int[] speed) { // Failed because the overtake might happen anywhere on the track, not just to the fastest car at a given moment

        // Create a fleet int equal to position.length
        int fleet = position.length;
        // Create a pointer
        int i = 0;
        // Create furthest position variable and save the index of a car
        int furthestPosition = 0;
        for (int j = 0; j < position.length; j++) {
            if (position[j] > furthestPosition) 
                furthestPosition = position[j];
        }
        // Create a while loop
        while (true) {
            for (int j = 0; j < position.length; j++) {
                position[j] += speed[j];
                if (position[j] >= furthestPosition) {
                    
                }
            }
        }

        // In each iteraton update the positions by speed

        // If the furthest position changes, decrement the fleet variable;

        // Update the car at position of pointer, make it the position of a saved car, and at saved car's position, and change their speed to 1
        
        // Do the above untill all cars reach the finish line
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int fleet = 0;
        double[] timeArray = new double[target];
        for (int i = 0; i < position.length; i++) {
            timeArray[position[i]] = (double) (target - position[i]) / speed[i];
        }
        double prev = 0.0;
        for (int i = target-1; i >= 0 ; i--) {
            double curr = timeArray[i];
            if (curr > prev) {
                prev = curr;
                fleet++;
            }
        }
        return fleet;
    }
}