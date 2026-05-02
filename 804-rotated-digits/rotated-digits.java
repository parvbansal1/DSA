class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int num = i;
            boolean valid = false;
            boolean bad = false;
            while (num != 0) {
                int d = num % 10;
                if (d == 2 || d == 5 || d == 6 || d == 9)
                    valid = true;
                if (d == 3 || d == 4 || d == 7) {
                    bad = true;
                    break;
                }
                num = num / 10;
            }
            if (!bad && valid)
                ans++;
        }
        return ans;
    }
}