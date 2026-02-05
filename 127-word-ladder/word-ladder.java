class Solution {
    public class Pair {
        String word;
        int steps;
        public Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public int ladderLength(String begin, String end,
            List<String> arr) {
        if (!arr.contains(end)) return 0;
        HashSet<String> hs = new HashSet<>();
        for (String a : arr) hs.add(a);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(begin, 1));
        while (!q.isEmpty()) {
            Pair tmp = q.remove();
            String temp1 = tmp.word;
            int n = tmp.steps;
            if (temp1.equals(end)) return n;

            for (int i = 0; i < temp1.length(); i++) {
                char[] temp2 = temp1.toCharArray();
                char original = temp2[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    temp2[i] = ch;
                    String newWord = new String(temp2);
                    // If valid word exists in set
                      if (hs.contains(newWord)) {
                        q.add(new Pair(newWord, n + 1));
                        hs.remove(newWord);   // remove on push
                    }
                }
                temp2[i] = original;
            }
        }
        return 0;
    }
}