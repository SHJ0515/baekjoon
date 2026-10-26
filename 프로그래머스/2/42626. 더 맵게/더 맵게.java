import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int count = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        while(true){
            int min = pq.remove();            
            if(min >= K){
                break;
            }
            else{
                if(pq.isEmpty()){
                    answer = -1;
                    break;
                }
                
                int min2 = pq.remove();
                pq.add(min + min2 * 2);
                count++;
            }
        }
        
        if(answer != -1){
            answer = count;
        }
        
        return answer;
    }
}