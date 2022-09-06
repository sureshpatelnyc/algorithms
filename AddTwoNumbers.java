package com.test.newalgo.sorting;

public class AddTwoNumbers
{

    public static void main(String args[]){
        new AddTwoNumbers().callTwoNumber();
    }
    void callTwoNumber(){
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next = null;

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = null;

        ListNode l3 = solution.addTwoNumbers(l1, l2);
        while(null != l3){
            System.out.print(l3.val +" ");
            l3 = l3.next;
        }
    }

  public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode head = new ListNode();
            ListNode output = head;
            while(null != l1 || null != l2 ){

                int l1Val = null != l1 ? l1.val: 0;
                int l2Val = null != l2 ? l2.val :0;

                int sumVal = carry + l1Val  + l2Val;
                carry = 0;
                if(sumVal >= 10){
                    sumVal = sumVal % 10;
                    carry = 1;
                }
                output.val = sumVal;

                l1 = null != l1 ? l1.next : null;
                l2 = null != l2 ? l2.next : null;

                if(null != l1 || null != l2 || carry == 1){
                    output.next = new ListNode();
                    output = output.next;

                }

            }

            if(carry == 1){
                output.val = 1;
            }

            output.next = null;

            return head;
        }
    }

}
