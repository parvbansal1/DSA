class Solution {
    public int concatenatedBinary(int n) {
        final int mod = 1000000007;
        long ans = 0;

        for (int i = 1; i <= n; ++i)
            ans = ((ans << bits(i)) % mod + i) % mod;

        return (int) ans;
    }

    private int bits(int n) {
        return (int) (Math.log(n) / Math.log(2)) + 1;
    }
}