class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n - k + 1; i++) {
            hs.add(s.substring(i, i + k));
        }

        List<String> codes = binaryCodes(k);
        for(int i=0; i<codes.size(); i++){
            if(!hs.contains( codes.get(i)) ) return false;
        }
        return true;
    }

    public static List<String> binaryCodes(int nBits) {
        List<String> arr = new ArrayList<>();
        int maxNumber = 1 << nBits;
        for (int i = 0; i < maxNumber; i++) {
            String binary = Integer.toBinaryString(i);
            
            while (binary.length() < nBits) {
                binary = "0" + binary;
            }
            arr.add(binary);
        }
        return arr;
    }
}