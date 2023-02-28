import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int gcd(int max, int min) {
		if(min == 0) {
			return max;
		}
		else {
			return gcd(min, max % min);
		}
	}
	
	static int lcm(int max, int min) {
		return max * min / gcd(max, min);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		int max = Math.max(N1, N2);
		int min = Math.min(N1, N2);
		System.out.println(gcd(max, min));
		System.out.println(lcm(max, min));
		br.close();
	}
}
