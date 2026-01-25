class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int buy = -arr[0];
        int sell = 0;
        int prevSell = 0;
        for (int i = 1; i < n; i++) {
            int temp = sell;
            buy = Math.max(buy, prevSell - arr[i]);
            sell = Math.max(sell, arr[i] + buy);

            prevSell = temp;            
        }
        return sell;
    }
}