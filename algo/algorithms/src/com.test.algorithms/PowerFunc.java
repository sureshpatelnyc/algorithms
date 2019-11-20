package com.test.algorithms;

public class PowerFunc {
    int power(int num, int exp){
        if(exp == 1){
            return num;
        }else if(exp%2 == 1){
            return num * power(num, exp-1);
        }else{
            num = num * num;
            return power(num, exp/2);
        }

    }
    public static void main(String args[]){
        PowerFunc pf = new PowerFunc();
        System.out.print(pf.power(2,7));
    }
}
