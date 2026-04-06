import java.util.*;
import java.io.*;

public class Main {
    static int[] pick;
    static int[] state; // 0: 미방문, 1: 탐색 중, 2: 탐색 완료
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            pick = new int[n + 1];
            state = new int[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                pick[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (state[i] == 0) {
                    stackDfs(i);
                }
            }
            System.out.println(n - count);
        }
    }

    public static void stackDfs(int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        
        while (!stack.isEmpty()) {
            int curr = stack.peek();

            if (state[curr] == 0) {
                // 처음 방문하는 경우 '탐색 중'으로 표시
                state[curr] = 1;
                int next = pick[curr];

                if (state[next] == 0) {
                    // 다음 노드가 미방문이면 스택에 넣고 더 깊이 이동
                    stack.push(next);
                } else if (state[next] == 1) {
                    // 💡 사이클 발견! (현재 스택에 있는 노드를 다시 만남)
                    // 사이클에 포함된 인원 카운트
                    count++; // 자기 자신(next) 포함
                    for (int i = pick[next]; i != next; i = pick[i]) {
                        count++;
                        if (i == curr) break; // 루프 안전 장치
                    }
                    // 사이클을 발견했으니 이제 되돌아감
                    state[curr] = 2;
                    stack.pop();
                } else {
                    // 이미 결론 난 노드(state 2)를 만난 경우
                    state[curr] = 2;
                    stack.pop();
                }
            } else {
                // 자식 노드들을 다 보고 다시 돌아온 경우 (탐색 종료)
                state[curr] = 2;
                stack.pop();
            }
        }
    }
}