
public class NSolution {
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
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
        static int carr = 0;
        public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            if (l1 == null && l2 != null) {
                int carrtemp = carr;
                carr = carry(0,l2.val,carr);
                return new ListNode(Math.abs((carrtemp+l2.val)%10),
                        addTwoNumbers(null,l2.next));
            } else if(l1 != null && l2 == null){
                int carrtemp = carr;
                carr = carry(l1.val,0,carr);
                return new ListNode(Math.abs((carrtemp+l1.val)%10),
                        addTwoNumbers(l1.next,null));
            }else if(l1 == null ){
                if(carr ==1 ){
                    return new ListNode(carr);
                } else {return null;}
            }

            int carrtemp = carr;
            carr = carry(l1.val,l2.val,carr);
            return new ListNode(Math.abs((carrtemp+ l1.val + l2.val) % 10),
                        addTwoNumbers(l1.next, l2.next));

        }

        public static ListNode addTwoNumbersHelper(ListNode l1, ListNode l2){
            carr = carry(l1.val,l2.val,carr);
            return new ListNode(Math.abs((l1.val+l2.val)%10),
                    addTwoNumbers(l1.next,l2.next));
        }

        public static int carry(int a,int b,int c){
            return (a+b+c)/10;
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

        ListNode ret = addTwoNumbersHelper(l,k);
        while (ret != null){
            System.out.print(ret.val + ",");
            ret = ret.next;
        }

        ListNode ll = new ListNode(1);
        ll = new ListNode(9,ll);
        ll = new ListNode(9,ll);
        ListNode kk = new ListNode(1);


        ListNode rett = addTwoNumbersHelper(ll,kk);

        System.out.println();
        while (rett != null){
            System.out.print(rett.val + ",");
            rett = rett.next;
        }
    }
}
