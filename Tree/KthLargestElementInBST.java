/*
Given a Binary Search Tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.

Example 1:

Input:
      4
    /   \
   2     9
k = 2 
Output: 4
*/

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split("  ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
            // Get the current node's value from the string
            String currVal = ip[i];
            // If the left child is not null
            if (!currVal.equals("N")) {
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
            // For the right child
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            // If the right child is not null
            if (!currVal.equals("N")) {
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine());
            Solution g = new Solution();
            System.out.println(g.kthLargest(root, k));
            t--;
        }
    }
}

// User function Template for Java
class Solution {
    // return the Kth largest element in the given BST rooted at 'root'
    private int count = 0; // Counter to keep track of the visited nodes
    private int kthLargestElement = -1; // To store the Kth largest element

    // Recursive function to find the Kth largest element
    private void reverseInOrder(Node root, int K) {
        if (root == null || count >= K)
            return;

        // Traverse the right subtree first
        reverseInOrder(root.right, K);

        // Increment the count
        count++;

        // If we have reached the Kth element, store it
        if (count == K)
            kthLargestElement = root.data;

        // Traverse the left subtree
        reverseInOrder(root.left, K);
    }

    // Function to return the Kth largest element in the BST
    public int kthLargest(Node root, int K) {
        // Reset the count and result for each test case
        count = 0;
        kthLargestElement = -1;

        // Start the reverse in-order traversal
        reverseInOrder(root, K);

        return kthLargestElement;
    }
}
