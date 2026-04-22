class Solution {
    public List<String> twoEditWords(String[] queries, String[] arr) {
        int n = queries.length;
        int m = queries[0].length();
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = queries[i];

            for (int j = 0; j < arr.length; j++) {
                String t = arr[j];
                int min = 0;
                for (int k = 0; k < m; k++) {
                    if (s.charAt(k) != t.charAt(k)) min++;
                    if(min > 2) break;
                }
                if (min <= 2) {
                    ans.add(s);
                    break;
                }
            }
        }
        return ans;
    }
}