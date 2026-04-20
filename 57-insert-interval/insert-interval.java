class Solution {
    public int[][] insert(int[][] arr, int[] tmp) {
        int n = arr.length;
        int st = tmp[0], end = tmp[1];

        List<int[]> ans = new ArrayList<>();
        boolean added = false;
        for (int i = 0; i < n; i++) {
            int s = arr[i][0];
            int e = arr[i][1];
            if (e < st) {
                ans.add(new int[] { s, e });
            } else if (s > end) {
                if (!added) {
                    ans.add(new int[] { st, end });
                    added = true;
                }
                ans.add(new int[] { s, e });
            } else {
                st = Math.min(st, s);
                end = Math.max(end, e);
            }
        }
        if (!added) {
            ans.add(new int[] { st, end });
        }

        return ans.toArray(new int[ans.size()][]);
    }
}