import java.io.*;
import java.util.*;


public class Main {

    public static boolean hasVowel(String line) {
        if (line.contains("a") || line.contains("e") || line.contains("o")
                || line.contains("i") || line.contains("u")) {
            return true;
        }
        return false;
    }

    public static boolean hasTwice(String line) {
        String[] tokens = line.split("");

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i].equals(tokens[i - 1])) {
                if (!tokens[i].equals("o") && !tokens[i].equals("e")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasTriple(String line) {
        String[] tokens = line.split("");
        int vowelCount = 0;
        int count = 0;

        String vowel = "aeiou";

        for (int i = 0; i < tokens.length; i++) {
            String tmp = tokens[i];

            if (vowel.contains(tmp)){
                vowelCount++;
                count = 0;
            }
            else {
                count++;
                vowelCount = 0;
            }

            if (vowelCount==3 || count==3){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isAccept(String line) {
        if (hasVowel(line) && !hasTwice(line) && !hasTriple(line)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        String[] tokens;

        while (true) {
            line = br.readLine();
            if (line.equals("end")) {
                break;
            }

            if (isAccept(line)) {
                System.out.println("<" + line + ">" + " is acceptable.");
            }
            else {
                System.out.println("<" + line + ">" + " is not acceptable.");
            }

        }
        
        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}