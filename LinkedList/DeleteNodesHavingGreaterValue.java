/*
Given a singly linked list, remove all the nodes in the list which have any node on their right whose value is greater. (Not just immidiate Right , but entire List on the Right)

 

Example 1:

Input:
LinkedList = 12->15->10->11->5->6->2->3
Output: 15 11 6 3
Explanation: Since, 12, 10, 5 and 2 are
the elements which have greater elements
on the following nodes. So, after deleting
them, the linked list would like be 15,
11, 6, 3
*/
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    public static void print(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt()) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt(); i++) {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }

            Solution solution = new Solution();
            Node result = solution.compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}

class Solution {
    Node compute(Node head) {
        Node curr;
        Node temp;
        
        if(head==null || head.next==null){
            
            return head;
            
        }
        
        curr=head;
        temp=compute(head.next);
        
       if(curr.data<temp.data){
           
           curr=temp;
           head=curr;
           
       }else{
           
           curr.next=temp;
           head=curr;
           
       }
        return head;
    }
}

