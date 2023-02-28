import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		long result = 0;
		long diff = 0;
		if(2*W <= S) {
			// 가로 세로로만 이동
			result = (X + Y) * W;
		}
		else if(W <= S) {
			// min(X,Y)만큼 대각선 이동
			result += (long)Math.min(X, Y) * S;
			diff = (long)Math.max(X, Y) - (long)Math.min(X, Y);
			result += diff * W;
		}
		else {
			// 2칸이동 대각이동으로 교체
			result += (long)Math.min(X, Y) * S;
			diff = (long)Math.max(X, Y) - (long)Math.min(X, Y);
			if(diff % 2 == 0) {
				result += diff * S; 
			}
			else {
				result += (diff-1) * S;
				result += W;
			}
		}
		System.out.println(result);
		br.close();
	}
}
