class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {

        int people = schedules.length;
        int[] attendance = new int[people];
        boolean[] fail = new boolean[people];

        for (int i = 0; i < people; i++) {
            if (schedules[i] % 100 >= 50) {
                attendance[i] = schedules[i] + 50;
            }
            else {
                attendance[i] = schedules[i] + 10;
            }
        }

        int today;
        for (int i = 0; i < 7; i++) {
            today = (startday + i) % 7;

            if (today == 6 || today == 0) {
            }
            else {
                for (int j = 0; j < people; j++) {
                    if (attendance[j] < timelogs[j][i]) {
                        fail[j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < people; i++) {
            if (!fail[i]) {
                answer++;
            }
        }

        return answer;
    }
}

