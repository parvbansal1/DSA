class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int k = 0;
        for (char a : order.toCharArray())
            hm.put(a, k++);

        for (int i = 0; i < words.length - 1; i++) {
            String s = words[i];
            String t = words[i + 1];
            int j = 0;
            int min = Math.min(s.length(), t.length());
            while (j < min && s.charAt(j) == t.charAt(j)) {
                j++;
            }

            if (j == min && s.length() > t.length()) return false;

            if (j < min && hm.get(s.charAt(j)) > hm.get(t.charAt(j)))
                return false;

        }
        return true;
    }
}