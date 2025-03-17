
import java.io.*;
import java.util.*;



public class Main {

    public static void isRight(int a, int b, int c) {
        int[] abc = {a, b, c};
        Arrays.sort(abc);

        if (abc[2] * abc[2] == abc[1] * abc[1] + abc[0] * abc[0]){
            System.out.println("right");
        }
        else {
            System.out.println("wrong");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens;
        while (true) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            if (a == 0 & b == 0 & c == 0) {
                break;
            }
            else {
                isRight(a, b, c);
            }
        }
        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}
