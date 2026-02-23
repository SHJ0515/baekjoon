import java.util.*;
import java.io.*;

public class Main {

    public static class MyQueue {
        int[] arr = new int[10001];   // idx 1 ~ 10000 까지 10000번 다 push 가능
        int head = 0;                 // 첫 원소 idx의 바로 앞
        int tail = 0;                 // 마지막 원소 idx의 위치

        public void push(int num) {
            //더 못넣음 (선형 큐 기준)
            if (tail == 10000) {
                return;
            }
            tail++;
            arr[tail] = num;
        }

        public void pop() {
            if (empty() == 1) {
                System.out.println(-1);
            }
            else {
                head++;
                System.out.println(arr[head]);
            }
        }

        //큐에 들어있는 원소 개수 출력
        public void size() {
            System.out.println(tail - head);
        }

        //큐 비어있는지 판별 비었음 = 1, 안비었음 = 0
        public int empty() {
            if (head == tail) {
                return 1;
            }
            else {
                return 0;
            }
        }

        //큐 첫 원소 출력
        public void front() {
            if (empty() == 1) {
                System.out.println(-1);
            }
            else {
                System.out.println(arr[head + 1]);
            }
        }

        //큐 마지막 원소 출력
        public void back() {
            if (empty() == 1) {
                System.out.println(-1);
            }
            else {
                System.out.println(arr[tail]);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        MyQueue myQueue = new MyQueue();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");

            switch (split[0]) {
                case "push":
                    myQueue.push(Integer.parseInt(split[1]));
                    break;
                case "pop":
                    myQueue.pop();
                    break;
                case "size":
                    myQueue.size();
                    break;
                case "empty":
                    System.out.println(myQueue.empty());
                    break;
                case "front":
                    myQueue.front();
                    break;
                case "back":
                    myQueue.back();
                    break;
                default:
            }
        }

        bw.flush();
        bw.close();
    }
}
