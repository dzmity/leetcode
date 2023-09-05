class Solution {
    // O(N^2) time solution
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int spread = prices[j] - prices[i];
                if (spread > maxProfit) {
                    maxProfit = spread;
                }
            }
        }
        return maxProfit;
    }

    // O(N^2) time solution
    public int maxProfitBestSolution(int[] prices) {
        int minStockPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];
            int currentProfit = currentPrice - minStockPrice;

            if (currentPrice < minStockPrice) {
                minStockPrice = currentPrice;
            }

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }
}