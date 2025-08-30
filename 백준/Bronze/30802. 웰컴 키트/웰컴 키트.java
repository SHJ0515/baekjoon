
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] tokens = br.readLine().split(" ");
        int[] size = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            size[i] = Integer.parseInt(tokens[i]);
        }

        String[] TP = br.readLine().split(" ");
        int T = Integer.parseInt(TP[0]);
        int P = Integer.parseInt(TP[1]);

        int tCount = 0;

        for (int i = 0; i < size.length; i++) {

            if (size[i] % T == 0) {
                tCount += size[i] / T;
            }
            else {
                tCount += size[i] / T + 1;
            }

        }

        System.out.println(tCount);
        System.out.println(n/P + " " + n%P);

        br.close();
        bw.close();
    }
}
