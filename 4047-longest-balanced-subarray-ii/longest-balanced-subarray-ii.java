class Solution {

    // ---------- Segment Tree ----------
    static class SegTree {
        int n;
        int[] min, max, lazy;

        SegTree(int[] arr) {
            n = arr.length;
            min = new int[4 * n];
            max = new int[4 * n];
            lazy = new int[4 * n];
            build(1, 0, n - 1, arr);
        }

        void build(int node, int l, int r, int[] arr) {
            if (l == r) {
                min[node] = max[node] = arr[l];
                return;
            }
            int mid = (l + r) / 2;
            build(node * 2, l, mid, arr);
            build(node * 2 + 1, mid + 1, r, arr);
            pull(node);
        }

        void pull(int node) {
            min[node] = Math.min(min[node * 2], min[node * 2 + 1]);
            max[node] = Math.max(max[node * 2], max[node * 2 + 1]);
        }

        void push(int node) {
            if (lazy[node] != 0) {
                apply(node * 2, lazy[node]);
                apply(node * 2 + 1, lazy[node]);
                lazy[node] = 0;
            }
        }

        void apply(int node, int val) {
            min[node] += val;
            max[node] += val;
            lazy[node] += val;
        }

        void rangeAdd(int L, int R, int val) {
            update(1, 0, n - 1, L, R, val);
        }

        void update(int node, int l, int r, int L, int R, int val) {
            if (r < L || l > R) return;
            if (L <= l && r <= R) {
                apply(node, val);
                return;
            }
            push(node);
            int mid = (l + r) / 2;
            update(node * 2, l, mid, L, R, val);
            update(node * 2 + 1, mid + 1, r, L, R, val);
            pull(node);
        }

        // find rightmost index >= L where prefixSum == 0
        int findLastZero(int L) {
            return query(1, 0, n - 1, L);
        }

        int query(int node, int l, int r, int L) {
            if (r < L || min[node] > 0 || max[node] < 0) return -1;
            if (l == r) return l;
            push(node);
            int mid = (l + r) / 2;
            int right = query(node * 2 + 1, mid + 1, r, L);
            if (right != -1) return right;
            return query(node * 2, l, mid, L);
        }
    }

    public int longestBalanced(int[] nums) {
        int n = nums.length;

        Map<Integer, Queue<Integer>> pos = new HashMap<>();
        int[] prefix = new int[n];

        prefix[0] = sign(nums[0]);
        pos.computeIfAbsent(nums[0], k -> new LinkedList<>()).add(0);

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            Queue<Integer> q = pos.computeIfAbsent(nums[i], k -> new LinkedList<>());
            if (q.isEmpty()) prefix[i] += sign(nums[i]);
            q.add(i);
        }

        SegTree st = new SegTree(prefix);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int r = st.findLastZero(i + ans);
            if (r != -1) ans = Math.max(ans, r - i + 1);

            Queue<Integer> q = pos.get(nums[i]);
            q.poll();
            int next = q.isEmpty() ? n : q.peek();
            st.rangeAdd(i, next - 1, -sign(nums[i]));
        }

        return ans;
    }

    private int sign(int x) {
        return (x & 1) == 0 ? 1 : -1;
    }
}
