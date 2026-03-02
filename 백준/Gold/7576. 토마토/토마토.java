import java.util.*;
import java.io.*;

public class Main {
    // 1. Node 클래스에서 day를 제거하고 map에 직접 거리를 기록하는 방식으로 최적화 가능
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로

        int[][] map = new int[n][m];
        Queue<Node> queue = new ArrayDeque<>();
        int unripeCount = 0; // 안 익은 토마토 개수 추적

        // 2. 입력과 동시에 익은 토마토는 큐에 넣고, 안 익은 토마토는 카운트합니다.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new Node(i, j));
                } else if (map[i][j] == 0) {
                    unripeCount++;
                }
            }
        }

        // 처음부터 다 익어있는 상태라면 바로 0 출력
        if (unripeCount == 0) {
            System.out.println(0);
            return;
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int days = 0;

        // 3. BFS 시작
        while (!queue.isEmpty() && unripeCount > 0) {
            int size = queue.size();
            days++; // 한 "레벨(하루)"씩 탐색

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0) {
                        map[nr][nc] = 1; // 익음 처리 (visited 역할 겸함)
                        unripeCount--;   // 남은 개수 감소
                        queue.add(new Node(nr, nc));
                    }
                }
            }
        }

        // 4. 모든 탐색 후에도 안 익은 토마토가 남았다면 -1, 아니면 경과일 출력
        System.out.println(unripeCount == 0 ? days : -1);
    }
}