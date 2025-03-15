
import java.io.*;
import java.util.*;

public class Main {

    public static void findRoom(int h, int w, int n) {
        int floor;
        int room;

        if (n % h == 0) {
            floor = h;
            room = n / h;
        }
        else {
            floor = n % h;
            room = n / h + 1;
        }

        System.out.println(floor * 100 + room);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens;

        int t = Integer.parseInt(br.readLine());
        int h, w, n;

        for (int i = 0; i < t; i++) {
            tokens = br.readLine().split(" ");
            h = Integer.parseInt(tokens[0]);
            w = Integer.parseInt(tokens[1]);
            n = Integer.parseInt(tokens[2]);
            findRoom(h, w, n);
        }

        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}