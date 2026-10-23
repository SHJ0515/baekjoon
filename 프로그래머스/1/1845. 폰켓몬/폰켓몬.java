import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int pickCount = nums.length / 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        
        for(int num : map.keySet()){
            pickCount--;
            answer++;
            
            if(pickCount == 0){
                break;
            }
        }
        return answer;
    }
}