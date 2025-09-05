
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();


        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        
        while (queue.size() != 1){
            queue.poll();
            Integer poll = queue.poll();
            queue.add(poll);
        }

        Integer peek1 = queue.peek();
        System.out.println(peek1);

        br.close();
        bw.close();
    }
}
