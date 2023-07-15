import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	static int N, M;
	static int[] input, result;
	static StringBuilder sb;
	
	static void r_comb(int n, int start) {
		if(n == M) {
			for(int i=0;i<M;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<N;i++) {
			result[n] = input[i];
			r_comb(n+1, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		result = new int[N];
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		r_comb(0, 0);
		System.out.print(sb);
		br.close();
	}
}
