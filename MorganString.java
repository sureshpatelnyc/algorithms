package com.test.newalgo.sorting;

public class MorganString {
    public static void main(String args[]){
        MorganString morganString =new MorganString();
        morganString.getMorganString("ABACABA", "ABACABA");
    }

    void getMorganString(String a, String b){
        char[] chArr1 = a.toCharArray();
        char[] chArr2 = b.toCharArray();


        char[] output = new char[chArr1.length+chArr2.length];
        int index = 0;
        int q1Index = 0;
        int q2Index = 0;
        boolean isStrSame = false;
        while(q1Index < chArr1.length && q2Index < chArr2.length){
            if(chArr1[q1Index] < chArr2[q2Index]){
                output[index++] = chArr1[q1Index];
                q1Index++;

            } else if(!isStrSame && chArr1[q1Index] == chArr2[q2Index]){

                int m = q1Index;
                int n = q2Index;
                while(m < chArr1.length && n < chArr2.length){
                    if(chArr1[m] == chArr2[n]){
                        m++;
                        n++;
                        continue;
                    }
                    if(chArr1[m] < chArr2[n]){
                        output[index++] = chArr1[q1Index];
                        q1Index++;
                    }else if(chArr1[m] > chArr2[n]){
                        output[index++] = chArr2[q2Index];
                        q2Index++;
                    }
                    break;
                }
                if(m == n || isStrSame){
                        isStrSame = true;
                        output[index++] = chArr1[q1Index];
                        q1Index++;

                }

            }else{
                output[index++] = chArr2[q2Index];
                q2Index++;
            }
        }

        while(q1Index< chArr1.length){
            output[index++] = chArr1[q1Index++];
        }
        while(q2Index< chArr2.length){
            output[index++] = chArr2[q2Index++];
        }

        System.out.println(new String(output));
    }
}
