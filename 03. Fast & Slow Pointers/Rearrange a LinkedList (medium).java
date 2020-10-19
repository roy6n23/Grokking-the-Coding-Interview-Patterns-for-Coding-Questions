
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class RearrangeList {

  public static void reorder(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode reverseSecondHalf = reverse(slow);

    while(head != null && reverseSecondHalf != null){
      ListNode temp1 = head.next;
      ListNode temp2 = reverseSecondHalf;
      head.next = reverseSecondHalf;
      head = temp1;
      reverseSecondHalf.next = head;
      reverseSecondHalf = temp2;
    }

    if(reverseSecondHalf.next != null)
      reverseSecondHalf.next.next = null;

  }

  private static ListNode reverse(ListNode head){
    ListNode prev = null;
    while(head != null){
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);
    head.next.next.next.next.next = new ListNode(12);
    RearrangeList.reorder(head);
    while (head != null) {
      System.out.print(head.value + " ");
      head = head.next;
    }
  }
}