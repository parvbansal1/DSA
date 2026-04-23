class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        while(head!=null){
            ans.add(head.val);
            head = head.next;
        }
        int j = ans.size() - 1, i = 0;
        while(i <= j){
            if(ans.get(i) != ans.get(j)) return false;
            i++; 
            j--;
        }
        return true;
    }
}