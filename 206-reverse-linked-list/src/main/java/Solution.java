class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currentHead = head;
        ListNode currentTail = null;

        while (currentHead != null) {
            ListNode nextHead = currentHead.next;
            currentHead.next = currentTail;
            currentTail = currentHead;
            currentHead = nextHead;
        }
        return currentTail;
    }

    private ListNode changeLinksRecursion(ListNode head, ListNode current) {
        ListNode tail = head.next;
        head.next = current;
        if (tail == null) {
            return head;
        }
        return changeLinksRecursion(tail, head);
    }
}
