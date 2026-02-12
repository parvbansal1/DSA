class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int arr[] = new int[26];
        int max = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr, 0);
            for (int j = i; j < n; j++) {
                int ch = s.charAt(j) - 'a';
                arr[ch]++;
                boolean equal = true;
                for (int a : arr) {
                    if (a > 0 && a != arr[ch]) {
                        equal = false;
                        break;
                    }
                }
                if (equal) max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}
