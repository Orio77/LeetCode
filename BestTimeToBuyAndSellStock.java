class Solution {
    public int myMaxProfit(int[] prices) {
        if (prices == null) 
            return 0;

        int max = 0;
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int currDeal = prices[j] - prices[i];
                if (currDeal > max) {
                    max = currDeal;
                }
            }
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max = 0;

        while (right < prices.length) {
            if (prices[right] > prices[left]) {
                int currDeal = prices[right] - prices[left];
                if (currDeal > max) {
                    max = currDeal;
                }
            }
            else 
                left = right;
            right++;
        }
        return max;
    }
}