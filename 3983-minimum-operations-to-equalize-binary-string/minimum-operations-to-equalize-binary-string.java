class Solution {

    public int minOperations(String s, int k) {
        int n = s.length();
        int zero = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zero++;
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        TreeSet<Integer> even = new TreeSet<>();
        TreeSet<Integer> odd = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) even.add(i);
            else odd.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(zero);
        dist[zero] = 0;

        // remove start from its set
        if (zero % 2 == 0) even.remove(zero);
        else odd.remove(zero);

        while (!queue.isEmpty()) {

            int cur = queue.poll();
            if (cur == 0) return dist[cur];

            // calculate possible next range
            int minFlip = Math.max(0, k - (n - cur));
            int maxFlip = Math.min(k, cur);

            int L = cur + k - 2 * maxFlip;
            int R = cur + k - 2 * minFlip;

            // choose correct parity set
            TreeSet<Integer> set = (L % 2 == 0) ? even : odd;

            Integer next = set.ceiling(L);

            while (next != null && next <= R) {
                dist[next] = dist[cur] + 1;
                queue.add(next);
                set.remove(next);
                next = set.ceiling(L);   // safe because removed
            }
        }

        return -1;
    }
}