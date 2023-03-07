import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int max = a;
			if(a == 0) {
				break;
			}
			int b = Integer.parseInt(st.nextToken());
			int line1 = Math.min(max, b);
			max = Math.max(max, b);
			int c = Integer.parseInt(st.nextToken());
			int line2 = Math.min(max, c);
			max = Math.max(max, c);
			if(Math.pow(line1, 2) + Math.pow(line2, 2) == Math.pow(max, 2)) {
				sb.append("right\n");
			}
			else {
				sb.append("wrong\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}
