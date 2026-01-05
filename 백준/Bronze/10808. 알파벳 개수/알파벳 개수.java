import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] alphabetCount = new int[26];

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alphabetCount[c - 'a']++;
        }

        for (int i : alphabetCount) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }
}