
import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;


public class Main {

    public static boolean isPalindrome(String s) {
        //정규식으로 유효한 문자만 추출한 다음 모두 소문자로 변경
        String s_filtered = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        // 문자열을 뒤집은 다음 String 으로 변경
        /*
        new StringBuilder(s_filterd) 로 StringBuilder 객체를 생성 -> .reverse()로 문자열 뒤집기
         -> .toString()으로 StringBuilder 자료형을 String 자료형으로 변환
         */
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();

        // 두 문자열이 동일한지 비교, 동일하다면 true 다르면 false return
        return s_filtered.equals(s_reversed);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            String s = br.readLine();
            if (s.equals("0")){
                break;
            }

            if (isPalindrome(s)){
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }

        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}
