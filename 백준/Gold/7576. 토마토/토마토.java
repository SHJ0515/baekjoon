import java.util.*;
import java.io.*;

public class Main {

    public static class Node {
        int x;
        int y;
        int day;   // 익는 날짜

        public Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[1]);
        int m = Integer.parseInt(split[0]);

        int[][] map = new int[n][m];          // 0 안익음 / 1 익음 / -1 벽
        int[][] visited = new int[n][m];      // 0 미방문 / 1 방문 / -1 방문 불가(벽)
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            String[] split1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split1[j]);
                if (map[i][j] == -1) {
                    visited[i][j] = -1;
                }
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        //익어 있는 토마토들
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    visited[i][j] = 1;
                    Node first = new Node(i, j, 0);
                    queue.add(first);
                }
            }
        }

        int maxDay = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.day > maxDay) {
                maxDay = currentNode.day;
            }

            for (int i = 0; i < 4; i++) {
                int nx = currentNode.x + dx[i];
                int ny = currentNode.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[nx][ny] == 0 && map[nx][ny] != -1) {
                        Node nextNode = new Node(nx, ny, currentNode.day + 1);
                        queue.add(nextNode);
                        visited[nx][ny] = 1;
                    }
                }
            }
        }

        boolean flag = true;

        for (int i = 0; i < n; i++) {
            if (flag) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j] == 0) {
                        flag = false;
                        break;
                    }
                }
            }
        }

        if (flag){
            System.out.println(maxDay);
        }
        else {
            System.out.println(-1);
        }
    }
}
