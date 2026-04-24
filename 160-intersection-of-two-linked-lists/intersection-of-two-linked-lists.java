public class Solution {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode temp = a;

        while(temp!=null){
            ListNode temp2 = b;
            while(temp2!=null){
                if(temp == temp2) return temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        return null;
    }
}