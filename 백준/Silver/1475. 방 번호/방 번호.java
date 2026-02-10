import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //StringTokenizer st = new StringTokenizer(br.readLine());

        int[] count = new int[10];

        int n = Integer.parseInt(br.readLine());
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }

        int tmp = (count[6] + count[9] + 1) / 2;

        count[6] = tmp;
        count[9] = tmp;

        Arrays.sort(count);
        System.out.println(count[9]);

        bw.flush();
        bw.close();
    }
}