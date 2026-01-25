class Solution {
    public int maxProfit(int[] arr, int fee) {
        int n = arr.length;
        int buy = -arr[0];
        int sell = 0;
        for (int i = 1; i < n; i++) {
            int prevBuy = buy;
            buy = Math.max(buy, sell - arr[i]);
            sell = Math.max(sell, arr[i] + prevBuy - fee);
        }
        return sell;
    }
}