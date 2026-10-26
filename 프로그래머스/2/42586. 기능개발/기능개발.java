
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int[] dayCount = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                dayCount[i] = (100 - progresses[i]) / speeds[i];
            } else {
                dayCount[i] = (100 - progresses[i]) / speeds[i];
                dayCount[i] += 1;
            }
        }


        Deque<Integer> deque = new ArrayDeque<>();

        for (int day : dayCount) {
            deque.offerFirst(day);
        }


        while (!deque.isEmpty()) {
            int baseDay = deque.removeLast();
            int count = 1;

            while (!deque.isEmpty() && deque.peekLast() <= baseDay) {
                deque.removeLast();
                count++;
            }

            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

