package com.test.newalgo.sorting;

public class DividendDivisor {
    public static void main(String args[]){
        System.out.println(divide(-2147483648,
                -1));
    }
    public static int divide(int dividend, int divisor) {
        boolean isNegative = dividend < 0 || divisor < 0? true:false;
        if(dividend < 0 && divisor <0){
            isNegative = false;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if(dividend < 0){
            dividend = dividend+1;
            dividend = (-1 * dividend);
        }
        int quotient = 0;
        while(dividend >= divisor){
            dividend-=divisor;
            quotient++;
        }
        if(isNegative){
            return (-1 * quotient);
        }
        return quotient;
    }
}
