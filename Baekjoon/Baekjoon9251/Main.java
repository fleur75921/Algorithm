import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int sizeA = a.length();
		int sizeB = b.length();
		int[][] dp = new int[sizeA+1][sizeB+1];
		for(int i=1;i<=sizeA;i++) {
			for(int j=1;j<=sizeB;j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[sizeA][sizeB]);
		br.close();
	}
}
