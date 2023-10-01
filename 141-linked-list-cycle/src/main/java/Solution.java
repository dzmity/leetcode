import java.util.HashSet;

public class Solution {

    /**
     * Two pointers solution.
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        boolean hasCycle = false;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            if (fastPointer == slowPointer || fastPointer.next == slowPointer) {
                hasCycle = true;
                break;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return hasCycle;
    }

    public boolean hasCycleUsingHashSet(ListNode head) {
        if (head == null) {
            return false;
        }

        HashSet<ListNode> values = new HashSet<>();
        boolean hasCycle = false;
        ListNode node = head;
        while (node.next != null) {
            if (!values.add(node)) {
                hasCycle = true;
                break;
            }
            node = node.next;
        }

        return hasCycle;
    }
}