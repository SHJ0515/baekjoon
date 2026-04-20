import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static int[][] visited;
    static int n;
    static int islandCount = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        counts();

        System.out.println(findPath());
    }

    //섬 간 최단경로 찾기
    public static int findPath() {
        int min = n * n;
        for (int i = 1; i <= islandCount; i++) {
            int length = find(i);
            clear(visited);
            if (length < min) {
                min = length;
            }
        }
        return min;
    }

    public static int find(int start) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == start) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int dist = poll[2];

            if (map[x][y] != start && map[x][y] != 0) {
                return dist - 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] != start && visited[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny, dist + 1});
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
        return n * n;
    }

    //섬마다 넘버링, 총 섬 개수 체크
    public static void counts() {
        Queue<int[]> queue = new ArrayDeque<>();
        int tmp = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    map[i][j] = tmp;

                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
                                    map[nx][ny] = tmp;
                                    visited[nx][ny] = 1;
                                    queue.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    tmp++;
                }
            }
        }
        islandCount = tmp;
        clear(visited);
    }

    public static void clear(int[][] tmp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = 0;
            }
        }
    }

}