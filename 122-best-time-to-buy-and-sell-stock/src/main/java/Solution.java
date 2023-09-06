class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int position = 0;

        while (position < prices.length) {
            int bottomPosition = findNextBottomPosition(position, prices);
            int peakPosition = findNextPeakPosition(bottomPosition, prices);
            if (bottomPosition == peakPosition) {
                break;
            } else {
                maxProfit += prices[peakPosition] - prices[bottomPosition];
                position = peakPosition;
            }
        }
        return maxProfit;
    }


    private int findNextBottomPosition(int from, int[] prices) {
        int bottomPosition = from;
        int bottomValue = prices[from];

        for (int i = from + 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            if (currentPrice > bottomValue) {
                break;
            } else {
                bottomPosition = i;
                bottomValue = currentPrice;
            }
        }
        return bottomPosition;
    }

    private int findNextPeakPosition(int from, int[] prices) {
        int peakPosition = from;
        int peakValue = prices[from];

        for (int i = from + 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            if (currentPrice < peakValue) {
                break;
            } else {
                peakPosition = i;
                peakValue = currentPrice;
            }
        }
        return peakPosition;
    }
}