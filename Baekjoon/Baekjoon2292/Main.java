import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		double cal = 12 * N - 3;
		cal = Math.sqrt(cal);
		cal = (cal + 3) / 6;
		System.out.println((int)Math.ceil(cal));
		br.close();
	}
}
