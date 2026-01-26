class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int x = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int curr = Math.abs(arr[i + 1] - arr[i]);
            if (diff > curr) {
                diff = arr[i + 1] - arr[i];
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int curr = Math.abs(arr[i + 1] - arr[i]);
            if (diff == curr) {
                ans.add(new ArrayList<>());
                ans.get(x).add(arr[i]);
                ans.get(x).add(arr[i + 1]);
                x++;
            }
        }

        return ans;
    }
}