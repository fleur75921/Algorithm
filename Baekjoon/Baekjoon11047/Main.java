import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] list = new int[N];
		int pos = N-1;
		int res = 0;
		for(int i=0;i<N;i++) {
			list[i] = Integer.parseInt(br.readLine());
			if(list[i] > K) {
				pos = i-1;
				break;
			}
		}
		for(int i=pos;i>=0;i--) {
			res += K / list[i];
			if(K % list[i] == 0) {
				break;
			}
			K %= list[i];
		}
		System.out.println(res);
		br.close();
	}
}
