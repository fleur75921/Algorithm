import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N];
		int[][] dp = new int[N][2];
		for(int i=0;i<N;i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		dp[0][0] = stairs[0];
		if(N > 1) {
			dp[1][0] = stairs[1];
			dp[1][1] = dp[0][0] + stairs[1];
		}
		for(int i=2;i<N;i++) {
			dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stairs[i];
			dp[i][1] = dp[i-1][0] + stairs[i];
		}
		System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
		br.close();
	}
}
