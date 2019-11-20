package com.test.algorithms;

import java.util.Scanner;

public class BinaryTreeWithArray {

    private static Integer[] a = new Integer[100];

    static void  insert(int index, int val) {
        if(a[index] == null) {
            a[index] = val;
            return;
        }
        if(val > a[index]) {
            insert((2*index +2), val);
        }else {
            insert((2*index +1), val);
        }

    }

    void remove(int val) {

    }

    static int search(int index, int val) {
        if(a[index] == null) {
            return -1;
        }
        if(a[index] == val)
            return index;
        if(a[index] < val) {
            return search((2*index+2), val);
        }else {
            return search((2*index+1), val);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            Integer val = scan.nextInt();
            if(val == -1) {
                break;
            }
            insert(0,val);
        }

        System.out.println("Enter value to search: ");
        int searchVal = scan.nextInt();
        int index = search(0, searchVal);
        System.out.println("Index of searched value: " +index);



    }
}
