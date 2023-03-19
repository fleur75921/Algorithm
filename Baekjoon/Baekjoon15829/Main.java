import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long result = 0;
		long cur;
		for(int i=0;i<L;i++) {
			cur = str.charAt(i) - 96;
			for(int j=0;j<i;j++) {
				cur *= 31;
				cur %= 1234567891;
			}
			result += cur;
			result %= 1234567891;
		}
		System.out.println(result);
		br.close();
	}
}
