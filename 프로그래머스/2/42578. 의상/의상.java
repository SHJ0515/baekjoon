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

