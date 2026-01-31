class Solution {
    public char nextGreatestLetter(char[] arr, char x) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= x) l = mid + 1;
            else r = mid - 1;
        }
        return arr[l % n];
    }
}