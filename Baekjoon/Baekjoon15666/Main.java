import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	static int N, M;
	static int[] input;
	static int[] res;
	static StringBuilder sb;
	
	static void r_comb(int n, int start) {
		if(n == M) {
			for(int i=0;i<M;i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			return;
		}
		int last = 0;
		for(int i=start;i<N;i++) {
			if(input[i] == last) {
				continue;
			}
			res[n] = input[i];
			r_comb(n+1, i);
			last = input[i];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		res = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		r_comb(0, 0);
		System.out.print(sb);
		br.close();
	}
}
