
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        Set<Integer> set = new HashSet<>();
        for (String string : s) {
            set.add(Integer.parseInt(string));
        }

        int m = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            int tmp = Integer.parseInt(input[i]);
            if (set.contains(tmp)) {
                bw.write(1 + "\n");
            }
            else {
                bw.write(0 + "\n");
            }
        }
        br.close();
        bw.close();
    }
}