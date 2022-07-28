package com.rafalovich.leetcode;

class Solution {
    public ListNode middleNode(ListNode head) {
        var slowPointer = head;
        var fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
}
