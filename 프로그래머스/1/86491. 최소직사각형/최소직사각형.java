import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;
        int height = 0;
        
        for(int i = 0 ; i < sizes.length;i++){
            //더 긴게 가로가 되도록 
            if(sizes[i][0] < sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }    
        }
        
        for(int i = 0 ; i < sizes.length;i++){
            if(sizes[i][0] > width){
                width = sizes[i][0];
            }
            if(sizes[i][1] > height){
                height = sizes[i][1];
            }
        }
        
        answer = width * height;
        return answer;
    }
}
/*
명함의 가로 세로 길이
명함을 눕혀서 가로와 세로를 바꾸기 가능
모든 명함을 수납 가능한 가장 작은 지갑 만들기
*/