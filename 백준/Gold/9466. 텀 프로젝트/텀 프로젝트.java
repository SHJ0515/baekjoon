import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;   // 지목한 학생 (pick)
    static int[] state; // 학생의 상태 (0: 미방문, x: x번 학생부터 시작된 탐색 중, -1: 사이클 확정)
    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            state = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (state[i] == NOT_VISITED) {
                    run(i);
                }
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                // 사이클(-1)에 포함되지 않은 사람들의 수를 카운트
                if (state[i] != CYCLE_IN) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void run(int x) {
        int cur = x;
        while (true) {
            state[cur] = x; // 현재 방문 중인 경로에 '시작점 ID(x)'를 각인
            cur = arr[cur]; // 다음 학생으로 이동

            // 1. 이번 탐색(세션 x)에서 이미 지나간 학생을 다시 만났을 때 -> 사이클 발견!
            if (state[cur] == x) {
                // 사이클의 시작점부터 다시 한 바퀴 돌며 -1(성공)로 마킹
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = arr[cur];
                }
                return;
            }
            
            // 2. 이전에 이미 탐색이 끝난 학생(0이 아님)을 만났을 때 -> 이번엔 사이클 없음
            else if (state[cur] != NOT_VISITED) {
                return;
            }
        }
    }
}