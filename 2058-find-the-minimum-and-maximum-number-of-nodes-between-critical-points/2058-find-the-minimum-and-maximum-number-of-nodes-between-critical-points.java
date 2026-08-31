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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;
        int firstCritical = -1;
        int lastCritical = -1;
        int minDist = Integer.MAX_VALUE;
        while (curr.next != null){
            ListNode next = curr .next;
            boolean isMax = curr.val > prev.val && curr.val > next.val;
            boolean isMin = curr.val < prev.val && curr.val < next.val;

            if (isMax || isMin) {
                if (lastCritical == -1) {
                    firstCritical = index;
                }
                else {
                    minDist = Math.min(minDist, index - lastCritical);
                }
                lastCritical = index;
            }
            prev = curr;
            curr = next;
            index++;
        }
        if (firstCritical == -1 || firstCritical == lastCritical) {
            return new int[]{-1, -1};
        }
        int maxDist = lastCritical - firstCritical;
        return new int[] {minDist, maxDist};
    }
}