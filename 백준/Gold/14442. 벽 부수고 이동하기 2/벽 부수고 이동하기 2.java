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
        visited = new int[n][m][k + 1];   // 안부심 ~ k개 부심 총 k + 1 칸

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';     // 0 or 1
            }
        }

        findPath();

        br.close();
    }

    public static void findPath() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});  // n m k
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int z = poll[2];

            // 도착 시
            if (x == n - 1 && y == m - 1) {
                System.out.println(visited[x][y][z]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 벽이지만 부수기 횟수 남아있는 경우
                    if (map[nx][ny] == 1 && z != k) {
                        if (visited[nx][ny][z + 1] == 0) {
                            queue.add(new int[]{nx, ny, z + 1});
                            visited[nx][ny][z + 1] = visited[x][y][z] + 1;
                        }
                    }
                    if (map[nx][ny] == 0 && visited[nx][ny][z] == 0) {
                        queue.add(new int[]{nx, ny, z});
                        visited[nx][ny][z] = visited[x][y][z] + 1;
                    }
                }
            }
        }
        //도착 못할 시
        System.out.println(-1);
    }
}