import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] memo;

	static int bc(int N, int K) {
		if(memo[N][K] != 0) {
			return memo[N][K];
		}
		else {
			if(N == K) {
				memo[N][K] = 1;
				return 1;
			}
			if(K == 1) {
				memo[N][K] = N;
				return N;
			}
			if(K == 0) {
				memo[N][K] = 1;
				return 1;
			}
			int result = bc(N-1, K) + bc(N-1, K-1);
			memo[N][K] = result;
			return result;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		memo = new int[N+1][K+1];
		System.out.println(bc(N, K));
		br.close();
	}
}
