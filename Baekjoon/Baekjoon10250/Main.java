import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int H, N, Q, R;
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			st.nextToken();
			N = Integer.parseInt(st.nextToken())-1;
			Q = N / H;
			R = N % H;
			sb.append(R+1);
			if(Q < 9) {
				sb.append(0);
			}
			sb.append(Q+1);
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
