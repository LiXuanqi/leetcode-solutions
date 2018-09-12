/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) {
            return new ListNode[k];
        }
        ListNode curr = root;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        int numberOfEveryGroup = count / k;
        int restNumber = count % k;
        ListNode[] result = new ListNode[k];
        curr = root;
        for (int i = 0; i < k; i++) {
            int counter = 1;
            result[i] = curr;
            while (counter != numberOfEveryGroup + (i < restNumber ? 1 : 0) && curr != null) {
                curr = curr.next;
                counter++;
            }
            if (curr == null) {
                break;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return result;
    }
}
// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
//          s
//                   f
//                              l

// 1 2 3
//   s
//     d
//       f
//       g
//       h
