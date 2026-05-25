class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {

            // Duplicate found
            if (current.val == current.next.val) {

                current.next = current.next.next;
            }

            // Move forward
            else {

                current = current.next;
            }
        }

        return head;
    }
}