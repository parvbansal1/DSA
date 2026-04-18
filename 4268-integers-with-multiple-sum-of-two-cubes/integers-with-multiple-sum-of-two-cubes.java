class Solution {
    public List<Integer> findGoodIntegers(int n) {
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=1;i*i*i<=n;i++){
            for(int j=i; (i*i*i + j*j*j ) <=n;j++){
                int sum = (int)(Math.pow(i,3) + Math.pow(j,3));
                if(sum <= n){
                    hm.put(sum,hm.getOrDefault(sum,0)+1);
                }
                else break;
            }
        }
        List<Integer> ans = new ArrayList<>();
        hm.forEach((key, value) -> {
            if(value >= 2) ans.add(key);
        });
        Collections.sort(ans);
        return ans;
    }
}