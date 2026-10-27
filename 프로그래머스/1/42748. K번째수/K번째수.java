import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i < commands.length; i++){
            int size = commands[i][1] - commands[i][0] + 1;
            int[] tmp = new int[size];
            int k = commands[i][2];
            
            int t = 0;
            for(int j = commands[i][0] - 1 ; j < commands[i][1]; j++){
                tmp[t++] = array[j];
            }
            Arrays.sort(tmp);
            list.add(tmp[k - 1]);
        }
        
        answer = new int[list.size()];
        int x = 0;
        for(int n : list){
            answer[x++] = n;
        }
        
        return answer;
    }
}


/*
i ~ j 번 짜르기 후 정렬
k번째 수

*/
