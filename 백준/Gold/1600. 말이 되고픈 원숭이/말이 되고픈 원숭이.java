import java.util.*;
import java.io.*;

public class Main {

    static int n, m, k;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] horseX = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] horseY = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[1]);
        m = Integer.parseInt(split[0]);

        map = new int[n][m];
        visited = new int[n][m][k + 1]; // k 차원확장

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findPath();

        br.close();
    }

    public static void findPath() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0, 0});     // n m k dist
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int z = poll[2];
            int dist = poll[3];

            //도착
            if (x == n - 1 && y == m - 1) {
                System.out.println(dist);
                return;
            }

            //말처럼 이동 가능 시
            if (z < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + horseX[i];
                    int ny = y + horseY[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] != 1 && visited[nx][ny][z + 1] == 0) {
                            queue.add(new int[]{nx, ny, z + 1, dist + 1});
                            visited[nx][ny][z+1] = 1;
                        }
                    }
                }
            }
            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] != 1 && visited[nx][ny][z] == 0) {
                        queue.add(new int[]{nx, ny, z, dist + 1});
                        visited[nx][ny][z] = 1;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
