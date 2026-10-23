import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        
        for(String s : phone_book){
            s = s.replace(" ","");
            set.add(s);
        }
        
        for(String cur : set){
            
            int tmp = 1;
            while(tmp < cur.length()){
                if(set.contains(cur.substring(0,tmp))){
                    answer = false;
                    break;
                }
                tmp++;
            }
        
            if(!answer){
                break;
            }            
        }
        
        return answer;
    }
}
