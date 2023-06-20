import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static int cnt;
	
	static void dfs(int N) {
		if(N >= n) {
			if(N == n) {
				cnt++;
			}
			return;
		}
		dfs(N+1);
		dfs(N+2);
		dfs(N+3);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			dfs(0);
			sb.append(cnt+"\n");
		}
		System.out.print(sb);
		br.close();
	}
}
