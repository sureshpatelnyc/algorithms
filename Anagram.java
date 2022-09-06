package com.test.newalgo;

import java.util.*;

public class Anagram {
    public static void main(String args[]){
        Anagram anagram = new Anagram();
        String[][] output = anagram.findAnagrams();
        //for(int i=0;i<output)
    }

    String[][] findAnagrams(){
        List<AnagramStr> list = new ArrayList<>();
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        for(int i =0; i<arr.length; i++){

            list.add(new AnagramStr(arr[i].toCharArray(), i));
        }

        Collections.sort(list, new Comparator<AnagramStr>() {
            @Override
            public int compare(AnagramStr o1, AnagramStr o2) {
                String s1= new String(o1.getS());
                String s2= new String(o2.getS());
                return s1.compareTo(s2);
            }
        });

        AnagramStr anagramStr = list.get(0);
        String[][] output = new String[10][10];
        int i=0;
        int j=0;
        for(int k=0;k<list.size()-1; k++){

            if(list.get(k).getS().equals(list.get(k+1).getS())){
                output[i][j] = arr[anagramStr.getI()];
                j++;
            }else{
                i++;
                j=0;
                output[i][j] = arr[anagramStr.getI()];
            }

        }
        return output;
    }
}
class AnagramStr{
    private char[] arr;
    private int i;

    public AnagramStr(char[] arr, int i){
        this.arr = arr;
        this.i = i;
    }

    public char[] getS() {
        Arrays.sort(arr);
        return arr;
    }

    public void setS(char[] s) {
        this.arr = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
