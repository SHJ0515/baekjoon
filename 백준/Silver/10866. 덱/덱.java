
import java.util.*;
import java.io.*;

public class Main {
    public static class MyDeque {
        int[] arr = new int[10001];
        int head = 0;  //첫번째 데이터의 바로 앞 idx, 배열 중 한칸 비어있어야 할 공간
        int tail = 0;  //마지막 데이터의 해당 idx
        int capacity = 10001;  //배열 전체 사이즈

        public boolean isFull() {
            if ((tail + 1) % capacity == head) {
                return true;
            }
            return false;
        }

        public void push_front(int x) {
            if (!isFull()) {
                arr[head] = x;
                head = (head - 1 + capacity) % capacity;
            }
        }

        public void push_back(int x) {
            if (!isFull()) {
                tail = (tail + 1) % capacity;
                arr[tail] = x;
            }
        }

        public int pop_front() {
            if (empty() == 1) {
                return -1;
            }
            head = (head + 1) % capacity;
            return arr[head];
        }

        public int pop_back() {
            if (empty() == 1) {
                return -1;
            }
            int num = arr[tail];
            tail = (tail - 1 + capacity) % capacity;
            return num;
        }

        public int size() {
            int size = (tail - head + capacity) % capacity;
            return size;
        }

        public int empty() {
            if (head == tail) {
                return 1;
            }
            return 0;
        }

        public int front() {
            if (empty() == 1) {
                return -1;
            }
            return arr[(head + 1) % capacity];
        }

        public int back() {
            if (empty() == 1) {
                return -1;
            }
            return arr[tail];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        MyDeque myDeque = new MyDeque();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    myDeque.push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    myDeque.push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(myDeque.pop_front()).append('\n');
                    break;
                case "pop_back":
                    sb.append(myDeque.pop_back()).append('\n');
                    break;
                case "size":
                    sb.append(myDeque.size()).append('\n');
                    break;
                case "empty":
                    sb.append(myDeque.empty()).append('\n');
                    break;
                case "front":
                    sb.append(myDeque.front()).append('\n');
                    break;
                case "back":
                    sb.append(myDeque.back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);

        bw.flush();
        bw.close();
    }
}