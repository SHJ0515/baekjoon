import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;  // 각 원소의 부모를 저장하는 배열
    static int[] size;    // 각 집합의 크기를 저장하는 배열

    // find 연산: 원소 x가 속한 집합의 대표자를 찾음
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // 경로 압축
        }
        return parent[x];
    }

    // union 연산: 두 집합을 합침
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // Union by size: 작은 집합을 큰 집합에 합침
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

    // check 연산: 두 원소가 같은 집합에 속하는지 확인
    public static void check(int a, int b) {
        if (find(a) == find(b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens;
        int n, m;

        tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        // Union-Find 초기화
        parent = new int[n + 1];
        size = new int[n + 1];

        // 각 원소는 자기 자신을 부모로 설정하고, 크기는 1로 설정
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int t1 = Integer.parseInt(tokens[1]);
            int t2 = Integer.parseInt(tokens[2]);

            if (tokens[0].equals("0")) {
                // union 연산
                union(t1, t2);
            } else if (tokens[0].equals("1")) {
                // check 연산
                check(t1, t2);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
