import java.util.*;
import java.io.*;

public class Main {

    public static class MyStack {
        int[] arr;
        int position;

        public MyStack() {
            arr = new int[10001];
            position = 0;
        }

        private boolean isFull() {
            if (position == 10000) {
                return true;
            }
            return false;
        }

        private boolean isEmpty() {
            if (position == 0) {
                return true;
            }
            return false;
        }

        void size() {
            System.out.println(position);
        }

        void push(int n) {
            arr[position] = n;
            position++;
        }

        void empty() {
            if (position == 0) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
        
        void pop() {
            if (isEmpty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(arr[--position]);
        }

        void top() {
            if (isEmpty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(arr[position - 1]);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        MyStack myStack = new MyStack();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("push")) {
                myStack.push(Integer.parseInt(s[1]));
            }
            if (s[0].equals("pop")) {
                myStack.pop();
            }
            if (s[0].equals("size")) {
                myStack.size();
            }
            if (s[0].equals("empty")) {
                myStack.empty();
            }
            if (s[0].equals("top")) {
                myStack.top();
            }
        }

        bw.flush();
        bw.close();
    }
}