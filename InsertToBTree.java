package com.test.newalgo;


import java.util.Scanner;

public class InsertToBTree {

        public static void preOrder( BNode root ) {

            if( root == null)
                return;

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);

        }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

        public static BNode insert(BNode root,int data) {
            BNode original = root;
            insertHelper(root, data);
            //print(original);
            return original;

        }

        static void insertHelper(BNode root, int data){
            if(root == null){
                root = new BNode(data);
                return;
            }
            if(data > root.data ){
                if(root.right == null){
                    root.right = new BNode(data);
                    return;
                }
                insertHelper(root.right, data);
            }else if(data < root.data){
                if(root.left == null){
                    root.left = new BNode(data);
                    return;
                }
                insertHelper(root.left, data);
            }
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int t = scan.nextInt();
            BNode root = null;
            while(t-- > 0) {
                int data = scan.nextInt();
                root = insert(root, data);
            }
            scan.close();
            preOrder(root);
        }

}

    class BNode {
        BNode left;
        BNode right;
        int data;

        BNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

