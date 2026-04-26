import java.util.*;
import java.io.*;

public class Main {

    static int n, m, k;
    static int[][] map;
    static int[][][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        k = Integer.parseInt(split[2]);
        map = new int[n][m];
        visited = new int[n][m][k + 1];        //맨 마지막 낮 밤 체크 필요?

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        findPath();

        br.close();
    }

    public static void findPath() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0, 0, 1});          // x, y, z, time, dist
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int z = poll[2];
            int time = poll[3];
            int dist = poll[4];

            //도착
            if (x == n - 1 && y == m - 1) {
                System.out.println(dist);
                return;
            }

            // 다음 방향 탐사
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //맵 안에 있을 때
                if (inMap(nx, ny)) {
                    // 벽이고, 벽 파괴횟수가 남아 있고, 미방문 시
                    if (map[nx][ny] == 1 && z != k && visited[nx][ny][z + 1] == 0) {
                        //현재 낮인 경우 벽 부수고 이동
                        if (time == 0) {
                            queue.add(new int[]{nx, ny, z + 1, 1, dist + 1});
                            visited[nx][ny][z + 1] = 1;
                        }
                        //현재 밤인 경우 한턴 대기
                        else if (time == 1) {
                            queue.add(new int[]{x, y, z, 0, dist + 1});
                        }
                    }

                    if (map[nx][ny] == 0 && visited[nx][ny][z] == 0) {
                        queue.add(new int[]{nx, ny, z, (time + 1) % 2, dist + 1});
                        visited[nx][ny][z] = 1;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static boolean inMap(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return true;
        }
        return false;
    }
}