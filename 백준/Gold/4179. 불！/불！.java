import java.util.*;
import java.io.*;

/*
# : 벽
J : 지훈이 초기 위치
F : 불 초기 위치
. : 이동 가능 공간

J가 이동해서 . 이면서 map의 가장자리 ( x == 0 || x == n-1 || y == 0 || y == m-1 ) 이면 탈출 성공
J가 탈출하지 못했는데, 이동할 공간이 없다면 탈출 실패

J 이동 가능한 공간 넣기 -> map이 '.' 인 경우 +
F 이동 가능한 공간 넣기, 이때 J가 다음에 갈려고 넣은 곳 이어도 뺏기 가능, visited을 -1 로 체인지
 */

public class Main {

    public static class Node {
        int x;
        int y;
        char tag;

        public Node(int x, int y, char tag) {
            this.x = x;
            this.y = y;
            this.tag = tag;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        char[][] map = new char[n][m];
        int[][] visited = new int[n][m];    //지훈이가 방문 한 곳 = 거리, 불이 방문 시 -1
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int jx = 0;
        int jy = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                if (s.charAt(j) == 'J') {
                    jx = i;
                    jy = j;
                }
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(jx, jy, 'J'));
        visited[jx][jy] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'F') {
                    visited[i][j] = -1;
                    queue.add(new Node(i, j, 'F'));
                }
            }
        }

        boolean flag = false;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            char tag = poll.tag;

            if (tag == 'J') {
                // 다음에 가려던 곳을 불이 먹음
                if (visited[x][y] == -1) {
                    continue;
                }
                // 탈출 성공
                if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
                    System.out.println(visited[x][y]);
                    flag = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == '.' && visited[nx][ny] == 0) {
                            visited[nx][ny] = visited[x][y] + 1;
                            queue.add(new Node(nx, ny, 'J'));
                        }
                    }
                }
            }
            else if (tag == 'F') {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if ((map[nx][ny] == '.' || map[nx][ny] == 'J') && visited[nx][ny] != -1) {
                            visited[nx][ny] = -1;
                            queue.add(new Node(nx, ny, 'F'));
                        }
                    }
                }
            }
        }

        if (!flag) {
            System.out.println("IMPOSSIBLE");
        }
    }
}