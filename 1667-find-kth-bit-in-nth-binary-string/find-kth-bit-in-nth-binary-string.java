class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        String[] arr = new String[n];
        arr[0] = "0";

        for (int i = 1; i < n; i++) {
            StringBuilder str = new StringBuilder(arr[i - 1]);
            str.append('1');
            str.append(new StringBuilder(invertBits(arr[i - 1])).reverse());
            arr[i] = str.toString();
        }

        return arr[n - 1].charAt(k - 1); 
    }

    public static String invertBits(String s) {
        StringBuilder inv = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            char org = s.charAt(i);
            char newCh = (org == '0') ? '1' : '0';
            inv.append(newCh);
        }

        return inv.toString();
    }
}