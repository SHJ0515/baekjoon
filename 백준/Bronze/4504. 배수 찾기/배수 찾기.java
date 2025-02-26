import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String[] tokens;

        int n = Integer.parseInt(br.readLine());

        while (true) {
            int target = Integer.parseInt(br.readLine());
            if (target == 0) {
                break;
            }
            else if (target % n == 0){
                System.out.println(target + " is a multiple of " + n + ".");
            }
            else {
                System.out.println(target + " is NOT a multiple of " + n + ".");
            }
        }


        br.close(); // BufferedReader 닫기
        bw.flush();
        bw.close();
    }
}