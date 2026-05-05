class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        k = k % size;
        if(k == 0) return head;
        temp = head;
        int rem = size - k;
        ListNode temp1 = head;
        ListNode temp2 = head;
        for(int i=0;i<rem-1;i++){
            temp1 = temp1.next;
        }
        temp2 = temp1.next;
        ListNode ans = temp2;
        temp1.next = null;
        while(temp2.next!=null){
            temp2 = temp2.next;
        }
        temp2.next = head;

        return ans;
    }
}