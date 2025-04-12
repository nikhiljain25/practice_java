package com.workat.tech.practice;

import java.util.Scanner;

public class ReverseLinkedListKGroupMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReverseLinkedListKGroup reverseLinkedListKGroup = new ReverseLinkedListKGroup();

        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            int k = sc.nextInt();

            ListNode head = buildList(arr);
            ListNode result = reverseLinkedListKGroup.reverseLinkedListKGroup(head, k);
            printList(result);
        }

        sc.close();
    }

    static ListNode buildList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

   public static class ReverseLinkedListKGroup {
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
}