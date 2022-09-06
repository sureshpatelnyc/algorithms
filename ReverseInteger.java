package com.test.newalgo.sorting;

public class ReverseInteger {
    public static void main(String args[]){
        System.out.println(reverseInt(-1563847412));
    }

    static int reverseInt(int x){
        StringBuilder sb = new StringBuilder();
        boolean isNegativeNum = x<0?true:false;

        if(x<0)
        {
            sb.append("-");
        }

        x = Math.abs(x);

        while(true){
            if(x>0) {
                int r = x % 10;
                if( (isNegativeNum && sb.length()>1) || (!isNegativeNum && sb.length()>0) || r>0){
                    sb.append(r);
                }
                x = x/10;
            }else{
                break;
            }
        }

        Long val = Long.parseLong(sb.toString());
        if(isNegativeNum && (val < Math.pow(-2, 31))){
            return 0;
        }else if(val > (Math.pow(2, 31)-1)){
            return 0;
        }
        return val.intValue();
    }
}
