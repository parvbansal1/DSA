class Solution {
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int count = 0 ;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int a = nums[i];
                int b = nums[j];
                while (a >= 10) a = a / 10;
                while (b >= 10) b = b % 10;
                if(gcd(a,b)==1) count++;
            }
        }
        return count;
    }
}