class MySolution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        
        int water = 0;
        int localMax = 0;
        int savedWater = 0;
        int savedJ = 0;

        int i = 0, j = i+1;

        // How to calculate the breaks
        while (j < height.length) {
            localMax = 0;
            // 1. Find max 2. if the next is lower, search for elevation of ate least same size

            // Potential water container found
            if (height[i] > localMax) {
                localMax = height[i];
                savedWater = water;
                savedJ = j;

                // Water container found
                if (height[j] < localMax && j+1 < height.length) {
                    // Determine how big it is
                    j++;
                    while (height[j] < localMax && j < height.length-1) {
                        j++;
                    }

                    int newI = i;
                    i = helper(newI, j, localMax, height);

                    // Treat the terrain as if it were a pool
                    int waterContained = Math.min(height[i], height[j]) * (j-i-1);
                    i++;

                    // Take the terrain into account
                    while (i < j-1) {
                        waterContained -= height[i];
                        i++;
                    }
                    waterContained -= height[i];
                    water += waterContained;
                }
            }
            i++; j++;

            if (j == height.length && water < savedWater && savedJ < height.length-1) {
                j = savedJ+1;
                i = savedJ;
                water = savedWater;
            }
        }
        return water;
    }

    private int helper(int i, int j, int localMax, int[] height) {
        int savedI = i;
        while (i < j && height[i+1] < localMax && height[i+1] >= height[j]) {
            i++;
            localMax = height[i];
        }
        return i == j ? savedI : i;
    }
}

// instead of going back - check correctness - check if all of the elevation in between the local container are lower than the last one, if not, make the higher the found one



class Solution {
    public int trap(int[] h) {
        int l = 0;
        int r = h.length - 1;
        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;
        int answer = 0;

        while (l < r) {
            lMax = Math.max(lMax, h[l]);
            rMax = Math.max(rMax, h[r]);
            answer += (lMax < rMax) ? lMax - h[l] : rMax - h[r--];
        }
        return answer;
    }
}