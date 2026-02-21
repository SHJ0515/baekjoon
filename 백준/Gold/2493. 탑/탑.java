import java.util.*;
import java.io.*;

public class Main {

    public static class TopInfo {
        private int num;
        private int height;

        TopInfo(int num, int height) {
            this.num = num;
            this.height = height;
        }

        public int getNum() {
            return num;
        }

        public int getHeight() {
            return height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<TopInfo> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int topHeight = Integer.parseInt(st.nextToken());
            TopInfo tmp = new TopInfo(i + 1, topHeight);
            int flag = 0;

            while (flag == 0) {
                if (stack.empty()) {
                    sb.append("0 ");
                    stack.push(tmp);
                    flag = 1;
                }
                else if (stack.peek().getHeight() > tmp.getHeight()) {
                    sb.append(stack.peek().getNum() + " ");
                    stack.push(tmp);
                    flag = 1;
                }
                else if (stack.peek().getHeight() < tmp.getHeight()) {
                    stack.pop();
                }
            }
        }
        System.out.println(sb);

        bw.flush();
        bw.close();
    }
}