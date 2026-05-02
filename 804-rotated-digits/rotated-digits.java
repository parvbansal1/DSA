class Solution {
    public int rotatedDigits(int n) {
        HashSet<Integer> hs1 = new HashSet<>();
        List<Integer> list = Arrays.asList(2,5,6,9);
        hs1.addAll(list);
        HashSet<Integer> hs2 = new HashSet<>();
        List<Integer> list2 = Arrays.asList(3,4,7);
        hs2.addAll(list2);
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int num = i;
            boolean valid = false;
            while(num!=0){
                int digit = num % 10;
                if(hs1.contains(digit)) valid = true;
                if(hs2.contains(digit)){
                    break;
                } 
                num = num/10;
                if(num == 0 && valid) ans++;
            }
        }
        return ans;
    }
}