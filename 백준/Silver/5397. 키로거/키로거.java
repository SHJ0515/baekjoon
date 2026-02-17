import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            List<Character> list = new LinkedList<>();
            ListIterator<Character> listIterator = list.listIterator();

            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                switch (c) {
                    case '<':
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        break;

                    case '>':
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        break;

                    case '-':
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                            listIterator.remove();
                        }
                        break;
                    default:
                        listIterator.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Character c : list) {
                sb.append(c);
            }
            System.out.println(sb);
        }


        bw.flush();
        bw.close();
    }
}