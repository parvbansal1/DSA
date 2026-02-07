class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        int b = 0, a = 0;

        for (int i = 0; i < n; i++) {
            arr1[i] = b;
            if (s.charAt(i) == 'b')
                b++;
        }

        for (int i = n - 1; i >= 0; i--) {
            arr2[i] = a;
            if (s.charAt(i) == 'a')
                a++;
        }
        int min = n;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr2[i] + arr1[i]);
        }
        return min;
    }
}