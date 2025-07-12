/*
Reverse a Linked List in k-groups

Given a linked list and a positive number k, reverse the nodes in groups of k.

All the remaining nodes after multiples of k should be left as it is.

Example
k: 3
Linked list: 1→2→3→4→5→6→7→8→9
Result: 3→2→1→6→5→4→9→8→7
k: 3
Linked list: 1→2→3→4→5→6→7→8
Result: 3→2→1→6→5→4→7→8
Note: Solve using O(1) extra space.

Testing
Input Format
The first line contains an integer ‘T’ denoting the number of independent test cases.

For each test case the input has three lines:

An integer ‘n’ denoting the length of the linked list.
n space-separated integers denoting elements of the linked list.
An integer 'k' denoting the group size.
Output Format
For each test case, a line containing ‘n’ space-separated integers denoting the resultant linked list elements.

Sample Input
3
9
1 2 3 4 5 6 7 8 9
3
8
1 2 3 4 5 6 7 8
3
9
1 2 3 4 5 6 7 8 9
12
Expected Output
3 2 1 6 5 4 9 8 7
3 2 1 6 5 4 7 8
1 2 3 4 5 6 7 8 9
Constraints
1 <= T <= 100

1 <= n <= 10^4

1 <= k <= 10^4

1 <= element <= 1000
 */

package com.workat.tech.practice.collection;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkedListKGroup {
    public ListNode reverseLinkedListKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, nex = dummy, prev = dummy;
        // Count the number of nodes
        int count = 0;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }
        while (count >= k) {
            curr = prev.next;
            nex = curr.next;
            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            count -= k;
        }
        return dummy.next;
    }


}



