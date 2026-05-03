class Solution {
    public int sumOfPrimesInRange(int n) {
        if(n <= 1) return 0;
        String s = String.valueOf(n);
        StringBuilder str = new StringBuilder(s);
        int m = Integer.parseInt(str.reverse().toString());
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        return find_sum(min, max);
    }

    public int find_sum(int n, int m) {
        int sum = 0;
        if(n <= 2) sum += 2;
        for (int i = n; i <= m; i++) {
            for (int j = 2; j < i; j++) {
                if(i%j == 0) break;
                if(j == i-1) sum += i;
            }
        }
        return sum;
    }
}