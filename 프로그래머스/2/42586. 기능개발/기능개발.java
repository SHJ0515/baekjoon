import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        
        int[] dayCount = new int[progresses.length];
        for(int i=0; i < progresses.length; i++){
            if((100 - progresses[i]) % speeds[i] == 0){
                dayCount[i] = (100 - progresses[i]) / speeds[i];
            }
            else{
                dayCount[i] = (100 - progresses[i]) / speeds[i];
                dayCount[i] += 1;
            }
        }
        
        int idx = 0;
        int count = 0;
        for(int i = 0; i < dayCount.length; i++){
            if (dayCount[idx] < dayCount[i]){
                list.add(count);
                idx = i;
                count = 1;
            }
            else{
                count++;
            }
        }
        list.add(count);
        
        answer = new int[list.size()];
        int tmp = 0;
        for(int n : list){
            answer[tmp++] = n;
        }
        
        return answer;
    }
}
