class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int valueToAdd = 0;
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode head = new ListNode();
        ListNode result = head;
        while (list1 != null && list2 != null) {
            int v1 = list1.val;
            int v2 = list2.val;
            int sum = (v1 + v2 + valueToAdd);
            result.next = new ListNode(sum % 10);

            result = result.next;
            valueToAdd = sum / 10;
            list1 = list1.next;
            list2 = list2.next;
        }

        if (list1 == null && list2 == null) {
            if (valueToAdd != 0) {
                result.next = new ListNode(valueToAdd);
            }
        } else if (list1 == null) {
            result.next = addValueToList(valueToAdd, list2);
        } else {
            result.next = addValueToList(valueToAdd, list1);
        }

        return head.next;
    }

    private ListNode addValueToList(int value, ListNode list) {
        int valueToAdd = value;
        ListNode l = list;
        ListNode head = new ListNode();
        ListNode result = head;
        while (valueToAdd != 0) {
            if (l == null) {
                result.next = new ListNode(valueToAdd);
                valueToAdd = 0;
            } else {
                result.next = new ListNode((l.val + valueToAdd) % 10);
                valueToAdd = (l.val + valueToAdd) / 10;
                l = l.next;
            }
            result = result.next;
        }
        result.next = l;
        return head.next;
    }
}
