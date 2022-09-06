package com.test.newalgo;

import java.util.ArrayList;
import java.util.List;

public class SortTwoLinkedList {
    public static void main(String args[]){
        SortTwoLinkedList sortTwoLinkedList = new SortTwoLinkedList();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        a.add(5);
        a.add(7);
        a.add(10);
        b.add(-1);
        b.add(2);
        b.add(6);
        b.add(12);
        //b.add(-1);
        System.out.println(sortTwoLinkedList.mergeList(a,b,c,0,0));
    }

    List<Integer> mergeList(List<Integer> a, List<Integer> b, List<Integer> c, int aSize, int bSize){
        if(aSize == a.size() ){
            for(int i=bSize; i<b.size();i++)
                c.add(b.get(i));
            return c;
        }
        if(bSize == b.size()){
            for(int i=aSize; i<a.size();i++)
                c.add(a.get(i));

            return c;
        }


        List<Integer> list = null;
        if(a.get(aSize) <= b.get(bSize)){
            c.add(a.get(aSize));
            aSize++;
            return mergeList(a,b,c,aSize, bSize);
        }

        if(a.get(aSize) >= b.get(bSize)){
            c.add(b.get(bSize));
            bSize++;
            return mergeList(a,b,c,aSize, bSize);
        }
        return c;
    }
}
