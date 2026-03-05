class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int min = 0;
        // int arr[] = new int[n];
        // int arr2[] = new int[n];
        // for(int i=0;i<n;i+=2) arr[i] = 1;
        // for(int i=1;i<n;i+=2) arr2[i] = 1;

        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) != '0') count1++;
            } else {
                if (s.charAt(i) != '1') count1++;
            }
        }

        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) != '1') count2++;
            } else {
                if (s.charAt(i) != '0') count2++;
            }
        }

        min = Math.min(count2, count1);
        return min;

    }
}