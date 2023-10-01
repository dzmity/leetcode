
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return divideAndConquer(lists);
    }

    private ListNode divideAndConquer(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }

        int newArrayLength = lists.length / 2 + lists.length % 2;
        ListNode[] nextLevelNodes = new ListNode[newArrayLength];

        int pointer = 0;
        int nextLevelNodesPointer = 0;
        while (pointer < lists.length) {
            if (pointer + 1 == lists.length) {
                nextLevelNodes[nextLevelNodesPointer] = lists[pointer];
                break;
            }
            nextLevelNodes[nextLevelNodesPointer] = mergeTwoLists(lists[pointer], lists[pointer + 1]);
            nextLevelNodesPointer++;
            pointer += 2;
        }
        return divideAndConquer(nextLevelNodes);
    }

    private ListNode mergeTwoLists(ListNode firstList, ListNode secondList) {
        ListNode list1 = firstList;
        ListNode list2 = secondList;
        ListNode accum = new ListNode();
        ListNode head = accum;

        while (true) {
            if (list1 == null) {
                accum.next = list2;
                break;
            }
            if (list2 == null) {
                accum.next = list1;
                break;
            }

            if (list1.val <= list2.val) {
                accum.next = list1;
                list1 = list1.next;
            } else {
                accum.next = list2;
                list2 = list2.next;
            }
            accum = accum.next;
        }
        return head.next;
    }

    private ListNode divideAndConquerRecursion(int startIndexInclusive, int endIndexExclusive, ListNode[] lists) {
        int listsNumber = endIndexExclusive - startIndexInclusive;

        if (listsNumber == 1) {
            return lists[startIndexInclusive];
        }

        if (listsNumber == 2) {
            return mergeTwoLists(lists[startIndexInclusive], lists[startIndexInclusive + 1]);
        }

        int medium = listsNumber / 2;
        ListNode firstList = divideAndConquerRecursion(startIndexInclusive, medium, lists);
        ListNode secondList = divideAndConquerRecursion(medium, endIndexExclusive, lists);
        return mergeTwoLists(firstList, secondList);
    }

    private void mergeTwoListsRecursion(ListNode firstList, ListNode secondList, ListNode accum) {
        if (firstList == null) {
            accum.next = secondList;
            return;
        }
        if (secondList == null) {
            accum.next = firstList;
            return;
        }

        if (firstList.val <= secondList.val) {
            accum.next = firstList;
            mergeTwoListsRecursion(firstList.next, secondList, accum.next);
        } else {
            accum.next = secondList;
            mergeTwoListsRecursion(firstList, secondList.next, accum.next);
        }
    }
}
