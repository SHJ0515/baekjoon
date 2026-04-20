

import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] tmp;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        map = new int[n][m];
        tmp = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int count = icebergCount();
            if (count == 0) {
                System.out.println(0);
                break;
            }
            else if (count > 1) {
                System.out.println(year);
                break;
            }
            melt();
            year++;
        }
        br.close();
    }

    // 빙산 개수 리턴
    public static int icebergCount() {
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //미방문 빙산 bfs
                if (map[i][j] != 0 && visited[i][j] == 0) {
                    count++;
                    visited[i][j] = 1;
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (map[nx][ny] != 0 && visited[nx][ny] == 0) {
                                    queue.add(new int[]{nx, ny});
                                    visited[nx][ny] = 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        clear(visited);
        return count;
    }

    public static void melt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    int count = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (map[nx][ny] == 0) {
                                count++;
                            }
                        }
                    }
                    tmp[i][j] = count;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] -= tmp[i][j];
                if (map[i][j] < 0) {
                    map[i][j] = 0;
                }
            }
        }
        clear(tmp);
    }

    public static void clear(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
            }
        }
    }
}