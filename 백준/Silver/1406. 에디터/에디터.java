import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int M = Integer.parseInt(br.readLine());
        // LinkedList 는 시간초과
        // ListIterator
        LinkedList<Character> list = new LinkedList<Character>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            switch (c) {
                case 'L':
                    if (iter.hasPrevious())
                        iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext())
                        iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    iter.add(t);
                    break;
                default:
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }
        System.out.println(sb);
        br.close();
        // stack

    }
}