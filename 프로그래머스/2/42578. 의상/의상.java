import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        
        for(int i=0; i< clothes.length;i++){
            String part = clothes[i][1];
            map.put(part, map.getOrDefault(part, 0) + 1);
        }

        for(String part : map.keySet()){
            answer = answer * (map.get(part)+1);
        }
        answer = answer - 1;
        return answer;
    }
}

/*
특정 종류의 옷 n개 -> n개 + 안입는 경우 n+1개의 가짓수
특정 종류의 옷 x개 -> x개 + 안입는 경우 x+1개의 가짓수

두 옷을 섞어서 입는 경우 -> (n+1) * (x+1) 개의 가짓수
여기서 아무것도 안입는 경우 1개 제외

따라서 (n+1) * (x+1) - 1

*/


