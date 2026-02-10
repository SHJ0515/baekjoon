import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] arr = new int[26];
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            arr[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            count += Math.abs(arr[i]);
        }
        System.out.println(count);

        bw.flush();
        bw.close();
    }
}
/*
단어의 철자 순서 바꿧을때 같아진다면 애너그램 e.g occurs 와 succor 은 애너그램 관계
두 단어가 주어졌을때, 서로 애너그램 관계가 되기 위해서 지워야할 문자의 개수가 몇개인지 찾기

단어1, 단어2의 스펠링 개수 구하기
단어1 - 단어2 했을때 0이 아닌 스펠링 개수들 존재 -> -이든 + 이든 관계 없이 절대값 취해서 모두 더하면, 그 개수만큼 지워야함
 */