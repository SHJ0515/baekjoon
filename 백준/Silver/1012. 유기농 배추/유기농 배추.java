import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < T; i++) {
            int bugCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            int[][] visited = new int[N][M];

            //배추 위치 1 세팅
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            Queue<int[]> queue = new ArrayDeque<>();

            //BFS
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 시작지점 : 배추인 땅 + 미방문
                    if (map[j][k] == 1 && visited[j][k] == 0) {
                        bugCount++;
                        queue.add(new int[]{j, k});
                        visited[j][k] = 1;

                        while (!queue.isEmpty()) {
                            int[] poll = queue.poll();

                            for (int l = 0; l < 4; l++) {
                                int nx = poll[0] + dx[l];
                                int ny = poll[1] + dy[l];

                                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                                    if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
                                        queue.add(new int[]{nx, ny});
                                        visited[nx][ny] = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(bugCount);
        }
    }
}


/*
이어진 배추에 흰지렁이 한마리 있으면 됨
1 : 배추 있음
0 : 배추 없음
필요한 벌레의 수 찾기

테스트 케이스 수
M N K
배추 위치
...

배열을 돌면서 BFS 시작지점 찾기
시작지점 : 배추가 심어져 있으면서 아직 방문하지 않은 경우.
-> 큐에 넣고 BFS를 돌리기.



 */