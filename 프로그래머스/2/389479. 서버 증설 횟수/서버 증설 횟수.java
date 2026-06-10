class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        int[] times = new int[24];    //시간대별 가용 인원 수 (기본은 m-1 명, 증설 x 기준)
        for (int i = 0; i < 24; i++) {
            times[i] = m - 1;
        }

        for (int i = 0; i < 24; i++) {
            if (players[i] > times[i]) {
                int tmp = players[i] - times[i];
                if (tmp % m == 0) {
                    tmp = tmp / m;
                }
                else {
                    tmp = tmp / m + 1;
                }

                for (int j = i; j < i + k; j++) {
                    if (j < 24) {
                        times[j] = times[j] + tmp * m;
                    }
                }
                answer = answer + tmp;
            }
        }
        return answer;
    }
}