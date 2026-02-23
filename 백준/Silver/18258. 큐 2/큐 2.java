
import java.util.*;
import java.io.*;

public class Main {
    public static class MyQueue {
        int[] arr = new int[2000001];
        int head = 0;
        int tail = 0;

        public void push(int num) {
            arr[++tail] = num;
        }

        public int pop() {
            if (empty() == 1) return -1;
            return arr[++head];
        }

        public int size() {
            return tail - head;
        }

        public int empty() {
            return (head == tail) ? 1 : 0;
        }

        public int front() {
            if (empty() == 1) return -1;
            return arr[head + 1];
        }

        public int back() {
            if (empty() == 1) return -1;
            return arr[tail];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(); // 결과 담을 바구니
        MyQueue myQueue = new MyQueue();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    myQueue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(myQueue.pop()).append('\n');
                    break;
                case "size":
                    sb.append(myQueue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(myQueue.empty()).append('\n');
                    break;
                case "front":
                    sb.append(myQueue.front()).append('\n');
                    break;
                case "back":
                    sb.append(myQueue.back()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
        bw.flush();
        bw.close();
    }
}