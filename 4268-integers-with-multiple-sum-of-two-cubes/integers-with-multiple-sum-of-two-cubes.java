class Solution {
    public List<Integer> findGoodIntegers(int n) {
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=1;i*i*i<=n;i++){
            for(int j=i; (i*i*i + j*j*j ) <=n;j++){
                hm.put(i*i*i + j*j*j,hm.getOrDefault(i*i*i + j*j*j,0)+1);
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