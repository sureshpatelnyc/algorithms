package com.test.newalgo.sorting;

public class Mulitiplication {
    public static void main(String args[]){

    }

    private String multiply(String num1, String num2){

        char[] c1 = num1.toCharArray();
        char[] c2 = num1.toCharArray();
        char[] m1 = new char[c1.length+c2.length];

        for(int k=0; k< m1.length; k++){
            m1[k] = 0;
        }

        int startIndex = 0;

        if(c1.length > c2.length){

            startIndex = m1.length- (c2.length-1)-1;

            for(int i=0; i<c2.length; i++){
                int carry = 0;
                for(int j=c1.length; j>=0; j--){
                    int prod = (int) c2[i] * (int) c1[j];

                    if(prod > 10){
                        int reminder = prod%10;
                        carry = prod/10;
                    }




                }
            }
        }

        return null;
    }
}
