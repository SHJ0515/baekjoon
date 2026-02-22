import java.util.*;
import java.io.*;

public class Main {

    public static class Building {
        int idx;
        int height;

        public Building(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public int getIdx() {
            return idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long cnt = 0;
        Stack<Building> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int idx = i + 1;
            int height = Integer.parseInt(br.readLine());
            Building building = new Building(idx, height);

            // 스택에서 내 빌딩보다 키가 작은 놈들은 다 나한테 막히니 의미가 없다. 따라서 pop 해버림
            while (!stack.empty() && stack.peek().getHeight() <= building.getHeight()) {
                stack.pop();
            }

            // 스택에 빌딩이 남아 있다면 나보다 키가 큰 놈이므로 나를 관측 가능 + peek이 스택에 있는 빌딩 중 가장 작은 놈일 것이므로
            // 스택에 있는 모든 빌딩이 나를 관측 가능 따라서 cnt = cnt + stack.size();

            if (!stack.empty()){
                cnt = cnt + stack.size();
            }
            //현재 빌딩 스택에 추가
            stack.push(building);
        }

        System.out.println(cnt);

        bw.flush();
        bw.close();
    }
}