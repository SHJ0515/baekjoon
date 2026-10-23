import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(arr[0]);
        for(int i = 1; i < arr.length; i++ ){
            if(deque.peekFirst() == arr[i]){
                continue;
            }
            deque.addFirst(arr[i]);
        }
        
        answer = new int[deque.size()];
        
        int tmp = 0;
        while(!deque.isEmpty()){
            answer[tmp++] = deque.removeLast();
        }
        
        return answer;
    }
}