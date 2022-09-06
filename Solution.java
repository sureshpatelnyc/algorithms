package com.test.newalgo.sorting;
import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
        // Write your code here
        char[] strA = a.toCharArray();
        char[] strB = b.toCharArray();
        int maxLen = strA.length > strB.length ? strB.length : strA.length;
        int cnt = 0;
        Map<Character, Integer> aMap = new HashMap<>();

        for(char c : strA){
            if(!aMap.containsKey(c)){
                aMap.put(c, 1);
            }else{
                int currCnt = aMap.get(c);
                aMap.put(c, (currCnt+1));
            }
        }
        for(char c: strB){
            if(aMap.containsKey(c)){
                int currCnt = aMap.get(c);
                aMap.put(c, (currCnt-1));
            }else{
                cnt++;
            }
        }
        for(char c: aMap.keySet()){
            cnt = cnt + aMap.get(c);
        }
        return cnt;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedReader.close();
    }
}
