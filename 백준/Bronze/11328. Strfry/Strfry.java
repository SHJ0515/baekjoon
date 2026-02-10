import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            isPossible(s1,s2);
        }

        bw.flush();
        bw.close();
    }

    public static void isPossible(String s1, String s2){
        int length1 = s1.length();
        int length2 = s2.length();

        if (length1 != length2){
            System.out.println("Impossible");
            return;
        }

        int[] arr = new int[26];   // 영어 소문자로만 구성

        //철자 개수가 일치한다면 결과적으로 배열값 모두 0
        for (int i = 0; i < length1; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            arr[c1 - 'a']++;
            arr[c2 - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0){
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }

}