import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Set<Integer> numSet = new HashSet<>();
        int count = 0;

        for (int i : arr) {
            if (numSet.isEmpty()){
                numSet.add(i);
            }

            if (numSet.contains(x - i)){
                count++;
            }
            else {
                numSet.add(i);
            }
        }

        System.out.println(count);
        
        bw.flush();
        bw.close();
    }
}