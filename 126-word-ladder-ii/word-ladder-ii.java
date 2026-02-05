class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) return ans;

        // Parent map: child -> list of parents
        Map<String, List<String>> parentMap = new HashMap<>();

        // Level map to store shortest distance
        Map<String, Integer> levelMap = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        levelMap.put(beginWord, 0);

        int wordLen = beginWord.length();

        // ---------- BFS ----------
        while (!q.isEmpty()) {
            String word = q.poll();
            int level = levelMap.get(word);

            char[] arr = word.toCharArray();

            for (int i = 0; i < wordLen; i++) {
                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String next = new String(arr);

                    if (!dict.contains(next)) continue;

                    // First time visit → set level & push queue
                    if (!levelMap.containsKey(next)) {
                        levelMap.put(next, level + 1);
                        q.add(next);
                        parentMap.put(next, new ArrayList<>());
                    }

                    // If this is shortest parent → record parent
                    if (levelMap.get(next) == level + 1) {
                        parentMap.get(next).add(word);
                    }
                }

                arr[i] = original;
            }
        }

        // If endWord never reached
        if (!levelMap.containsKey(endWord)) return ans;

        // ---------- DFS Backtracking ----------
        List<String> path = new ArrayList<>();
        dfs(endWord, beginWord, parentMap, path, ans);

        return ans;
    }

    private void dfs(String word, String beginWord,
                     Map<String, List<String>> parentMap,
                     List<String> path,
                     List<List<String>> ans) {

        path.add(word);

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
        } else {
            for (String parent : parentMap.get(word)) {
                dfs(parent, beginWord, parentMap, path, ans);
            }
        }

        path.remove(path.size() - 1);
    }
}