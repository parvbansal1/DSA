class Solution {
    public int openLock(String[] arr, String target) {
        HashSet<String> hs = new HashSet<>();
        for (String a : arr) hs.add(a);

        if (hs.contains("0000")) return -1;

        Queue<String> q = new LinkedList<>();
        q.add("0000");
        hs.add("0000");
        
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) return step;

                char[] ch = cur.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char old = ch[j];

                    // forward move
                    ch[j] = old == '9' ? '0' : (char)(old + 1);
                    String f = new String(ch);
                    if (!hs.contains(f)) {
                        hs.add(f);
                        q.add(f);
                    }

                    // backward move
                    ch[j] = old == '0' ? '9' : (char)(old - 1);
                    String b = new String(ch);
                    if (!hs.contains(b)) {
                        hs.add(b);
                        q.add(b);
                    }

                    ch[j] = old;
                }
            }
            step++;
        }
        return -1;
    }
}
