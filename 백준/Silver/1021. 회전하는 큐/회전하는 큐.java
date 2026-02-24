
import java.util.*;
import java.io.*;

public class Main {

    public static void moveLeft(LinkedList<Integer> deque) {
        Integer i = deque.pollFirst();
        deque.addLast(i);
    }

    public static void moveRight(LinkedList<Integer> deque) {
        Integer i = deque.pollLast();
        deque.addFirst(i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = 0;
        LinkedList<Integer> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            deque.addLast(i);   // 1 2 3 4 .... n-1 n
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int idx = deque.indexOf(num);
            int current_size = deque.size();

            if (idx <= current_size / 2){
                for (int j = 0; j < idx; j++) {
                    count++;
                    moveLeft(deque);
                }
                deque.pollFirst();
            }
            else {
                for (int j = 0; j < current_size - idx; j++) {
                    count++;
                    moveRight(deque);
                }
                deque.pollFirst();
            }
        }

        System.out.println(count);


        bw.flush();
        bw.close();
    }
}