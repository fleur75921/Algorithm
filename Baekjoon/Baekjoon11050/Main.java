import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] memo;

	// 메모이제이션, 재귀 활용 이항계수 계산 함수
	static int bc(int N, int K) {
		// 이미 계산한 적 있을 경우 그 결과를 리턴
		if(memo[N][K] != 0) {
			return memo[N][K];
		}
		else {
			// 값을 바로 알 수 있는 leaf에 도달하면 해당 값을 저장하고 리턴
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
			// leaf가 아닌 경우 재귀 활용
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
		// N과 K는 줄어들기만 하기 때문에 정확히 이 크기만 필요
		memo = new int[N+1][K+1];
		System.out.println(bc(N, K));
		br.close();
	}
}
