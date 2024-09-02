import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" "); // 한 줄에 입력된 두 숫자를 공백으로 분리
  	int input1 = Integer.parseInt(inputs[0]);
    int input2 = Integer.parseInt(inputs[1]);
		System.out.println(input1 + input2);
	}
}