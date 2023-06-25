import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int root = (int)Math.sqrt(n);
		int[] dp = new int[n+1];
		int pow;
		for(int i=1;i<=n;i++) {
			dp[i] = i;
		}
		for(int i=2;i<=root;i++) {
			pow = i * i;
			for(int j=pow;j<=n;j++) {
				if(dp[j-pow] + 1 < dp[j]) {
					dp[j] = dp[j-pow] + 1;
				}
			}
		}
		System.out.println(dp[n]);
		br.close();
	}
}
