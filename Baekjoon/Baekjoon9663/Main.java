import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	static int N;
	static int res;
	static boolean[][] board;
	
	static boolean check(int r, int c) {
		int j = c-1, cnt = 1;
		while(j >= 0) {
			if(board[r][j]) {
				return false;
			}
			if(r-cnt >=0 && board[r-cnt][j]) {
				return false;
			}
			if(r+cnt < N && board[r+cnt][j]) {
				return false;
			}
			j--;
			cnt++;
		}
		return true;
	}

	static void dfs(int n) {
		if(n == N) {
			res++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(!check(i, n)) {
				continue;
			}
			board[i][n] = true;
			dfs(n+1);
			board[i][n] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		res = 0;
		board = new boolean[N][N];
		dfs(0);
		System.out.println(res);
		br.close();
	}
}
