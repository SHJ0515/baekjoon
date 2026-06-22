class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int tmp = x;
        int temp = 0;
        while(tmp > 0 ){
            temp += tmp % 10;
            tmp = tmp / 10;
        }
        
        if(x % temp != 0){
            answer = false;
        }
        
        
        return answer;
    }
}