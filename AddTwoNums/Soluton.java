/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    static ListNode retVal ;
    static int addIndex = 0;

    public static ListNode addTwoNumbersHelper(ListNode l1, ListNode l2) {

        if(l1 == null && l2 != null && addIndex + l2.val < 10){
            retVal = new ListNode(addIndex + l2.val, retVal  );
            addIndex = 0;
            return addTwoNumbers(null, l2.next);
        } else if(l1 == null && l2 != null && addIndex + l2.val >= 10){
            retVal = new ListNode(addIndex + l2.val-10, retVal  );
            addIndex = 1;
            return addTwoNumbers(null, l2.next) ;
        }else if(l2 == null  && l1 != null && addIndex + l1.val < 10){
            retVal = new ListNode(addIndex + l1.val, retVal  );
            addIndex = 0;
            return addTwoNumbers(null, l1.next) ;
        } else if(l2 == null  && l1 != null && addIndex + l1.val >= 10){
            retVal = new ListNode(addIndex + l1.val-10, retVal  );
            addIndex = 1;
            return addTwoNumbers(null, l1.next) ;
        } else if (l1 == null && addIndex ==0) {
            return retVal;
        }else if (l1 == null && addIndex ==1) {
            retVal = new ListNode(addIndex, retVal  );
            return retVal;
        }

        if(addIndex + l1.val + l2.val >=10 ){
            retVal = new ListNode(addIndex + l1.val + l2.val-10,retVal);
            addIndex = 1;
        }else {
            retVal = new ListNode ( addIndex+ l1.val + l2.val,retVal);
            addIndex = 0;
        }

        return addTwoNumbersHelper(l1.next, l2.next);
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next;
        ListNode newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        retVal = addTwoNumbersHelper(l1,l2);
        retVal =reverse(retVal);
        return retVal;
    }

    public static void main( String[] args){
        ListNode l = new ListNode(9);
        l = new ListNode(9,l);
        l = new ListNode(9,l);
        l = new ListNode(9,l);
        l = new ListNode(9,l);
        l = new ListNode(9,l);
        l = new ListNode(9,l);

        ListNode k = new ListNode(9);
        k = new ListNode(9,k);
        k = new ListNode(9,k);
        k = new ListNode(9,k);

        ListNode ret = addTwoNumbers(l,k);

       ret=  reverse(ret);
    }
}