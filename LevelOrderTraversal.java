package com.test.newalgo;


// Recursive Java program for level
// order traversal of Binary Tree

import java.util.LinkedList;
import java.util.Queue;

/* Class containing left and right child of current
   node and key value*/
class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }

}

class CharNode {
    char data;
    CharNode left, right;
    public CharNode(char item)
    {
        data = item;
        left = right = null;
    }
}

public class LevelOrderTraversal {
    // Root of the Binary Tree
    Node root;

    CharNode charRoot;
    public LevelOrderTraversal() { root = null; }

    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    /* Print nodes at the current level */
    void printCurrentLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    void preOrder(Node root){

        if(root == null){
            return;
        }
        System.out.print(root.data+"  ");
        preOrder(root.left);
        preOrder(root.right);

    }

    void inOrder(Node root){

        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+"  ");
        inOrder(root.right);

    }
    void postOrder(Node root){

        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+"  ");

    }
    int max = Integer.MIN_VALUE;
    int maxElement(Node root){

        if(root != null){
            int lMax = maxElement(root.left);
            int rMax = maxElement(root.right);
            if(lMax > rMax){
                max = lMax;
            }else{
                max = rMax;
            }
            if(root.data > max){
                return root.data;
            }
        }
        return max;
    }

    boolean searchElement(Node root, int x){

        if(root != null){
            if(root.data == x){
                return true;
            }
            if(searchElement(root.left,x)){
                return true;
            }
            if(searchElement(root.right, x)){
                return true;
            }
        }
        return false;
    }

    boolean search(Node node, int x){
        if(node == null){
            return false;
        }
        if(node.data == x){
            return true;
        }

        return search(node.left, x) || search(node.right, x);
    }

    boolean insertElement(Node node, int x){
        if(node != null){
            insertElement(node.left, x);
            insertElement(node.right, x);
        }
        //return new
        return false;
    }
    int size(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int cnt = 1;
        while(!queue.isEmpty()){
            Node node = queue.poll();
           cnt++;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return cnt;
    }

    int findHeight(Node root){
        if(root == null){
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if(left > right){
            return left+1;
        }
        return right +1;
    }

    int levelSum(Node root){
        int h = findHeight(root);
        for(int i=0; i<h; i++){

        }
        return 0;
    }

    int  printLevel(Node root, int level){
        if(root == null){
            return 0;
        }
        if(level == 1){
            return root.data;
        }

        return printLevel(root.left, level-1) + printLevel(root.right, level-1);

    }

    int sumOfAll(Node root){
        if(root == null){
            return 0;
        }
        return root.data + sumOfAll(root.left) + sumOfAll(root.right);

    }


    void findAncestor(Node root, int x, int level, Queue<Integer> q){
        if(root == null)
        {
            return;
        }
        if(root.data == x ){
            q.offer(level-1);
            return;
        }

        if(!q.isEmpty() && level < q.peek()){
            return;
        }

        findAncestor(root.left, x, level++, q);
        findAncestor(root.right, x, level++, q);
        System.out.print(root.data+ " ");
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LevelOrderTraversal tree = new LevelOrderTraversal();



        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
       /* tree.root.right.right.right = new Node(10);
        tree.root.left.left.left= new Node(20);
        tree.root.left.left.left.left= new Node(40);*/

        //tree.inOrder(tree.root);
        //tree.sumOfAll(tree.root);
        Queue<Integer> q = new LinkedList<>();
        tree.findAncestor(tree.root, 5, -1, q);
        //System.out.println(q.isEmpty());

    }
}