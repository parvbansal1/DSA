class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int count = 0;
        int carry = 0;
        for (int i = n - 1; i > 0; i--) {
            int ch = Character.getNumericValue(s.charAt(i)) + carry;
            if (ch % 2 == 1) {
                count += 2;
                carry = 1;
            } else {
                count++;
            }
        }
        return count + carry;
    }
}